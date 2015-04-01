package analysis.analyzers;

import jpcap.packet.*;

/**
 * 
 * OtherNetworkLayer��������
 * 
 * @author �޸��ˣ��Ź�
 */
public class OtherNetworkLayerAnalyzer extends IDPacketAnalyzer {
	private static final String[] valueNames = null;

	public boolean isAnalyzable(Packet packet) {
		if ((new EthernetAnalyzer()).isAnalyzable(packet)
				&& !(new IPAnalyzer()).isAnalyzable(packet)
				&& !(new ARPAnalyzer()).isAnalyzable(packet))
			return true;
		return false;

	}

	public void analyze(Packet packet) {

	}

	public String getProtocolName() {
		return "OtherNetworkLayer";
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
