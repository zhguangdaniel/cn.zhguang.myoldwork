package capture;

import java.io.IOException;
import java.util.LinkedList;

import jpcap.*;
import jpcap.packet.Packet;

/**
 * �����̲߳������
 * 
 * @author �Ź�
 * 
 */
public class Captor {

	/**
	 * ��ʱ��Ų��񵽵����ݰ��Ļ����
	 */
	public LinkedList<Packet> packetsBuffer = new LinkedList<Packet>();

	private Thread threadCaptor;

	private JpcapCaptor jcaptor;

	private int deviceIndex = 0;

	private NetworkInterface[] devices;

	private int maxLen = 65535;

	private boolean isRunning = false;

	private boolean isProm = true;

	/**
	 * ���첶������ͬʱ�������������������豸�б�
	 *
	 */
	public Captor() {
		devices = JpcapCaptor.getDeviceList();
		if (devices.length > 1)
			setDevIndex(1);
	}

	/**
	 * ���JpacpCaptor������
	 * 
	 * @return ��Captor�Ĳ�����
	 */
	public JpcapCaptor getJpcap() {		
		return jcaptor;
	}

	/**
	 * ����Ҫ�������������
	 * 
	 * @param i
	 */
	public void setDevIndex(int i) {
		deviceIndex = i;
	}

	/**
	 * ����ÿ�β��������󳤶�
	 * 
	 * @param l
	 *            ����
	 */
	public void setMaxLen(int l) {
		maxLen = l;
	}

	/**
	 * �Ƿ�����Ϊ����ģʽ
	 * 
	 * @param b
	 *            true:��Ϊ����ģʽ
	 */
	public void setIsProm(boolean b) {
		isProm = b;
	}

	/**
	 * ��õ�ǰ���������������
	 * 
	 * @return deviceIndex
	 */
	public int getDevIndex() {
		return deviceIndex;
	}

	/**
	 * ���ÿ�μ���������󳤶�
	 * 
	 * @return maxLen
	 */
	public int getMaxLen() {
		return maxLen;
	}

	/**
	 * ����Ƿ�ʹ�û���ģʽ
	 * 
	 * @return isProm ��true:ʹ�û���ģʽ / false:ʹ�÷ǻ���ģʽ
	 */
	public boolean getIsProm() {
		return isProm;
	}

	/**
	 * ����PacketReceiver
	 * 
	 * @author �Ź�
	 * 
	 */
	class Receiver implements PacketReceiver {
		/**
		 * ÿ�β���һ���������øú������д����Ѱ��ӵ������б���������б�ĳ��ȴ���100������߳���ͣ���������߳���ִ��
		 */
		public void receivePacket(Packet p) {
			if (packetsBuffer.size() > 100) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			packetsBuffer.addLast(p);
		}
	}

	/**
	 * ��ʼһ���̣߳���ʼ����
	 * 
	 */
	public void start() {
		packetsBuffer.clear();
		try {
			jcaptor = JpcapCaptor.openDevice(devices[deviceIndex], maxLen,
					isProm, 20);
		} catch (IOException e) {
			e.printStackTrace();
		}

		isRunning = true;
		threadCaptor = new Thread(new Runnable() {
			public void run() {
				while (isRunning) {
					try {
						jcaptor.processPacket(1, new Receiver());
					} catch (StackOverflowError e) {
						isRunning = false;
					}
					Thread.yield();
				}
				jcaptor.breakLoop();
			}
		});
		threadCaptor.setPriority(Thread.MIN_PRIORITY);
		threadCaptor.start();
	}

	/**
	 * ʹ��j���ļ��в���
	 * 
	 * @param j
	 *            ��JpcapCaptor.openFile()�з���
	 */
	public void loadFile(JpcapCaptor j) {
		final JpcapCaptor jpc = j;
		isRunning = true;
		threadCaptor = new Thread(new Runnable() {
			public void run() {
				while (isRunning) {
					try {
						Packet p = jpc.getPacket();
						if (p == null || p.equals(Packet.EOF))
							isRunning = false;
						new Receiver().receivePacket(p);

					} catch (StackOverflowError e) {
						isRunning = false;
					}
				}
				jpc.breakLoop();
			}
		});
		threadCaptor.setPriority(Thread.MIN_PRIORITY);
		threadCaptor.start();
	}

	/**
	 * �����̣߳���ֹ����
	 * 
	 */
	public void stop() {
		isRunning = false;
		packetsBuffer.clear();
	}
}
