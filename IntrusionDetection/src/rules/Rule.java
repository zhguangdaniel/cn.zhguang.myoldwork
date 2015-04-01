package rules;

import java.util.LinkedList;

/**
 * 定义一条规则（一个规则结点）
 * 
 * @author 张广
 * 
 */
public class Rule {
	/**
	 * 该规则的当前唯一编号，用于决策树中规则的查找
	 */
	public int index;

	/**
	 * 该规则所在的文件的名字，用于写回规则
	 */
	public String fileName;

	/**
	 * 操作： 1:Alert; 2:Log; 3:Pass;
	 */
	public int action = 0;

	/**
	 * 协议： 1:Ethernet 2:IP 3:ARP 4:TCP 5:UDP 6:ICMP 7:Other
	 */
	public int protocol = 0;

	/**
	 * 源IP是否取反
	 */
	public boolean srcIPNot = false;

	/**
	 * 源IP地址
	 */
	public String srcIPAddr = "";

	/**
	 * 源IP是否取反
	 */
	public boolean srcPortNot = false;

	/**
	 * 源端口
	 */
	public String srcPort = "";

	/**
	 * 包中IP和端口的流向
	 */
	public String packetDirection = "->";

	/**
	 * 目的IP是否取反
	 */
	public boolean dstIPNot = false;

	/**
	 * 目的IP地址
	 */
	public String dstIPAddr = "";

	/**
	 * 的端口是否取反
	 */
	public boolean dstPortNot = false;

	/**
	 * 目的端口
	 */
	public String dstPort = "";

	/**
	 * 规则选项列表，每个结点表示一个规则选项
	 */
	public LinkedList<RuleOption> optionsList = new LinkedList<RuleOption>();

	/**
	 * 消息
	 */
	public String msg = "";

	/**
	 * 获得String类型的操作名
	 * 
	 * @return Alert,Log,Pass,失败返回null
	 */
	public String getAction() {
		String act;
		switch (action) {
		case 1:
			act = "Alert";
			break;
		case 2:
			act = "Log";
			break;
		case 3:
			act = "Pass";
			break;
		default:
			return null;
		}
		return act;
	}

	/**
	 * 获得String类型的协议名
	 * 
	 * @return Ethernet,IP,ARP,TCP,UDP,ICMP,Other,失败返回null
	 */
	public String getProtocol() {
		String pro;
		switch (protocol) {
		case 1:
			pro = "Ethernet";
			break;
		case 2:
			pro = "IP";
			break;
		case 3:
			pro = "ARP";
			break;
		case 4:
			pro = "TCP";
			break;
		case 5:
			pro = "UDP";
			break;
		case 6:
			pro = "ICMP";
			break;
		case 7:
			pro = "Other";
			break;
		default:
			return null;
		}

		return pro;
	}

	/**
	 * 获得String类型的IP 1
	 * 
	 * @return IP1地址,失败返回null
	 */
	public String getIP1() {
		String IP1 = "";
		if (srcIPNot)
			IP1 += "!";

		IP1 += srcIPAddr;
		return IP1;
	}

	/**
	 * 获得String类型的Port 1
	 * 
	 * @return Port1地址,失败返回null
	 */
	public String getPort1() {
		String Port1 = "";
		if (srcPortNot)
			Port1 += "!";

		Port1 += srcPort;
		return Port1;
	}

	/**
	 * 获得String类型的IP 2
	 * 
	 * @return IP2地址,失败返回null
	 */
	public String getIP2() {
		String IP2 = "";
		if (dstIPNot)
			IP2 += "!";

		IP2 += dstIPAddr;
		return IP2;
	}

	/**
	 * 获得String类型的Port 2
	 * 
	 * @return Port2地址,失败返回null
	 */
	public String getPort2() {
		String Port2 = "";
		if (dstPortNot)
			Port2 += "!";

		Port2 += dstPort;
		return Port2;
	}

	/**
	 * 获得String类型的选项列表
	 * 
	 * @return 各选项连接成的String,失败返回null
	 */
	public String getOptionList() {
		String optionList = "";
		if (optionsList.size() > 0) {
			optionList += "( ";
			for (int i = 0; i < optionsList.size(); i++) {
				if (optionsList.get(i).optNot) {
					optionList += "!";
				}
				optionList += optionsList.get(i).optionType + ":"
						+ optionsList.get(i).optionText + "; ";
			}
			optionList += ")";
		}
		return optionList;
	}

	/**
	 * 
	 * @return 编译后的String类型的完整规则
	 */
	public String getStringRule() {
		String strRule = getAction() + " " + getProtocol() + " " + getIP1()
				+ " " + getPort1() + " " + packetDirection + " " + getIP2()
				+ " " + getPort2() + " " + getOptionList() + " Msg:" + msg;

		return strRule;
	}

}
