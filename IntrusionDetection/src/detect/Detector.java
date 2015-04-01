package detect;

import jpcap.packet.*;
import rules.Rule;
import java.lang.Integer;
/**
 * ʹ���ѱ༭�Ĺ��򣬼�����ݰ��Ƿ����Ҫ��
 * 
 * @author �Ź�
 * 
 */
public class Detector {

	Rule r = null;

	Packet p = null;

	/**
	 * ��ʼ�������
	 * 
	 * @param rule
	 *            ��Ҫ���Ĺ���
	 * @param packet
	 *            ��Ҫ�������ݰ�
	 */
	public Detector(Rule rule, Packet packet) {
		r = rule;
		p = packet;
	}

	/**
	 * ƥ��IP
	 * 
	 * @param ruleIP
	 *            ����涨��IP����Χ��
	 * @param PacketIP
	 *            ����IP
	 * @return true:ƥ�䣨��ν��ƥ����ָpacketIP����ruleIP�ķ�Χ��涨���� false:��ƥ��
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
	 * ƥ��Port
	 * 
	 * @param rulePort
	 *            ����涨��Port����Χ��
	 * @param PacketPort
	 *            ����Port
	 * @return true:ƥ�䣨��ν��ƥ����ָpacketPort����rulePort�ķ�Χ��涨����false:��ƥ��
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
	 * ���TTLѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param num
	 *            String���͵�TTLѡ���ʽ:[>|<]num��
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
	 * ���IDѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param num
	 *            String���͵�IDѡ�������
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
	 * ���Sizeѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param num
	 *            String���͵�Sizeѡ���ʽ:[>|<]num��
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
	 * ���Contentѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param content
	 *            String���͵�Contentѡ���ʽ:content:"Str" [,nocase] [, Num:Num]
	 *            ��content:"|HexNum|" [,nocase] [,Num:Num]��
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
						return isNot ? false : true;// ����ƥ��
				}
			} else {
				String str = c[0].substring(1, c[0].length() - 1);
				for (int i = 0; i < bytes.length; i++)
					if (bytes[i] < 32 || bytes[i] > 126)
						bytes[i] = 46;
				String buf = new String(bytes);
				for (int i = 0; i < buf.length() - str.length() + 1; i++) {
					if (buf.substring(i, i + str.length()).equals(str))
						return isNot ? false : true;// ����ƥ��
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

							return isNot ? false : true;// ����ƥ��

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
							return isNot ? false : true;// ����ƥ��
					}
				}
			} else {
				String[] num = c[1].split(":");
				int offset = Integer.parseInt(num[0]);//��ʼ��λ��
				int depth = Integer.parseInt(num[1]);//������λ�ã��������
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
							return isNot ? false : true;// ����ƥ��
					}
				} else {
					String str = c[0].substring(1, c[0].length() - 1);
					for (int i = 0; i < bytes.length; i++)
						if (bytes[i] < 32 || bytes[i] > 126)
							bytes[i] = 46;
					String buf = new String(bytes, offset, depth - offset);
					for (int i = 0; i < buf.length() - str.length() + 1; i++) {
						if (buf.substring(i, i + str.length()).equals(str))
							return isNot ? false : true;// ����ƥ��
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
						return isNot ? false : true;// ����ƥ��
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
						return isNot ? false : true;// ����ƥ��
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
	 * ���Flagsѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param flags
	 *            String���͵�Flagsѡ�f|s|r|p|a|u|2|1�е�һ���������ظ�ֻ��һ����
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
	 * ���Seqѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param num
	 *            String���͵�Seqѡ�������
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
	 * ���Ackѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param num
	 *            String���͵�Ackѡ�������
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
	 * ���Itypeѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param num
	 *            String���͵�Itypeѡ�������
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
	 * ���Icmp_idѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param num
	 *            String���͵�Icmp_idѡ�������
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
	 * ���Icmp_Seqѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param num
	 *            String���͵�Icmp_Seqѡ�������
	 * @return ����Ҫ�󷵻�true�����򷵻�false
	 */
	private boolean detectIcmp_seq(boolean isNot, String num) {
		ICMPPacket icmp = (ICMPPacket) p;
		if (String.valueOf(icmp.seq).equals(num))
			return isNot ? false : true;
		else
			return isNot ? true : false;

	}

	/**
	 * ���IPoptionѡ��
	 * 
	 * @param isNot
	 *            �Ƿ�ȡ��
	 * @param option
	 *            String���͵�IPoptionѡ�rr|eol|op|ts|sec|lsrr|srr|satid�е�һ����
	 * @return ����Ҫ�󷵻�true�����򷵻�false
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
	 * �������
	 * 
	 * @return false:ƥ�� true:��ƥ��
	 */
	public boolean Packetdetector() {
		return true;
	}

	/**
	 * Ethernent�������ע�⣬������ѡ���У�Ethernet�����ֻ���sizeһ��
	 * 
	 * @return false:ƥ�� true:��ƥ��
	 */
	public boolean Ethernetdetector() {
		// ��Ethernet��ֻ�����Ĵ�С
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
	 * IP�������������ݰ�����ԴIP��Ŀ��IP��size,ttl,id,content,ipoption
	 * 
	 * @return false:ƥ�� true:��ƥ��
	 */
	public boolean IPdetector() {

		if (r.protocol != 2)
			return false;
		IPPacket ipa = (IPPacket) p;

		if (r.packetDirection.equals("->")) {
			// ����Ϊ->
			if (!matchIP(r.getIP1(), ipa.src_ip.getHostAddress())
					|| !matchIP(r.getIP2(), ipa.dst_ip.getHostAddress()))
				return false;
		} else {
			// ����Ϊ<>
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
	 * ARP�����,������ݰ�����ԴIP��Ŀ��IP��size
	 * 
	 * @return false:ƥ�� true:��ƥ��
	 */
	public boolean ARPdetector() {
		if (r.protocol != 3)
			return false;
		ARPPacket arp = (ARPPacket) p;

		if (r.packetDirection.equals("->")) {
			// ����Ϊ->
			if (!matchIP(r.getIP1(), arp.getSenderProtocolAddress().toString())
					|| !matchIP(r.getIP2(), arp.getTargetProtocolAddress()
							.toString()))

				return false;

		} else {
			// ����Ϊ<>
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
	 * TCP����������ȫ��IP�������ݣ�ͬʱ���flags,seq,ack��tcpѡ��
	 * 
	 * @return false:ƥ�� true:��ƥ��
	 */
	public boolean TCPdetector() {
		if (r.protocol != 4)
			return false;
		IPPacket ipa = (IPPacket) p;
		TCPPacket tcpa = (TCPPacket) p;

		if (r.packetDirection.equals("->")) {
			// ����Ϊ->
			if (!matchIP(r.getIP1(), ipa.src_ip.getHostAddress())
					|| !matchIP(r.getIP2(), ipa.dst_ip.getHostAddress()))
				return false;
			if (!matchPort(r.getPort1(), String.valueOf(tcpa.src_port))
					|| !matchPort(r.getPort2(), String.valueOf(tcpa.dst_port)))
				return false;
		} else {
			// ����Ϊ<>
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
	 * UDP����������ȫ��IP��������
	 * 
	 * @return false:ƥ�� true:��ƥ��
	 */
	public boolean UDPdetector() {
		if (r.protocol != 5)
			return false;
		IPPacket ipa = (IPPacket) p;
		UDPPacket udpa = (UDPPacket) p;

		if (r.packetDirection.equals("->")) {
			// ����Ϊ->
			if (!matchIP(r.getIP1(), ipa.src_ip.getHostAddress())
					|| !matchIP(r.getIP2(), ipa.dst_ip.getHostAddress()))
				return false;
			if (!matchPort(r.getPort1(), String.valueOf(udpa.src_port))
					|| !matchPort(r.getPort2(), String.valueOf(udpa.dst_port)))
				return false;
		} else {
			// ����Ϊ<>
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
	 * ICMP����������ȫ��IP�������ݣ�ͬʱ���itype,icmp_id,icmp_seq
	 * 
	 * @return false:ƥ�� true:��ƥ��
	 */
	public boolean ICMPdetector() {
		if (r.protocol != 6)
			return false;
		IPPacket ipa = (IPPacket) p;
		if (r.packetDirection.equals("->")) {
			// ����Ϊ->
			if (!matchIP(r.getIP1(), ipa.src_ip.getHostAddress())
					|| !matchIP(r.getIP2(), ipa.dst_ip.getHostAddress()))
				return false;
		} else {
			// ����Ϊ<>
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
	 * Other�����
	 * 
	 * @return false:ƥ�� true:��ƥ��
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