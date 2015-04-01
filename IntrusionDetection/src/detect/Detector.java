package detect;

import jpcap.packet.*;
import rules.Rule;
import java.lang.Integer;
/**
 * 使用已编辑的规则，检测数据包是否符合要求
 * 
 * @author 张广
 * 
 */
public class Detector {

	Rule r = null;

	Packet p = null;

	/**
	 * 初始化检测器
	 * 
	 * @param rule
	 *            所要检测的规则
	 * @param packet
	 *            所要检测的数据包
	 */
	public Detector(Rule rule, Packet packet) {
		r = rule;
		p = packet;
	}

	/**
	 * 匹配IP
	 * 
	 * @param ruleIP
	 *            规则规定的IP（范围）
	 * @param PacketIP
	 *            包的IP
	 * @return true:匹配（所谓的匹配是指packetIP满足ruleIP的范围或规定）； false:不匹配
	 */
	private boolean matchIP(String ruleIP, String packetIP) {
		if (ruleIP.equals("any"))
			return true;
		else if (ruleIP.charAt(0) == '!') {
			String ip = ruleIP.substring(1, ruleIP.length());
			if (!ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))
				return false;
			return (!ip.equals(packetIP));

		} else {
			if (!ruleIP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))
				return false;
			return ruleIP.equals(packetIP);
		}
	}

	/**
	 * 匹配Port
	 * 
	 * @param rulePort
	 *            规则规定的Port（范围）
	 * @param PacketPort
	 *            包的Port
	 * @return true:匹配（所谓的匹配是指packetPort满足rulePort的范围或规定）；false:不匹配
	 */
	private boolean matchPort(String rulePort, String packetPort) {

		if (rulePort.equals("any"))
			return true;
		else if (rulePort.charAt(0) == '!') {
			String port = null;
			port = rulePort.substring(1, rulePort.length());
			if (port.matches("\\d{1,5}:\\d{1,5}")) {
				String[] num = port.split(":");
				if (Integer.parseInt(num[1]) <= Integer.parseInt(packetPort)
						&& Integer.parseInt(num[2]) >= Integer
								.parseInt(packetPort))
					return false;
				else
					return true;
			} else if (port.matches("\\d{1,5}")) {
				if (Integer.parseInt(port) == Integer.parseInt(packetPort))
					return false;
				else
					return true;
			} else
				return false;
		} else {
			if (rulePort.matches("\\d{1,5}:\\d{1,5}")) {
				String[] num = rulePort.split(":");
				if (Integer.parseInt(num[1]) <= Integer.parseInt(packetPort)
						&& Integer.parseInt(num[2]) >= Integer
								.parseInt(packetPort))
					return false;
				else
					return true;
			} else if (rulePort.matches("\\d{1,5}")) {
				if (Integer.parseInt(rulePort) == Integer.parseInt(packetPort))
					return false;
				else
					return true;
			} else
				return false;

		}
	}

	
	/**
	 * 检测TTL选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param num
	 *            String类型的TTL选项（格式:[>|<]num）
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectTTL(boolean isNot, String num) {
		IPPacket ip = (IPPacket) p;
		if (num.matches(">[0-9]+")) {
			String Num = num.substring(1);
			if (ip.hop_limit > Integer.parseInt(Num))
				return isNot ? false : true;
			else
				return isNot ? true : false;
		} else if (num.matches("<[0-9]+")) {
			String Num = num.substring(1);
			if (ip.hop_limit < Integer.parseInt(Num))
				return isNot ? false : true;
			else
				return isNot ? true : false;
		} else {
			if (ip.hop_limit == Integer.parseInt(num))
				return isNot ? false : true;
			else
				return isNot ? true : false;
		}
		// return isNot ? true : false;
	}

	/**
	 * 检测ID选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param num
	 *            String类型的ID选项的数字
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectID(boolean isNot, String num) {
		IPPacket ip = (IPPacket) p;
		if (String.valueOf(ip.ident).equals(num)) {
			return isNot ? false : true;
		} else {
			return isNot ? true : false;
		}
	}

	/**
	 * 检测Size选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param num
	 *            String类型的Size选项（格式:[>|<]num）
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectSize(boolean isNot, String num) {
		if (num.matches(">[0-9]+")) {
			String Num = num.substring(1);
			if (p.caplen > Integer.parseInt(Num))
				return isNot ? false : true;
			else
				return isNot ? true : false;
		} else if (num.matches("<[0-9]+")) {
			String Num = num.substring(1);
			if (p.caplen < Integer.parseInt(Num))
				return isNot ? false : true;
			else
				return isNot ? true : false;
		} else {
			if (p.caplen == Integer.parseInt(num))
				return isNot ? false : true;
			else
				return isNot ? true : false;
		}
		// return isNot ? true : false;
	}

	/**
	 * 检测Content选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param content
	 *            String类型的Content选项（格式:content:"Str" [,nocase] [, Num:Num]
	 *            或content:"|HexNum|" [,nocase] [,Num:Num]）
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectContent(boolean isNot, String content) {
		byte[] bytes = new byte[p.header.length + p.data.length];

		System.arraycopy(p.header, 0, bytes, 0, p.header.length);
		System.arraycopy(p.data, 0, bytes, p.header.length, p.data.length);

		String[] c = content.split(",");
		switch (c.length) {
		case 1: {
			if (c[0].substring(0, 2).equals("\"|")
					&& c[0].substring(2, c[0].length() - 2).matches(
							"[0-9A-Fa-f]+")
					&& c[0].substring(c[0].length() - 2, c[0].length()).equals(
							"|\"")) {
				String HexStr = c[0].substring(2, c[0].length() - 2);
				StringBuffer buf = new StringBuffer();
				for (int i = 0; i < bytes.length; i++) {
					String d = Integer.toHexString((int) (bytes[i] & 0xff));
					buf.append(d.length() == 1 ? "0" + d : d);
				}
				for (int i = 0; i < buf.toString().length() - HexStr.length()
						+ 1; i++) {
					if (buf.substring(i, i + HexStr.length()).equals(HexStr))
						return isNot ? false : true;// 发现匹配
				}
			} else {
				String str = c[0].substring(1, c[0].length() - 1);
				for (int i = 0; i < bytes.length; i++)
					if (bytes[i] < 32 || bytes[i] > 126)
						bytes[i] = 46;
				String buf = new String(bytes);
				for (int i = 0; i < buf.length() - str.length() + 1; i++) {
					if (buf.substring(i, i + str.length()).equals(str))
						return isNot ? false : true;// 发现匹配
				}
			}
		}
			break;
		case 2: {
			if (c[1].equals("nocase")) {
				c[0] = c[0].toLowerCase();
				if (c[0].substring(0, 2).equals("\"|")
						&& c[0].substring(2, c[0].length() - 2).matches(
								"[0-9A-Fa-f]+")
						&& c[0].substring(c[0].length() - 2, c[0].length())
								.equals("|\"")) {
					String HexStr = c[0].substring(2, c[0].length() - 2);
					StringBuffer buf = new StringBuffer();
					for (int i = 0; i < bytes.length; i++) {
						String d = Integer.toHexString((int) (bytes[i] & 0xff));
						buf.append(d.length() == 1 ? "0" + d : d);
					}
					String StrBuf = buf.toString().toLowerCase();
					for (int i = 0; i < StrBuf.length() - HexStr.length() + 1; i++) {
						if (StrBuf.substring(i, i + HexStr.length()).equals(
								HexStr))

							return isNot ? false : true;// 发现匹配

					}
				} else {
					String str = c[0].substring(1, c[0].length() - 1);
					for (int i = 0; i < bytes.length; i++)
						if (bytes[i] < 32 || bytes[i] > 126)
							bytes[i] = 46;
					String buf = new String(bytes);
					buf = buf.toLowerCase();
					for (int i = 0; i < buf.length() - str.length() + 1; i++) {
						if (buf.substring(i, i + str.length()).equals(str))
							return isNot ? false : true;// 发现匹配
					}
				}
			} else {
				String[] num = c[1].split(":");
				int offset = Integer.parseInt(num[0]);//开始的位置
				int depth = Integer.parseInt(num[1]);//结束的位置，不是深度
				depth = depth >= bytes.length || depth == 0 ? bytes.length
						: depth;

				if (c[0].substring(0, 2).equals("\"|")
						&& c[0].substring(2, c[0].length() - 2).matches(
								"[0-9A-Fa-f]+")
						&& c[0].substring(c[0].length() - 2, c[0].length())
								.equals("|\"")) {
					String HexStr = c[0].substring(2, c[0].length() - 2);
					StringBuffer buf = new StringBuffer();
					for (int i = offset; i < depth; i++) {
						String d = Integer.toHexString((int) (bytes[i] & 0xff));
						buf.append(d.length() == 1 ? "0" + d : d);
					}
					for (int i = 0; i < buf.toString().length()
							- HexStr.length() + 1; i++) {
						if (buf.substring(i, i + HexStr.length())
								.equals(HexStr))
							return isNot ? false : true;// 发现匹配
					}
				} else {
					String str = c[0].substring(1, c[0].length() - 1);
					for (int i = 0; i < bytes.length; i++)
						if (bytes[i] < 32 || bytes[i] > 126)
							bytes[i] = 46;
					String buf = new String(bytes, offset, depth - offset);
					for (int i = 0; i < buf.length() - str.length() + 1; i++) {
						if (buf.substring(i, i + str.length()).equals(str))
							return isNot ? false : true;// 发现匹配
					}
				}
			}

		}
			break;
		case 3: {
			c[0] = c[0].toLowerCase();
			String[] num = c[2].split(":");
			int offset = Integer.parseInt(num[0]);
			int depth = Integer.parseInt(num[1]);
			depth = depth >= bytes.length || depth == 0 ? bytes.length : depth;

			if (c[0].substring(0, 2).equals("\"|")
					&& c[0].substring(2, c[0].length() - 2).matches(
							"[0-9A-Fa-f]+")
					&& c[0].substring(c[0].length() - 2, c[0].length()).equals(
							"|\"")) {
				String HexStr = c[0].substring(2, c[0].length() - 2);
				StringBuffer buf = new StringBuffer();

				for (int i = offset; i < depth; i++) {
					String d = Integer.toHexString((int) (bytes[i] & 0xff));
					buf.append(d.length() == 1 ? "0" + d : d);
				}
				String StrBuf = buf.toString().toLowerCase();
				for (int i = 0; i < StrBuf.length() - HexStr.length() + 1; i++) {
					if (StrBuf.substring(i, i + HexStr.length()).equals(HexStr))
						return isNot ? false : true;// 发现匹配
				}
			} else {
				String str = c[0].substring(1, c[0].length() - 1);
				for (int i = 0; i < bytes.length; i++)
					if (bytes[i] < 32 || bytes[i] > 126)
						bytes[i] = 46;
				String buf = new String(bytes, offset, depth - offset);
				buf = buf.toLowerCase();
				for (int i = 0; i < buf.length() - str.length() + 1; i++) {
					if (buf.substring(i, i + str.length()).equals(str))
						return isNot ? false : true;// 发现匹配
				}
			}

		}
			break;
		default: {
			return isNot ? true : false;
		}
		}
		return isNot ? true : false;
	}

	/**
	 * 检测Flags选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param flags
	 *            String类型的Flags选项（f|s|r|p|a|u|2|1中的一个或多个，重复只算一个）
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectFlags(boolean isNot, String flags) {
		boolean isMatched = true;
		TCPPacket tcp = (TCPPacket) p;
		for (int i = 0; i < flags.length(); i++) {
			switch (flags.charAt(i)) {
			case 'f':
				if (!tcp.fin)
					isMatched = false;
				break;
			case 's':
				if (!tcp.syn)
					isMatched = false;
				break;
			case 'r':
				if (!tcp.rst)
					isMatched = false;
				break;
			case 'p':
				if (!tcp.psh)
					isMatched = false;
				break;
			case 'a':
				if (!tcp.ack)
					isMatched = false;
				break;
			case 'u':
				if (!tcp.urg)
					isMatched = false;
				break;
			case '2':
				if (!tcp.rsv2)
					isMatched = false;
				break;
			case '1':
				if (!tcp.rsv1)
					isMatched = false;
				break;
			default:
				isMatched = false;
			}

			if (!isMatched)
				return isNot ? true : false;

		}

		return isNot ? false : true;

	}

	/**
	 * 检测Seq选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param num
	 *            String类型的Seq选项的数字
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectSeq(boolean isNot, String num) {
		TCPPacket tcp = (TCPPacket) p;
		if (String.valueOf(tcp.sequence).equals(num)) {
			return isNot ? false : true;
		} else {
			return isNot ? true : false;
		}
	}

	/**
	 * 检测Ack选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param num
	 *            String类型的Ack选项的数字
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectAck(boolean isNot, String num) {
		TCPPacket tcp = (TCPPacket) p;
		if (String.valueOf(tcp.ack_num).equals(num)) {
			return isNot ? false : true;
		} else {
			return isNot ? true : false;
		}
	}

	/**
	 * 检测Itype选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param num
	 *            String类型的Itype选项的数字
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectItype(boolean isNot, String num) {
		ICMPPacket icmp = (ICMPPacket) p;
		if (String.valueOf(icmp.type).equals(num)) {
			return isNot ? false : true;
		} else {
			return isNot ? true : false;
		}
	}

	/**
	 * 检测Icmp_id选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param num
	 *            String类型的Icmp_id选项的数字
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectIcmp_id(boolean isNot, String num) {
		ICMPPacket icmp = (ICMPPacket) p;
		if (String.valueOf(icmp.id).equals(num)) {
			return isNot ? false : true;
		} else {
			return isNot ? true : false;
		}
	}

	/**
	 * 检测Icmp_Seq选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param num
	 *            String类型的Icmp_Seq选项的数字
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectIcmp_seq(boolean isNot, String num) {
		ICMPPacket icmp = (ICMPPacket) p;
		if (String.valueOf(icmp.seq).equals(num))
			return isNot ? false : true;
		else
			return isNot ? true : false;

	}

	/**
	 * 检测IPoption选项
	 * 
	 * @param isNot
	 *            是否取反
	 * @param option
	 *            String类型的IPoption选项（rr|eol|op|ts|sec|lsrr|srr|satid中的一个）
	 * @return 符合要求返回true，否则返回false
	 */
	private boolean detectIPoption(boolean isNot, String option) {
		IPPacket ip = (IPPacket) p;
		if (ip.option != null) {
			// rr|eol|nop|ts|sec|lsrr|srr|satid
			if (option.equals("rr") && (new Byte(ip.option[0]).intValue() == 7))
				return isNot ? false : true;
			if (option.equals("eol")
					&& (new Byte(ip.option[0]).intValue() == 0))
				return isNot ? false : true;
			if (option.equals("nop")
					&& (new Byte(ip.option[0]).intValue() == 1))
				return isNot ? false : true;
			if (option.equals("eol")
					&& (new Byte(ip.option[0]).intValue() == 0))
				return isNot ? false : true;
			if (option.equals("ts")
					&& (new Byte(ip.option[0]).intValue() == 68))
				return isNot ? false : true;
			if (option.equals("sec")
					&& (new Byte(ip.option[0]).intValue() == 130))
				return isNot ? false : true;
			if (option.equals("lsrr")
					&& (new Byte(ip.option[0]).intValue() == 131))
				return isNot ? false : true;
			if (option.equals("srr")
					&& (new Byte(ip.option[0]).intValue() == 137))
				return isNot ? false : true;
			if (option.equals("satid")
					&& (new Byte(ip.option[0]).intValue() == 136))
				return isNot ? false : true;
		}

		return isNot ? true : false;

	}

	/**
	 * 包检测器
	 * 
	 * @return false:匹配 true:不匹配
	 */
	public boolean Packetdetector() {
		return true;
	}

	/**
	 * Ethernent检测器，注意，在所有选项中，Ethernet检测器只检测size一项
	 * 
	 * @return false:匹配 true:不匹配
	 */
	public boolean Ethernetdetector() {
		// 在Ethernet中只检测包的大小
		if (r.protocol != 1)
			return false;
		for (int i = 0; i < r.optionsList.size(); i++) {
			if (r.optionsList.get(i).optionType.equals("size"))
				if (!detectSize(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
		}
		return true;
	}

	/**
	 * IP检测器，检测数据包流向，源IP，目的IP，size,ttl,id,content,ipoption
	 * 
	 * @return false:匹配 true:不匹配
	 */
	public boolean IPdetector() {

		if (r.protocol != 2)
			return false;
		IPPacket ipa = (IPPacket) p;

		if (r.packetDirection.equals("->")) {
			// 流向为->
			if (!matchIP(r.getIP1(), ipa.src_ip.getHostAddress())
					|| !matchIP(r.getIP2(), ipa.dst_ip.getHostAddress()))
				return false;
		} else {
			// 流向为<>
			if ((!matchIP(r.getIP1(), ipa.src_ip.getHostAddress()) || !matchIP(
					r.getIP2(), ipa.dst_ip.getHostAddress()))
					&& (!matchIP(r.getIP2(), ipa.src_ip.getHostAddress()) || !matchIP(
							r.getIP1(), ipa.dst_ip.getHostAddress())))
				return false;
		}

		for (int i = 0; i < r.optionsList.size(); i++) {
			if (r.optionsList.get(i).optionType.equals("size")) {
				if (!detectSize(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("ttl")) {
				if (!detectTTL(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("id")) {
				if (!detectID(r.optionsList.get(i).optNot,
						r.optionsList.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("content")) {
				if (!detectContent(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("ipoption")) {
				if (!detectIPoption(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			}
		}
		return true;
	}

	/**
	 * ARP检测器,检测数据包流向，源IP，目的IP，size
	 * 
	 * @return false:匹配 true:不匹配
	 */
	public boolean ARPdetector() {
		if (r.protocol != 3)
			return false;
		ARPPacket arp = (ARPPacket) p;

		if (r.packetDirection.equals("->")) {
			// 流向为->
			if (!matchIP(r.getIP1(), arp.getSenderProtocolAddress().toString())
					|| !matchIP(r.getIP2(), arp.getTargetProtocolAddress()
							.toString()))

				return false;

		} else {
			// 流向为<>
			if ((!matchIP(r.getIP1(), arp.getSenderProtocolAddress().toString()) || !matchIP(
					r.getIP2(), arp.getTargetProtocolAddress().toString()))
					&& (!matchIP(r.getIP2(), arp.getSenderProtocolAddress()
							.toString()) || !matchIP(r.getIP1(), arp
							.getTargetProtocolAddress().toString())))
				return false;
		}

		for (int i = 0; i < r.optionsList.size(); i++) {
			if (r.optionsList.get(i).optionType.equals("size")) {
				if (!detectSize(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("content")) {
				if (!detectContent(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			}
		}

		return true;
	}

	/**
	 * TCP检测器，检测全部IP规则内容，同时检测flags,seq,ack等tcp选项
	 * 
	 * @return false:匹配 true:不匹配
	 */
	public boolean TCPdetector() {
		if (r.protocol != 4)
			return false;
		IPPacket ipa = (IPPacket) p;
		TCPPacket tcpa = (TCPPacket) p;

		if (r.packetDirection.equals("->")) {
			// 流向为->
			if (!matchIP(r.getIP1(), ipa.src_ip.getHostAddress())
					|| !matchIP(r.getIP2(), ipa.dst_ip.getHostAddress()))
				return false;
			if (!matchPort(r.getPort1(), String.valueOf(tcpa.src_port))
					|| !matchPort(r.getPort2(), String.valueOf(tcpa.dst_port)))
				return false;
		} else {
			// 流向为<>
			if ((!matchIP(r.getIP1(), ipa.src_ip.getHostAddress()) || !matchIP(
					r.getIP2(), ipa.dst_ip.getHostAddress()))
					&& (!matchIP(r.getIP2(), ipa.src_ip.getHostAddress()) || !matchIP(
							r.getIP1(), ipa.dst_ip.getHostAddress())))
				return false;
			if ((!matchPort(r.getPort1(), String.valueOf(tcpa.src_port)) || !matchPort(
					r.getIP2(), String.valueOf(tcpa.dst_port)))
					&& (!matchPort(r.getPort2(), String.valueOf(tcpa.src_port)) || !matchPort(
							r.getPort1(), String.valueOf(tcpa.dst_port))))
				return false;
		}

		for (int i = 0; i < r.optionsList.size(); i++) {
			if (r.optionsList.get(i).optionType.equals("size")) {
				if (!detectSize(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("ttl")) {
				if (!detectTTL(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("id")) {
				if (!detectID(r.optionsList.get(i).optNot,
						r.optionsList.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("content")) {
				if (!detectContent(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("ipoption")) {
				if (!detectIPoption(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("flags")) {
				if (!detectFlags(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("seq")) {
				if (!detectSeq(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("ack")) {
				if (!detectAck(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			}
		}
		return true;
	}

	/**
	 * UDP检测器，检测全部IP规则内容
	 * 
	 * @return false:匹配 true:不匹配
	 */
	public boolean UDPdetector() {
		if (r.protocol != 5)
			return false;
		IPPacket ipa = (IPPacket) p;
		UDPPacket udpa = (UDPPacket) p;

		if (r.packetDirection.equals("->")) {
			// 流向为->
			if (!matchIP(r.getIP1(), ipa.src_ip.getHostAddress())
					|| !matchIP(r.getIP2(), ipa.dst_ip.getHostAddress()))
				return false;
			if (!matchPort(r.getPort1(), String.valueOf(udpa.src_port))
					|| !matchPort(r.getPort2(), String.valueOf(udpa.dst_port)))
				return false;
		} else {
			// 流向为<>
			if ((!matchIP(r.getIP1(), ipa.src_ip.getHostAddress()) || !matchIP(
					r.getIP2(), ipa.dst_ip.getHostAddress()))
					&& (!matchIP(r.getIP2(), ipa.src_ip.getHostAddress()) || !matchIP(
							r.getIP1(), ipa.dst_ip.getHostAddress())))
				return false;
			if ((!matchPort(r.getPort1(), String.valueOf(udpa.src_port)) || !matchPort(
					r.getIP2(), String.valueOf(udpa.dst_port)))
					&& (!matchPort(r.getPort2(), String.valueOf(udpa.src_port)) || !matchPort(
							r.getPort1(), String.valueOf(udpa.dst_port))))
				return false;
		}

		for (int i = 0; i < r.optionsList.size(); i++) {
			if (r.optionsList.get(i).optionType.equals("size")) {
				if (!detectSize(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("ttl")) {
				if (!detectTTL(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("id")) {
				if (!detectID(r.optionsList.get(i).optNot,
						r.optionsList.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("content")) {
				if (!detectContent(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("ipoption")) {
				if (!detectIPoption(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			}
		}
		return true;
	}

	/**
	 * ICMP检测器，检测全部IP规则内容，同时检测itype,icmp_id,icmp_seq
	 * 
	 * @return false:匹配 true:不匹配
	 */
	public boolean ICMPdetector() {
		if (r.protocol != 6)
			return false;
		IPPacket ipa = (IPPacket) p;
		if (r.packetDirection.equals("->")) {
			// 流向为->
			if (!matchIP(r.getIP1(), ipa.src_ip.getHostAddress())
					|| !matchIP(r.getIP2(), ipa.dst_ip.getHostAddress()))
				return false;
		} else {
			// 流向为<>
			if ((!matchIP(r.getIP1(), ipa.src_ip.getHostAddress()) || !matchIP(
					r.getIP2(), ipa.dst_ip.getHostAddress()))
					&& (!matchIP(r.getIP2(), ipa.src_ip.getHostAddress()) || !matchIP(
							r.getIP1(), ipa.dst_ip.getHostAddress())))
				return false;
		}

		for (int i = 0; i < r.optionsList.size(); i++) {
			if (r.optionsList.get(i).optionType.equals("size")) {
				if (!detectSize(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("ttl")) {
				if (!detectTTL(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("id")) {
				if (!detectID(r.optionsList.get(i).optNot,
						r.optionsList.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("content")) {
				if (!detectContent(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("ipoption")) {
				if (!detectIPoption(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("itype")) {
				if (!detectItype(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("icmp_id")) {
				if (!detectIcmp_id(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("icmp_seq")) {
				if (!detectIcmp_seq(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			}
		}
		return true;
	}

	/**
	 * Other检测器
	 * 
	 * @return false:匹配 true:不匹配
	 */
	public boolean Otherdetector() {
		if (r.protocol != 7)
			return false;
		for (int i = 0; i < r.optionsList.size(); i++) {
			if (r.optionsList.get(i).optionType.equals("size")) {
				if (!detectSize(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			} else if (r.optionsList.get(i).optionType.equals("content")) {
				if (!detectContent(r.optionsList.get(i).optNot, r.optionsList
						.get(i).optionText))
					return false;
			}
		}
		return true;
	}
}