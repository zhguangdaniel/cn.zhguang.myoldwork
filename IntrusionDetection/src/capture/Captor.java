package capture;

import java.io.IOException;
import java.util.LinkedList;

import jpcap.*;
import jpcap.packet.Packet;

/**
 * 建立线程并捕获包
 * 
 * @author 张广
 * 
 */
public class Captor {

	/**
	 * 暂时存放捕获到的数据包的缓冲池
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
	 * 构造捕获器，同时载入所在主机的网卡设备列表
	 *
	 */
	public Captor() {
		devices = JpcapCaptor.getDeviceList();
		if (devices.length > 1)
			setDevIndex(1);
	}

	/**
	 * 获得JpacpCaptor捕获器
	 * 
	 * @return 本Captor的捕获器
	 */
	public JpcapCaptor getJpcap() {		
		return jcaptor;
	}

	/**
	 * 设置要监听的网卡序号
	 * 
	 * @param i
	 */
	public void setDevIndex(int i) {
		deviceIndex = i;
	}

	/**
	 * 设置每次捕获包的最大长度
	 * 
	 * @param l
	 *            长度
	 */
	public void setMaxLen(int l) {
		maxLen = l;
	}

	/**
	 * 是否设置为混杂模式
	 * 
	 * @param b
	 *            true:设为混杂模式
	 */
	public void setIsProm(boolean b) {
		isProm = b;
	}

	/**
	 * 获得当前监听的网卡的序号
	 * 
	 * @return deviceIndex
	 */
	public int getDevIndex() {
		return deviceIndex;
	}

	/**
	 * 获得每次监听包的最大长度
	 * 
	 * @return maxLen
	 */
	public int getMaxLen() {
		return maxLen;
	}

	/**
	 * 获得是否使用混杂模式
	 * 
	 * @return isProm ：true:使用混杂模式 / false:使用非混杂模式
	 */
	public boolean getIsProm() {
		return isProm;
	}

	/**
	 * 重载PacketReceiver
	 * 
	 * @author 张广
	 * 
	 */
	class Receiver implements PacketReceiver {
		/**
		 * 每次捕获一个包都调用该函数进行处理，把包加到缓冲列表，如果缓冲列表的长度大于100，则该线程暂停，让其它线程先执行
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
	 * 开始一个线程，开始捕获
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
	 * 使用j从文件中捕获
	 * 
	 * @param j
	 *            从JpcapCaptor.openFile()中返回
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
	 * 结束线程，终止捕获
	 * 
	 */
	public void stop() {
		isRunning = false;
		packetsBuffer.clear();
	}
}
