package analysis.analyzers;

import jpcap.packet.*;

/**
 * 
 * UDP包分析器，该程序来自于Jpcap官方网站上的开源例子:JpcapDumper。 略有修改
 * 
 * {@link http://netresearch.ics.uci.edu/kfujii/jpcap/doc/samples.html}
 * 
 * @author 修改人：张广
 */
public class UDPAnalyzer extends IDPacketAnalyzer {
	private static final String[] valueNames = { "Source Port",
			"Destination Port", "Packet Length" };

	private UDPPacket udp;

	/**
	 * 构造相应分析器
	 * 
	 */
	public UDPAnalyzer() {
		layer = TRANSPORT_LAYER;
	}

	public boolean isAnalyzable(Packet p) {
		return (p instanceof UDPPacket);
	}

	public String getProtocolName() {
		return "UDP";
	}

	public String[] getValueNames() {
		return valueNames;
	}

	public void analyze(Packet p) {
		if (!isAnalyzable(p))
			return;
		udp = (UDPPacket) p;
	}

	public Object getValue(String valueName) {
		for (int i = 0; i < valueNames.length; i++)
			if (valueNames[i].equals(valueName))
				return getValueAt(i);

		return null;
	}

	public Object getValueAt(int index) {
		switch (index) {
		case 0:
			return new Integer(udp.src_port);
		case 1:
			return new Integer(udp.dst_port);
		case 2:
			return new Integer(udp.length);
		default:
			return null;
		}
	}

	public Object[] getValues() {
		Object[] v = new Object[3];
		for (int i = 0; i < 3; i++)
			v[i] = getValueAt(i);

		return v;
	}
}
