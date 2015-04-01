package analysis;

import java.util.LinkedList;
import java.util.List;

import rules.Rule;

import jpcap.packet.Packet;
import analysis.analyzers.*;
import detect.Detector;

/**
 * �������ݰ���ͳ��������ݣ����ü�������й���ƥ����
 * 
 * @author �Ź�
 * 
 */
public class Analyzer {
	private int state = 0;

	private long protocolsStat[][];

	private List<IDPacketAnalyzer> analyzers;

	/**
	 * EthernetЭ����صĹ����б�
	 */
	public LinkedList<Rule> ethernetList = new LinkedList<Rule>();

	/**
	 * IPЭ����صĹ����б�
	 */
	public LinkedList<Rule> ipList = new LinkedList<Rule>();

	/**
	 * ARPЭ����صĹ����б�
	 */
	public LinkedList<Rule> arpList = new LinkedList<Rule>();

	/**
	 * TCPЭ����صĹ����б�
	 */
	public LinkedList<Rule> tcpList = new LinkedList<Rule>();

	/**
	 * UDPЭ����صĹ����б�
	 */
	public LinkedList<Rule> udpList = new LinkedList<Rule>();

	/**
	 * ICMPЭ����صĹ����б�
	 */
	public LinkedList<Rule> icmpList = new LinkedList<Rule>();

	/**
	 * ����Э����صĹ����б�
	 */
	public LinkedList<Rule> otherList = new LinkedList<Rule>();

	/**
	 * ���ڴ洢��ǰ���ݰ���ƥ��Ĺ���Ļ�����
	 */
	public LinkedList<Rule> alertRulesBuffer = new LinkedList<Rule>();

	/**
	 * ���캯�����ڹ���ʱ�������ݰ�������
	 * 
	 */
	public Analyzer() {
		analyzers = new PacketAnalyzerLoader().getAnalyzers();
		// ��Э��ͳ�ƣ�ÿ��Э�麬2��ֱ�Ϊ�������ܴ�С
		protocolsStat = new long[analyzers.size()][2];
	}

	/**
	 * �õ�ͳ�Ƶ�����
	 * 
	 * @return protocolsStat ����ͳ�����ݵ�����
	 */
	public long[][] getProtocolsStat() {
		return protocolsStat;
	}

	/**
	 * ͳ������ȫ������
	 * 
	 */
	public void clearProtocolsStat() {
		for (int i = 0; i < protocolsStat.length; i++) {
			protocolsStat[i][0] = 0;
			protocolsStat[i][1] = 0;
		}
	}

	/**
	 * �������ݰ���ͳ����Ӧ���ݣ����ü�������й�����
	 * 
	 * @param p
	 *            Ҫ���������ݰ�
	 */
	public void analysis(Packet p) {
		boolean isLoop = true;
		state = 0;
		alertRulesBuffer.clear();

		// ���潫ʹ��״̬ת������ʵ��Э��Ľ���������һ�ֱ���ľ�������
		// ���е�Э���Ӧ��״̬���£�
		// Packet:0;
		// Ethernet:1; Other7:7;
		// IP:2; ARP:3; Other8:8;
		// TCP:4; UDP:5; ICMP:6; Other9:9;
		while (isLoop) {
			switch (state) {
			case 0: {// Packet
				protocolsStat[0][0] += 1;
				protocolsStat[0][1] += p.len;

				// ���ü����

				if (analyzers.get(1).isAnalyzable(p))
					state = 1;
				else
					state = 7;// ����������·�����ݰ�
			}
				break;
			// ///////////////////////////////////////////////////////////
			case 1: {// Ethernet��
				protocolsStat[1][0] += 1;
				protocolsStat[1][1] += p.len;

				// ���ü����
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
					state = 8;// ������������ݰ�
			}
				break;
			// /////////////////////////////////////////////////////////
			case 2: {// IP��
				protocolsStat[2][0] += 1;
				protocolsStat[2][1] += p.len;

				// ���ü����
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
					state = 9;// ������������ݰ�
			}
				break;
			// //////////////////////////////////////////////////////////
			case 3: // ARP��
			{
				protocolsStat[3][0] += 1;
				protocolsStat[3][1] += p.len;

				// ���ü����
				for (int i = 0; i < arpList.size(); i++) {
					if ((new Detector(arpList.get(i), p)).ARPdetector()) {
						alertRulesBuffer.add(arpList.get(i));
					}
				}

				isLoop = false;

			}
				break;
			case 4: // TCP��
			{
				protocolsStat[4][0] += 1;
				protocolsStat[4][1] += p.len;

				// ���ü����
				for (int i = 0; i < tcpList.size(); i++) {
					if ((new Detector(tcpList.get(i), p)).TCPdetector()) {
						alertRulesBuffer.add(tcpList.get(i));
					}
				}

				isLoop = false;

			}
				break;
			case 5: // UDP��
			{
				protocolsStat[5][0] += 1;
				protocolsStat[5][1] += p.len;

				// ���ü����
				for (int i = 0; i < udpList.size(); i++) {
					if ((new Detector(udpList.get(i), p)).UDPdetector()) {
						alertRulesBuffer.add(udpList.get(i));
					}
				}

				isLoop = false;

			}
				break;
			case 6: // ICMP��
			{
				protocolsStat[6][0] += 1;
				protocolsStat[6][1] += p.len;

				// ���ü����
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

				// ���ü����
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
