package response;

import rules.Rule;
import jpcap.packet.Packet;

/**
 * һ��������Ϣ�ṹ
 * 
 * @author �Ź�
 * 
 */
public class Alert {

	/**
	 * ����
	 */
	public Rule r = null;

	/**
	 * ���ݰ�
	 */
	public Packet p = null;

	/**
	 * �����Ľ��
	 */
	public String oprResult = null;

	/**
	 * ���쾯����Ϣ�ṹ
	 * 
	 * @param rule
	 *            ƥ��Ĺ���
	 * @param packet
	 *            ��⵽�����ݰ�
	 * @param result
	 *            �����Ľ��
	 */
	public Alert(Rule rule, Packet packet, String result) {
		r = rule;
		p = packet;
		oprResult = result;
	}
}
