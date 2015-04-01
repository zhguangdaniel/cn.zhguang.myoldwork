package response;

import rules.Rule;
import jpcap.packet.Packet;

/**
 * 一个警告信息结构
 * 
 * @author 张广
 * 
 */
public class Alert {

	/**
	 * 规则
	 */
	public Rule r = null;

	/**
	 * 数据包
	 */
	public Packet p = null;

	/**
	 * 处理后的结果
	 */
	public String oprResult = null;

	/**
	 * 构造警告信息结构
	 * 
	 * @param rule
	 *            匹配的规则
	 * @param packet
	 *            检测到的数据包
	 * @param result
	 *            处理后的结果
	 */
	public Alert(Rule rule, Packet packet, String result) {
		r = rule;
		p = packet;
		oprResult = result;
	}
}
