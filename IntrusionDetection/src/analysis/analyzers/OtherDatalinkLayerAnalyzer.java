package analysis.analyzers;

import jpcap.packet.*;

/**
 * 
 * OtherDatalinkLayer包分析器
 * 
 * @author 张广
 */
public class OtherDatalinkLayerAnalyzer extends IDPacketAnalyzer {
	private static final String[] valueNames = null;

	public boolean isAnalyzable(Packet packet) {
		return (packet.datalink != null && !(packet.datalink instanceof EthernetPacket));
	}

	public void analyze(Packet packet) {

	}

	public String getProtocolName() {
		return "OtherDatalinkLayer";
	}

	public String[] getValueNames() {
		return valueNames;
	}

	public Object getValue(String valueName) {
		return null;
	}

	Object getValueAt(int index) {
		return null;
	}

	public Object[] getValues() {
		return null;
	}
}
