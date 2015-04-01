package analysis;

import java.util.LinkedList;
import java.util.List;

import rules.Rule;

import jpcap.packet.Packet;
import analysis.analyzers.*;
import detect.Detector;

/**
 * 分析数据包，统计相关数据，调用检测器进行规则匹配检测
 * 
 * @author 张广
 * 
 */
public class Analyzer {
	private int state = 0;

	private long protocolsStat[][];

	private List<IDPacketAnalyzer> analyzers;

	/**
	 * Ethernet协议相关的规则列表
	 */
	public LinkedList<Rule> ethernetList = new LinkedList<Rule>();

	/**
	 * IP协议相关的规则列表
	 */
	public LinkedList<Rule> ipList = new LinkedList<Rule>();

	/**
	 * ARP协议相关的规则列表
	 */
	public LinkedList<Rule> arpList = new LinkedList<Rule>();

	/**
	 * TCP协议相关的规则列表
	 */
	public LinkedList<Rule> tcpList = new LinkedList<Rule>();

	/**
	 * UDP协议相关的规则列表
	 */
	public LinkedList<Rule> udpList = new LinkedList<Rule>();

	/**
	 * ICMP协议相关的规则列表
	 */
	public LinkedList<Rule> icmpList = new LinkedList<Rule>();

	/**
	 * 其它协议相关的规则列表
	 */
	public LinkedList<Rule> otherList = new LinkedList<Rule>();

	/**
	 * 用于存储当前数据包所匹配的规则的缓冲区
	 */
	public LinkedList<Rule> alertRulesBuffer = new LinkedList<Rule>();

	/**
	 * 构造函数，在构造时载入数据包分析器
	 * 
	 */
	public Analyzer() {
		analyzers = new PacketAnalyzerLoader().getAnalyzers();
		// 分协议统计：每个协议含2项，分别为包数，总大小
		protocolsStat = new long[analyzers.size()][2];
	}

	/**
	 * 得到统计的数据
	 * 
	 * @return protocolsStat 包含统计数据的数组
	 */
	public long[][] getProtocolsStat() {
		return protocolsStat;
	}

	/**
	 * 统计数据全部清零
	 * 
	 */
	public void clearProtocolsStat() {
		for (int i = 0; i < protocolsStat.length; i++) {
			protocolsStat[i][0] = 0;
			protocolsStat[i][1] = 0;
		}
	}

	/**
	 * 分析数据包，统计相应数据，调用检测器进行规则检测
	 * 
	 * @param p
	 *            要分析的数据包
	 */
	public void analysis(Packet p) {
		boolean isLoop = true;
		state = 0;
		alertRulesBuffer.clear();

		// 下面将使用状态转换机来实现协议的解析（这是一种变相的决策树）
		// 其中的协议对应的状态如下：
		// Packet:0;
		// Ethernet:1; Other7:7;
		// IP:2; ARP:3; Other8:8;
		// TCP:4; UDP:5; ICMP:6; Other9:9;
		while (isLoop) {
			switch (state) {
			case 0: {// Packet
				protocolsStat[0][0] += 1;
				protocolsStat[0][1] += p.len;

				// 调用检测器

				if (analyzers.get(1).isAnalyzable(p))
					state = 1;
				else
					state = 7;// 其它数据链路层数据包
			}
				break;
			// ///////////////////////////////////////////////////////////
			case 1: {// Ethernet包
				protocolsStat[1][0] += 1;
				protocolsStat[1][1] += p.len;

				// 调用检测器
				for (int i = 0; i < ethernetList.size(); i++) {
					if ((new Detector(ethernetList.get(i), p))
							.Ethernetdetector()) {
						alertRulesBuffer.add(ethernetList.get(i));
					}
				}

				if (analyzers.get(2).isAnalyzable(p))
					state = 2;
				else if (analyzers.get(3).isAnalyzable(p))
					state = 3;
				else
					state = 8;// 其它网络层数据包
			}
				break;
			// /////////////////////////////////////////////////////////
			case 2: {// IP包
				protocolsStat[2][0] += 1;
				protocolsStat[2][1] += p.len;

				// 调用检测器
				for (int i = 0; i < ipList.size(); i++) {
					if ((new Detector(ipList.get(i), p)).IPdetector()) {
						alertRulesBuffer.add(ipList.get(i));
					}
				}

				if (analyzers.get(4).isAnalyzable(p))
					state = 4;
				else if (analyzers.get(5).isAnalyzable(p))
					state = 5;
				else if (analyzers.get(6).isAnalyzable(p))
					state = 6;
				else
					state = 9;// 其它传输层数据包
			}
				break;
			// //////////////////////////////////////////////////////////
			case 3: // ARP包
			{
				protocolsStat[3][0] += 1;
				protocolsStat[3][1] += p.len;

				// 调用检测器
				for (int i = 0; i < arpList.size(); i++) {
					if ((new Detector(arpList.get(i), p)).ARPdetector()) {
						alertRulesBuffer.add(arpList.get(i));
					}
				}

				isLoop = false;

			}
				break;
			case 4: // TCP包
			{
				protocolsStat[4][0] += 1;
				protocolsStat[4][1] += p.len;

				// 调用检测器
				for (int i = 0; i < tcpList.size(); i++) {
					if ((new Detector(tcpList.get(i), p)).TCPdetector()) {
						alertRulesBuffer.add(tcpList.get(i));
					}
				}

				isLoop = false;

			}
				break;
			case 5: // UDP包
			{
				protocolsStat[5][0] += 1;
				protocolsStat[5][1] += p.len;

				// 调用检测器
				for (int i = 0; i < udpList.size(); i++) {
					if ((new Detector(udpList.get(i), p)).UDPdetector()) {
						alertRulesBuffer.add(udpList.get(i));
					}
				}

				isLoop = false;

			}
				break;
			case 6: // ICMP包
			{
				protocolsStat[6][0] += 1;
				protocolsStat[6][1] += p.len;

				// 调用检测器
				for (int i = 0; i < icmpList.size(); i++) {
					if ((new Detector(icmpList.get(i), p)).ICMPdetector()) {
						alertRulesBuffer.add(icmpList.get(i));
					}
				}

				isLoop = false;

			}
				break;
			case 7: // Other7
			case 8: // Other8
			case 9: // Other9
			{
				protocolsStat[state][0] += 1;
				protocolsStat[state][1] += p.len;

				// 调用检测器
				for (int i = 0; i < otherList.size(); i++) {
					if ((new Detector(otherList.get(i), p)).Otherdetector()) {
						alertRulesBuffer.add(otherList.get(i));
					}
				}

				isLoop = false;

			}
				break;

			default:
				break;
			}
		}
	}

}
