package analysis.analyzers;

import jpcap.packet.*;

/**
 * 
 * ���������ĳ����࣬�ó���������Jpcap�ٷ���վ�ϵĿ�Դ����:JpcapDumper�� �����޸�
 * 
 * {@link http://netresearch.ics.uci.edu/kfujii/jpcap/doc/samples.html}
 * 
 * @author �޸��ˣ��Ź�
 */
public abstract class IDPacketAnalyzer {

	/**
	 * �����ݰ����ڵĲ�
	 */
	public int layer = DATALINK_LAYER;

	/**
	 * ������·��
	 */
	public static int DATALINK_LAYER = 0;

	/**
	 * �����
	 */
	public static int NETWORK_LAYER = 1;

	/**
	 * �����
	 */
	public static int TRANSPORT_LAYER = 2;

	/**
	 * Ӧ�ò�
	 */
	public static int APPLICATION_LAYER = 3;

	/**
	 * ��packet�Ƿ��ܱ��÷���������
	 * 
	 * @param packet
	 *            Ҫ�жϵİ�
	 * @return true:�÷��������Է�����false:���ܷ���
	 */
	public abstract boolean isAnalyzable(Packet packet);

	/**
	 * ������p
	 * 
	 * @param p
	 *            Ҫ�����İ�
	 */
	public abstract void analyze(Packet p);

	/**
	 * ���Э����
	 * 
	 * @return �÷�������������Э�������
	 */
	public abstract String getProtocolName();

	/**
	 * ����й�ֵ������
	 * 
	 * @return valueNames String���͵����飬���к����粶��ʱ�䣬���񳤶����ڵ���ر���������
	 */
	public abstract String[] getValueNames();

	/**
	 * ���ָ�����ֵı���ֵ
	 * 
	 * @param valueName
	 *            Ҫ��õı���������
	 * @return ��Ӧ�ı���
	 */
	public abstract Object getValue(String valueName);

	/**
	 * ���valueNames[index]��ֵ
	 * 
	 * @param index
	 * @return ��Ӧ��ֵ
	 */
	abstract Object getValueAt(int index);

	/**
	 * ���valueNames[]��Ӧ��ȫ�������ֵ
	 * 
	 * @return ����ֵ����
	 */
	public abstract Object[] getValues();
}
