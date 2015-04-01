package analysis.packAnalysis;

import jpcap.packet.*;
import java.net.InetAddress;

/**
 * 
 * 分析包头信息，为创建表元素做准备，该程序来自于Jpcap官方网站上的开源例子:JpcapDumper。有较大修改
 * 
 * {@link http://netresearch.ics.uci.edu/kfujii/jpcap/doc/samples.html}
 * 
 * @author 修改人：张广
 */
public class TableItems {
	private String src_ip = null;

	private String dst_ip = null;

	private String length = null;

	private String protocol = null;

	private String src_port = null;

	private String dst_port = null;

	/**
	 * 获得包所含的基本信息，在使用前，要先使用analyzePacket对包进行分析
	 * 
	 * @return 一个含有相应表元素信息的String数组
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
	 * 对包 p 进行分析
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
