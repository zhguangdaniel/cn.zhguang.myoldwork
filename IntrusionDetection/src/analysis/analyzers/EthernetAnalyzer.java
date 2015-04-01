package analysis.analyzers;

import jpcap.packet.*;

/**
 * 
 * Ethernet包分析器，该程序来自于Jpcap官方网站上的开源例子:JpcapDumper。 略有修改
 * 
 * {@link http://netresearch.ics.uci.edu/kfujii/jpcap/doc/samples.html}
 * 
 * @author 修改人：张广
 */
public class EthernetAnalyzer extends IDPacketAnalyzer {
	private static final String[] valueNames = { "Frame Type", "Source MAC",
			"Destination MAC" };

	private EthernetPacket eth;

	/**
	 * 构造Ethernet分析器
	 * 
	 */
	public EthernetAnalyzer() {
		layer = DATALINK_LAYER;
	}

	public boolean isAnalyzable(Packet p) {
		return (p.datalink != null && p.datalink instanceof EthernetPacket);
	}

	public String getProtocolName() {
		return "Ethernet Frame";
	}

	public String[] getValueNames() {
		return valueNames;
	}

	public void analyze(Packet p) {
		if (!isAnalyzable(p))
			return;
		eth = (EthernetPacket) p.datalink;
	}

	public Object getValue(String valueName) {
		for (int i = 0; i < valueNames.length; i++)
			if (valueNames[i].equals(valueName))
				return getValueAt(i);

		return null;
	}

	Object getValueAt(int index) {
		switch (index) {
		case 0:
			return new Integer(eth.frametype);
		case 1:
			return eth.getSourceAddress();
		case 2:
			return eth.getDestinationAddress();
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
