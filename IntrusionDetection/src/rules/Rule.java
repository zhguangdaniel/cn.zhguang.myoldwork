package rules;

import java.util.LinkedList;

/**
 * ����һ������һ�������㣩
 * 
 * @author �Ź�
 * 
 */
public class Rule {
	/**
	 * �ù���ĵ�ǰΨһ��ţ����ھ������й���Ĳ���
	 */
	public int index;

	/**
	 * �ù������ڵ��ļ������֣�����д�ع���
	 */
	public String fileName;

	/**
	 * ������ 1:Alert; 2:Log; 3:Pass;
	 */
	public int action = 0;

	/**
	 * Э�飺 1:Ethernet 2:IP 3:ARP 4:TCP 5:UDP 6:ICMP 7:Other
	 */
	public int protocol = 0;

	/**
	 * ԴIP�Ƿ�ȡ��
	 */
	public boolean srcIPNot = false;

	/**
	 * ԴIP��ַ
	 */
	public String srcIPAddr = "";

	/**
	 * ԴIP�Ƿ�ȡ��
	 */
	public boolean srcPortNot = false;

	/**
	 * Դ�˿�
	 */
	public String srcPort = "";

	/**
	 * ����IP�Ͷ˿ڵ�����
	 */
	public String packetDirection = "->";

	/**
	 * Ŀ��IP�Ƿ�ȡ��
	 */
	public boolean dstIPNot = false;

	/**
	 * Ŀ��IP��ַ
	 */
	public String dstIPAddr = "";

	/**
	 * �Ķ˿��Ƿ�ȡ��
	 */
	public boolean dstPortNot = false;

	/**
	 * Ŀ�Ķ˿�
	 */
	public String dstPort = "";

	/**
	 * ����ѡ���б�ÿ������ʾһ������ѡ��
	 */
	public LinkedList<RuleOption> optionsList = new LinkedList<RuleOption>();

	/**
	 * ��Ϣ
	 */
	public String msg = "";

	/**
	 * ���String���͵Ĳ�����
	 * 
	 * @return Alert,Log,Pass,ʧ�ܷ���null
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
	 * ���String���͵�Э����
	 * 
	 * @return Ethernet,IP,ARP,TCP,UDP,ICMP,Other,ʧ�ܷ���null
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
	 * ���String���͵�IP 1
	 * 
	 * @return IP1��ַ,ʧ�ܷ���null
	 */
	public String getIP1() {
		String IP1 = "";
		if (srcIPNot)
			IP1 += "!";

		IP1 += srcIPAddr;
		return IP1;
	}

	/**
	 * ���String���͵�Port 1
	 * 
	 * @return Port1��ַ,ʧ�ܷ���null
	 */
	public String getPort1() {
		String Port1 = "";
		if (srcPortNot)
			Port1 += "!";

		Port1 += srcPort;
		return Port1;
	}

	/**
	 * ���String���͵�IP 2
	 * 
	 * @return IP2��ַ,ʧ�ܷ���null
	 */
	public String getIP2() {
		String IP2 = "";
		if (dstIPNot)
			IP2 += "!";

		IP2 += dstIPAddr;
		return IP2;
	}

	/**
	 * ���String���͵�Port 2
	 * 
	 * @return Port2��ַ,ʧ�ܷ���null
	 */
	public String getPort2() {
		String Port2 = "";
		if (dstPortNot)
			Port2 += "!";

		Port2 += dstPort;
		return Port2;
	}

	/**
	 * ���String���͵�ѡ���б�
	 * 
	 * @return ��ѡ�����ӳɵ�String,ʧ�ܷ���null
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
	 * @return ������String���͵���������
	 */
	public String getStringRule() {
		String strRule = getAction() + " " + getProtocol() + " " + getIP1()
				+ " " + getPort1() + " " + packetDirection + " " + getIP2()
				+ " " + getPort2() + " " + getOptionList() + " Msg:" + msg;

		return strRule;
	}

}
