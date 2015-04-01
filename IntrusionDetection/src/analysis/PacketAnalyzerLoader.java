package analysis;

import java.util.*;

import analysis.analyzers.*;

/**
 * 
 * 加载包分析器，该程序来自于Jpcap官方网站上的开源例子:JpcapDumper。略有修改
 * 
 * {@link http://netresearch.ics.uci.edu/kfujii/jpcap/doc/samples.html}
 * 
 * @author 修改人：张广
 */
public class PacketAnalyzerLoader {
	private List<IDPacketAnalyzer> analyzers = new ArrayList<IDPacketAnalyzer>();

	/**
	 * 将需要的分析器加载到一个表中
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
	 * 获得分析器列表
	 * 
	 * @return 分析器列表（按照一定顺序的）
	 */
	public List<IDPacketAnalyzer> getAnalyzers() {
		return analyzers;
	}
}
