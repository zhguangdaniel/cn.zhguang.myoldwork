package analysis;

import java.util.*;

import analysis.analyzers.*;

/**
 * 
 * ���ذ����������ó���������Jpcap�ٷ���վ�ϵĿ�Դ����:JpcapDumper�������޸�
 * 
 * {@link http://netresearch.ics.uci.edu/kfujii/jpcap/doc/samples.html}
 * 
 * @author �޸��ˣ��Ź�
 */
public class PacketAnalyzerLoader {
	private List<IDPacketAnalyzer> analyzers = new ArrayList<IDPacketAnalyzer>();

	/**
	 * ����Ҫ�ķ��������ص�һ������
	 * 
	 */
	public PacketAnalyzerLoader() {
		analyzers.add(new PacketAnalyzer());// 0
		analyzers.add(new EthernetAnalyzer());// 1
		analyzers.add(new IPAnalyzer());// 2
		analyzers.add(new ARPAnalyzer());// 3
		analyzers.add(new TCPAnalyzer());// 4
		analyzers.add(new UDPAnalyzer());// 5
		analyzers.add(new ICMPAnalyzer());// 6
		analyzers.add(new OtherDatalinkLayerAnalyzer());// 7
		analyzers.add(new OtherNetworkLayerAnalyzer());// 8
		analyzers.add(new OtherTransportLayerAnalyzer());// 9
	}

	/**
	 * ��÷������б�
	 * 
	 * @return �������б�����һ��˳��ģ�
	 */
	public List<IDPacketAnalyzer> getAnalyzers() {
		return analyzers;
	}
}
