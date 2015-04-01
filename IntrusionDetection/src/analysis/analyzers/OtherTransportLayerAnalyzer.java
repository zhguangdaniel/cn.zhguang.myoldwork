package analysis.analyzers;

import jpcap.packet.*;

/**
 * 
 * OtherTransportLayer包分析器
 * 
 * @author 修改人：张广
 */
public class OtherTransportLayerAnalyzer extends IDPacketAnalyzer {
	private static final String[] valueNames = null;

	public boolean isAnalyzable(Packet packet) {
		if ((new EthernetAnalyzer()).isAnalyzable(packet)
				&& (new IPAnalyzer()).isAnalyzable(packet)
				&& !(new TCPAnalyzer()).isAnalyzable(packet)
				&& !(new UDPAnalyzer()).isAnalyzable(packet)
				&& !(new ICMPAnalyzer()).isAnalyzable(packet))
			return true;
		return false;
	}

	public void analyze(Packet packet) {

	}

	public String getProtocolName() {
		return "OtherTransportLayer";
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
