package rules;

/**
 * ����ѡ���ʽΪ��[!]optionType:"optionText";
 * @author �Ź�
 *
 */
public class RuleOption {
	/**
	 * ��ѡ���Ƿ�ȡ��
	 */
	public boolean optNot = false;

	/**
	 * �����ѡ�����ͣ���  ttl��id��size��content��flags��seq��ack��itype��icmp_id��icmp_seq��ipoption
	 */
	public String optionType = "";

	/**
	 * ѡ�������
	 */
	public String optionText = "";
}
