package analysis.packAnalysis;

import jpcap.packet.*;
import java.net.InetAddress;

/**
 * 
 * ������ͷ��Ϣ��Ϊ������Ԫ����׼�����ó���������Jpcap�ٷ���վ�ϵĿ�Դ����:JpcapDumper���нϴ��޸�
 * 
 * {@link http://netresearch.ics.uci.edu/kfujii/jpcap/doc/samples.html}
 * 
 * @author �޸��ˣ��Ź�
 */
public class TableItems {
	private String src_ip = null;

	private String dst_ip = null;

	private String length = null;

	private String protocol = null;

	private String src_port = null;

	private String dst_port = null;

	/**
	 * ��ð������Ļ�����Ϣ����ʹ��ǰ��Ҫ��ʹ��analyzePacket�԰����з���
	 * 
	 * @return һ��������Ӧ��Ԫ����Ϣ��String����
	 */
	public String[] getTableItemInfo() {
		String[] ti = new String[6];
		ti[0] = protocol;
		ti[1] = length;
		ti[2] = src_ip;
		ti[3] = src_port;
		ti[4] = dst_ip;
		ti[5] = dst_port;
		return ti;
	}

	/**
	 * �԰� p ���з���
	 * 
	 * @param p
	 */
	public void analyzePacket(Packet p) {
		length = String.valueOf(p.len);
		// if (p.datalink != null && p.datalink instanceof EthernetPacket) {
		// EthernetPacket eth = (EthernetPacket) p.datalink;
		// src_mac = eth.getSourceAddress();
		// dst_mac = eth.getDestinationAddress();
		// }
		if (p instanceof IPPacket && ((IPPacket) p).version == 4) {
			IPPacket ip = (IPPacket) p;
			src_ip = ip.src_ip.getHostAddress();
			dst_ip = ip.dst_ip.getHostAddress();
			protocol = String.valueOf(ip.protocol);
		}
		if (p instanceof TCPPacket) {
			TCPPacket tcp = (TCPPacket) p;
			src_port = String.valueOf(tcp.src_port);
			dst_port = String.valueOf(tcp.dst_port);
		}
		if (p instanceof UDPPacket) {
			UDPPacket udp = (UDPPacket) p;
			src_port = String.valueOf(udp.src_port);
			dst_port = String.valueOf(udp.dst_port);
		}
		if (p instanceof ARPPacket) {
			ARPPacket arp = (ARPPacket) p;
			src_ip = ((InetAddress) arp.getSenderProtocolAddress())
					.getHostAddress();
			;
			dst_ip = ((InetAddress) arp.getTargetProtocolAddress())
					.getHostAddress();
		}

	}

}
