package analysis.packAnalysis;

import jpcap.packet.*;

/**
 * 
 * 分析包中的数据，该程序来自于Jpcap官方网站上的开源例子:JpcapDumper。 略有修改
 * 
 * {@link http://netresearch.ics.uci.edu/kfujii/jpcap/doc/samples.html}
 * 
 * @author 修改人：张广
 */
public class PacketData {
	/**
	 * 对包 p 进行分析，并将分析的结果返回
	 * 
	 * @param p
	 * @return String类型的数据
	 */
	public static String showPacketData(Packet p) {
		byte[] bytes = new byte[p.header.length + p.data.length];

		System.arraycopy(p.header, 0, bytes, 0, p.header.length);
		System.arraycopy(p.data, 0, bytes, p.header.length, p.data.length);

		StringBuffer buf = new StringBuffer();
		for (int i = 0, j; i < bytes.length;) {
			for (j = 0; j < 8 && i < bytes.length; j++, i++) {
				String d = Integer.toHexString((int) (bytes[i] & 0xff));
				buf.append((d.length() == 1 ? "0" + d : d) + " ");
				if (bytes[i] < 32 || bytes[i] > 126)
					bytes[i] = 46;
			}
			buf.append("[" + new String(bytes, i - j, j) + "]\n");
		}
		return buf.toString();
	}
}
