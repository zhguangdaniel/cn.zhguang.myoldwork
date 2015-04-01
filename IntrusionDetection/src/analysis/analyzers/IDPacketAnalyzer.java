package analysis.analyzers;

import jpcap.packet.*;

/**
 * 
 * 包分析器的抽象类，该程序来自于Jpcap官方网站上的开源例子:JpcapDumper。 略有修改
 * 
 * {@link http://netresearch.ics.uci.edu/kfujii/jpcap/doc/samples.html}
 * 
 * @author 修改人：张广
 */
public abstract class IDPacketAnalyzer {

	/**
	 * 该数据包所在的层
	 */
	public int layer = DATALINK_LAYER;

	/**
	 * 数据链路层
	 */
	public static int DATALINK_LAYER = 0;

	/**
	 * 网络层
	 */
	public static int NETWORK_LAYER = 1;

	/**
	 * 传输层
	 */
	public static int TRANSPORT_LAYER = 2;

	/**
	 * 应用层
	 */
	public static int APPLICATION_LAYER = 3;

	/**
	 * 包packet是否能被该分析器分析
	 * 
	 * @param packet
	 *            要判断的包
	 * @return true:该分析器可以分析；false:不能分析
	 */
	public abstract boolean isAnalyzable(Packet packet);

	/**
	 * 分析包p
	 * 
	 * @param p
	 *            要分析的包
	 */
	public abstract void analyze(Packet p);

	/**
	 * 获得协议名
	 * 
	 * @return 该分析器所分析的协议的名字
	 */
	public abstract String getProtocolName();

	/**
	 * 获得有关值的名字
	 * 
	 * @return valueNames String类型的数组，其中含有如捕获时间，捕获长度在内的相关变量的名字
	 */
	public abstract String[] getValueNames();

	/**
	 * 获得指定名字的变量值
	 * 
	 * @param valueName
	 *            要获得的变量的名字
	 * @return 相应的变量
	 */
	public abstract Object getValue(String valueName);

	/**
	 * 获得valueNames[index]的值
	 * 
	 * @param index
	 * @return 对应的值
	 */
	abstract Object getValueAt(int index);

	/**
	 * 获得valueNames[]对应的全部对象的值
	 * 
	 * @return 对象值数组
	 */
	public abstract Object[] getValues();
}
