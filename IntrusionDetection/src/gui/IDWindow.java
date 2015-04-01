package gui;

import jpcap.JpcapCaptor;
import jpcap.JpcapWriter;
import jpcap.packet.Packet;
import capture.Captor;
import analysis.Analyzer;
import analysis.PacketAnalyzerLoader;
import analysis.analyzers.*;
import analysis.packAnalysis.*;
import response.Alert;
import rules.Rule;
import database.DBManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;

import rules.compiler.Compiler;

/**
 * ���ּ��ʵ��ϵͳ������
 * 
 * @author �Ź�
 * 
 */
public class IDWindow {
	protected Shell shell;

	private boolean manualRefresh;

	private boolean isInit = false;

	private boolean isDBconnected = false;

	private LinkedList<Alert> alertList = new LinkedList<Alert>();

	/**
	 * ����������
	 * 
	 */
	public IDWindow() {
		manualRefresh = false;
	}

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IDWindow window = new IDWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window
	 */
	public void open() {
		final Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		final Display display = Display.getDefault();
		shell = new Shell();
		shell.setSize(800, 600);
		final GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);
		shell.setText("���ּ��ʵ��ϵͳ");
		Image image = new Image(display, "icons/IDS.png");
		shell.setImage(image);// ���ô������ͼ��

		//���ϵͳ�Ƿ��Ѿ���װwinpcap
		String winPcapPath = System.getenv("windir").substring(0, 2)+"\\Program Files\\WinPcap\\rpcapd.exe";
		if (!(new File(winPcapPath)).isFile()) {
			MsgBox.error(shell, "��ϵͳ�ǻ���WinPcap_4_0_2�ģ�\n�����ϵͳ����û�а�װWinPcap,\n���Ȱ�װ!\n\nϵͳ�޷��������У������˳�...");
			System.exit(0);
		}
		
		final ToolBar toolBar = new ToolBar(shell, SWT.NONE);
		final GridData gd_toolBar = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gd_toolBar.widthHint = 226;
		toolBar.setLayoutData(gd_toolBar);

		final ToolItem toolItemOpen = new ToolItem(toolBar, SWT.PUSH);
		toolItemOpen.setText("��");
		toolItemOpen.setImage(new Image(display, "icons/Open.png"));
		toolItemOpen.setToolTipText("���ļ������ѱ�������ݰ�");

		final ToolItem toolItemSave = new ToolItem(toolBar, SWT.PUSH);
		toolItemSave.setText("����");
		toolItemSave.setImage(new Image(display, "icons/Save.png"));
		toolItemSave.setToolTipText("����ǰ�������ݰ����浽�ļ�");

		final ToolItem newItemToolItem_4 = new ToolItem(toolBar, SWT.SEPARATOR);
		final Label label_a = new Label(toolBar, SWT.SEPARATOR);
		newItemToolItem_4.setControl(label_a);

		final ToolItem toolItemStart = new ToolItem(toolBar, SWT.PUSH);
		toolItemStart.setText("��ʼ");
		toolItemStart.setImage(new Image(display, "icons/Run.png"));

		final ToolItem toolItemStop = new ToolItem(toolBar, SWT.PUSH);
		toolItemStop.setText("��ֹ");
		toolItemStop.setImage(new Image(display, "icons/Stop.png"));
		toolItemStop.setEnabled(false);

		final ToolItem newItemToolItem_1 = new ToolItem(toolBar, SWT.SEPARATOR);
		final Label label = new Label(toolBar, SWT.SEPARATOR);
		newItemToolItem_1.setControl(label);

		final ToolItem toolItemRules = new ToolItem(toolBar, SWT.PUSH);
		toolItemRules.setText("����");
		toolItemRules.setImage(new Image(display, "icons/Rules.png"));

		final ToolItem toolItemReloadRules = new ToolItem(toolBar, SWT.PUSH);
		toolItemReloadRules.setText("���������");
		toolItemReloadRules
				.setImage(new Image(display, "icons/ReLoadRules.png"));

		final ToolItem newItemToolItem_2 = new ToolItem(toolBar, SWT.SEPARATOR);

		final Label label_1 = new Label(toolBar, SWT.SEPARATOR);
		newItemToolItem_2.setControl(label_1);

		final ToolItem toolItemDatabase = new ToolItem(toolBar, SWT.PUSH);
		toolItemDatabase.setText("���ݿ�");
		toolItemDatabase.setImage(new Image(display, "icons/dbs.png"));

		final ToolItem newItemToolItem_3 = new ToolItem(toolBar, SWT.SEPARATOR);

		final Label label_2 = new Label(toolBar, SWT.SEPARATOR);
		newItemToolItem_3.setControl(label_2);

		final ToolItem toolItemSetting = new ToolItem(toolBar, SWT.PUSH);
		toolItemSetting.setText("����");
		toolItemSetting.setImage(new Image(display, "icons/Setting.png"));

		final ToolItem newItemToolItem_b = new ToolItem(toolBar, SWT.SEPARATOR);

		final Label label_b = new Label(toolBar, SWT.SEPARATOR);
		newItemToolItem_b.setControl(label_b);

		final ToolItem toolItemHelp = new ToolItem(toolBar, SWT.PUSH);
		toolItemHelp.setText("����");
		toolItemHelp.setImage(new Image(display, "icons/Help.png"));

		final ToolItem toolItemSeparator = new ToolItem(toolBar, SWT.SEPARATOR);
		toolItemSeparator.setWidth(50);

		final ToolItem newItemToolItem = new ToolItem(toolBar, SWT.SEPARATOR);
		newItemToolItem.setWidth(70);
		final Button buttonCheck = new Button(toolBar, SWT.CHECK);
		buttonCheck.setText("�ֶ�ˢ��");
		buttonCheck.setSelection(false);
		newItemToolItem.setControl(buttonCheck);

		final ToolItem toolItemRefresh = new ToolItem(toolBar, SWT.PUSH);
		toolItemRefresh.setText("ˢ��ͳ��");
		toolItemRefresh.setImage(new Image(display, "icons/Refresh.png"));
		toolItemRefresh.setEnabled(false);

		final Label labelSeparator = new Label(shell, SWT.SEPARATOR
				| SWT.HORIZONTAL);
		final GridData gd_labelSeparator = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		labelSeparator.setLayoutData(gd_labelSeparator);

		final SashForm sashForm = new SashForm(shell, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Composite c1 = new Composite(sashForm, SWT.NONE);
		final GridLayout gd1 = new GridLayout();
		gd1.marginHeight = 0;
		gd1.marginWidth = 0;
		gd1.horizontalSpacing = 0;
		gd1.verticalSpacing = 0;
		c1.setLayout(gd1);
		c1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Label labelStat = new Label(c1, SWT.NONE);
		final GridData gd_labelStat = new GridData(SWT.FILL, SWT.BOTTOM, true,
				false);
		labelStat.setLayoutData(gd_labelStat);
		labelStat.setText("  ������ ��ͳ�ƣ�");

		final SashForm sashForm_1 = new SashForm(c1, SWT.NONE);

		final Composite c4 = new Composite(sashForm_1, SWT.BORDER);
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 3;
		c4.setLayout(gridLayout_1);

		final Label labelIP = new Label(c4, SWT.RIGHT);
		final GridData gd_labelIP = new GridData(SWT.FILL, SWT.CENTER, false,
				true);
		gd_labelIP.widthHint = 50;
		labelIP.setLayoutData(gd_labelIP);
		labelIP.setText("IP��");

		final ProgressBar progressBarIP = new ProgressBar(c4, SWT.NONE);
		final GridData gd_progressBarIP = new GridData(SWT.FILL, SWT.CENTER,
				true, true);
		progressBarIP.setLayoutData(gd_progressBarIP);

		final Label percentIP = new Label(c4, SWT.NONE);
		final GridData gd_percentIP = new GridData(SWT.FILL, SWT.CENTER, false,
				true);
		gd_percentIP.widthHint = 50;
		percentIP.setLayoutData(gd_percentIP);
		percentIP.setText("0 %");

		final Label labelARP = new Label(c4, SWT.RIGHT);
		final GridData gd_labelARP = new GridData(SWT.FILL, SWT.CENTER, false,
				true);
		labelARP.setLayoutData(gd_labelARP);
		labelARP.setText("ARP��");

		final ProgressBar progressBarARP = new ProgressBar(c4, SWT.NONE);
		final GridData gd_progressBarARP = new GridData(SWT.FILL, SWT.CENTER,
				true, true);
		progressBarARP.setLayoutData(gd_progressBarARP);

		final Label percentARP = new Label(c4, SWT.NONE);
		final GridData gd_percentARP = new GridData(SWT.FILL, SWT.CENTER,
				false, true);
		percentARP.setLayoutData(gd_percentARP);
		percentARP.setText("0 %");

		final Label labelTCP = new Label(c4, SWT.RIGHT);
		final GridData gd_labelTCP = new GridData(SWT.FILL, SWT.CENTER, false,
				true);
		labelTCP.setLayoutData(gd_labelTCP);
		labelTCP.setText("TCP��");

		final ProgressBar progressBarTCP = new ProgressBar(c4, SWT.NONE);
		final GridData gd_progressBarTCP = new GridData(SWT.FILL, SWT.CENTER,
				true, true);
		progressBarTCP.setLayoutData(gd_progressBarTCP);

		final Label percentTCP = new Label(c4, SWT.NONE);
		final GridData gd_percentTCP = new GridData(SWT.FILL, SWT.CENTER,
				false, true);
		percentTCP.setLayoutData(gd_percentTCP);
		percentTCP.setText("0 %");

		final Label labelUDP = new Label(c4, SWT.RIGHT);
		final GridData gd_labelUDP = new GridData(SWT.FILL, SWT.CENTER, false,
				true);
		labelUDP.setLayoutData(gd_labelUDP);
		labelUDP.setText("UDP��");

		final ProgressBar progressBarUDP = new ProgressBar(c4, SWT.NONE);
		final GridData gd_progressBarUDP = new GridData(SWT.FILL, SWT.CENTER,
				true, true);
		progressBarUDP.setLayoutData(gd_progressBarUDP);

		final Label percentUDP = new Label(c4, SWT.NONE);
		final GridData gd_percentUDP = new GridData(SWT.FILL, SWT.CENTER,
				false, true);
		percentUDP.setLayoutData(gd_percentUDP);
		percentUDP.setText("0 %");

		final Label labelICMP = new Label(c4, SWT.RIGHT);
		final GridData gd_labelICMP = new GridData(SWT.FILL, SWT.CENTER, false,
				true);
		labelICMP.setLayoutData(gd_labelICMP);
		labelICMP.setText("ICMP��");

		final ProgressBar progressBarICMP = new ProgressBar(c4, SWT.NONE);
		final GridData gd_progressBarICMP = new GridData(SWT.FILL, SWT.CENTER,
				true, true);
		progressBarICMP.setLayoutData(gd_progressBarICMP);

		final Label percentICMP = new Label(c4, SWT.NONE);
		final GridData gd_percentICMP = new GridData(SWT.FILL, SWT.CENTER,
				false, true);
		percentICMP.setLayoutData(gd_percentICMP);
		percentICMP.setText("0 %");

		final Label labelOther = new Label(c4, SWT.RIGHT);
		final GridData gd_labelOther = new GridData(SWT.FILL, SWT.CENTER,
				false, true);
		labelOther.setLayoutData(gd_labelOther);
		labelOther.setText("Other��");

		final ProgressBar progressBarOther = new ProgressBar(c4, SWT.NONE);
		final GridData gd_progressBarOther = new GridData(SWT.FILL, SWT.CENTER,
				true, true);
		progressBarOther.setLayoutData(gd_progressBarOther);

		final Label percentOther = new Label(c4, SWT.NONE);
		final GridData gd_percentOther = new GridData(SWT.FILL, SWT.CENTER,
				false, true);
		percentOther.setLayoutData(gd_percentOther);
		percentOther.setText("0 %");

		final Table tableStat;
		tableStat = new Table(sashForm_1, SWT.FULL_SELECTION | SWT.BORDER);
		tableStat.setLinesVisible(true);
		tableStat.setHeaderVisible(true);

		final TableColumn tableStatColumn1 = new TableColumn(tableStat,
				SWT.LEFT);
		tableStatColumn1.setWidth(40);
		tableStatColumn1.setText("���");

		final TableColumn tableStatColumn2 = new TableColumn(tableStat,
				SWT.RIGHT);
		tableStatColumn2.setWidth(100);
		tableStatColumn2.setText("��");

		final TableColumn tableStatColumn3 = new TableColumn(tableStat,
				SWT.RIGHT);
		tableStatColumn3.setWidth(50);
		tableStatColumn3.setText("����");

		final TableColumn tableStatColumn4 = new TableColumn(tableStat,
				SWT.RIGHT);
		tableStatColumn4.setWidth(80);
		tableStatColumn4.setText("�ܴ�С");

		sashForm_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		sashForm_1.setWeights(new int[] { 1, 1 });

		final Composite c2 = new Composite(sashForm, SWT.BORDER);
		final GridLayout gd2 = new GridLayout();
		gd2.marginHeight = 0;
		gd2.marginWidth = 0;
		gd2.horizontalSpacing = 0;
		gd2.verticalSpacing = 0;
		c2.setLayout(gd2);
		c2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Label labelAlert = new Label(c2, SWT.NONE);
		labelAlert.setText("  ������");

		final Table tableAlert;
		tableAlert = new Table(c2, SWT.FULL_SELECTION);
		tableAlert.setLinesVisible(true);
		tableAlert.setHeaderVisible(true);
		final GridData gd_tableAlert = new GridData(SWT.FILL, SWT.FILL, true,
				true);
		tableAlert.setLayoutData(gd_tableAlert);

		final TableColumn tableColumnIndex = new TableColumn(tableAlert,
				SWT.CENTER);
		tableColumnIndex.setWidth(50);
		tableColumnIndex.setText("���");

		final TableColumn tableColumnProtocol = new TableColumn(tableAlert,
				SWT.CENTER);
		tableColumnProtocol.setWidth(60);
		tableColumnProtocol.setText("Э���");

		final TableColumn tableColumnLen = new TableColumn(tableAlert,
				SWT.CENTER);
		tableColumnLen.setWidth(50);
		tableColumnLen.setText("����");

		final TableColumn tableColumnSIP = new TableColumn(tableAlert,
				SWT.CENTER);
		tableColumnSIP.setWidth(110);
		tableColumnSIP.setText("ԴIP");

		final TableColumn tableColumnSPort = new TableColumn(tableAlert,
				SWT.CENTER);
		tableColumnSPort.setWidth(60);
		tableColumnSPort.setText("Դ�˿�");

		final TableColumn tableColumnDIP = new TableColumn(tableAlert,
				SWT.CENTER);
		tableColumnDIP.setWidth(110);
		tableColumnDIP.setText("Ŀ��IP");

		final TableColumn tableColumnDPort = new TableColumn(tableAlert,
				SWT.CENTER);
		tableColumnDPort.setWidth(65);
		tableColumnDPort.setText("Ŀ�Ķ˿�");

		final TableColumn tableColumnMsg = new TableColumn(tableAlert,
				SWT.CENTER);
		tableColumnMsg.setWidth(250);
		tableColumnMsg.setText("��Ϣ");

		final SashForm sashForm_2 = new SashForm(sashForm, SWT.NONE);

		final Composite composite_0 = new Composite(sashForm_2, SWT.BORDER);
		final GridLayout gd_0 = new GridLayout();
		gd_0.marginHeight = 0;
		gd_0.marginWidth = 0;
		gd_0.horizontalSpacing = 0;
		gd_0.verticalSpacing = 0;
		composite_0.setLayout(gd_0);

		final Label label_3 = new Label(composite_0, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		label_3.setText("����Ϣ��");

		final Label label_7 = new Label(composite_0, SWT.SEPARATOR
				| SWT.HORIZONTAL);
		label_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Tree treePacketInfo;
		treePacketInfo = new Tree(composite_0, SWT.NONE);
		final GridData gd_treePacketInfo = new GridData(SWT.FILL, SWT.FILL,
				true, true);
		treePacketInfo.setLayoutData(gd_treePacketInfo);

		final Composite composite_1 = new Composite(sashForm_2, SWT.BORDER);
		final GridLayout gd_1 = new GridLayout();
		gd_1.marginHeight = 0;
		gd_1.marginWidth = 0;
		gd_1.horizontalSpacing = 0;
		gd_1.verticalSpacing = 0;
		composite_1.setLayout(gd_1);

		final Label label_4 = new Label(composite_1, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		label_4.setText("�����ݣ�");

		final Label label_8 = new Label(composite_1, SWT.SEPARATOR
				| SWT.HORIZONTAL);
		label_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Text textPacketData;
		textPacketData = new Text(composite_1, SWT.WRAP | SWT.V_SCROLL
				| SWT.READ_ONLY);
		final GridData gd_textPacketData = new GridData(SWT.FILL, SWT.FILL,
				true, true);
		textPacketData.setLayoutData(gd_textPacketData);
		textPacketData.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

		final Composite composite_2 = new Composite(sashForm_2, SWT.BORDER);
		final GridLayout gd_2 = new GridLayout();
		gd_2.marginHeight = 0;
		gd_2.marginWidth = 0;
		gd_2.horizontalSpacing = 0;
		gd_2.verticalSpacing = 0;
		composite_2.setLayout(gd_2);

		final Label label_5 = new Label(composite_2, SWT.NONE);
		label_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		label_5.setText("ƥ��Ĺ���");

		final Label label_9 = new Label(composite_2, SWT.SEPARATOR
				| SWT.HORIZONTAL);
		label_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Text textMatchedRule;
		textMatchedRule = new Text(composite_2, SWT.WRAP | SWT.V_SCROLL
				| SWT.READ_ONLY);
		final GridData gd_textMatchedRule = new GridData(SWT.FILL, SWT.FILL,
				true, true);
		textMatchedRule.setLayoutData(gd_textMatchedRule);
		textMatchedRule.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

		final Composite composite_3 = new Composite(sashForm_2, SWT.BORDER);
		final GridLayout gd_3 = new GridLayout();
		gd_3.marginHeight = 0;
		gd_3.marginWidth = 0;
		gd_3.horizontalSpacing = 0;
		gd_3.verticalSpacing = 0;
		composite_3.setLayout(gd_3);

		final Label label_6 = new Label(composite_3, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		label_6.setText("��������");

		final Label label_10 = new Label(composite_3, SWT.SEPARATOR
				| SWT.HORIZONTAL);
		label_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Text textResult;
		textResult = new Text(composite_3, SWT.WRAP | SWT.V_SCROLL
				| SWT.READ_ONLY);
		final GridData gd_textResult = new GridData(SWT.FILL, SWT.FILL, true,
				true);
		textResult.setLayoutData(gd_textResult);
		textResult.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		sashForm_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		sashForm_2.setWeights(new int[] { 1, 1, 1, 1 });

		sashForm.setWeights(new int[] { 1, 1, 1 });
		final Captor idc = new Captor();
		final Analyzer idar = new Analyzer();
		final DBManager dbm = new DBManager();
		final TableItem tableStatItem[] = new TableItem[idar.getProtocolsStat().length];
		for (int i = 0; i < idar.getProtocolsStat().length; i++) {
			tableStatItem[i] = new TableItem(tableStat, SWT.NONE);
			tableStatItem[i].setText(0, "" + i);
		}
		tableStatItem[0].setText(1, "�� ��");
		tableStatItem[1].setText(1, "Ethernet ��");
		tableStatItem[2].setText(1, "IP ��");
		tableStatItem[3].setText(1, "ARP ��");
		tableStatItem[4].setText(1, "TCP ��");
		tableStatItem[5].setText(1, "UDP ��");
		tableStatItem[6].setText(1, "ICMP ��");
		tableStatItem[7].setText(1, "����������·��");
		tableStatItem[8].setText(1, "���������");
		tableStatItem[9].setText(1, "���������");

		class ThreadAnalysis {
			private Thread t;

			private boolean isRunning = false;

			public void Start() {
				isRunning = true;
				t = new Thread() {
					private int index = 0;

					public void run() {
						index = 0;
						// ������ݿ�
						if (isDBconnected) {
							try {
								dbm.clear();
							} catch (SQLException e1) {
								MsgBox.error(shell, "���ݿ��������\n"
										+ e1.toString());
								idc.stop();
								toolItemStop.setEnabled(false);
								toolItemStart.setEnabled(true);
								toolItemSetting.setEnabled(true);
								toolItemReloadRules.setEnabled(true);
								toolItemOpen.setEnabled(true);
								toolItemSave.setEnabled(true);
								toolItemRules.setEnabled(true);
								isRunning = false;
								return;
							}
						}

						// ����־�ļ�
						final FileWriter filewriter;
						try {
							filewriter = new FileWriter(".\\IDS.log");
						} catch (IOException e1) {
							MsgBox.error(shell, "������־�ļ�����\n" + e1.toString());
							idc.stop();
							toolItemStop.setEnabled(false);
							toolItemStart.setEnabled(true);
							toolItemSetting.setEnabled(true);
							toolItemReloadRules.setEnabled(true);
							toolItemOpen.setEnabled(true);
							toolItemSave.setEnabled(true);
							toolItemRules.setEnabled(true);
							isRunning = false;
							return;
						}

						// ��ʼ�����ͼ�����ݰ�
						while (isRunning) {
							if (idc.packetsBuffer.size() == 0) {
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									if (idc.packetsBuffer.size() == 0) {
										return;
									} else {
										Packet p = idc.packetsBuffer
												.removeFirst();
										if (p == null || p.equals(Packet.EOF)) {
											isRunning = false;
											return;
										}
										idar.analysis(p);
										// ͳ��
										if (!manualRefresh) {
											long pStat[][] = idar
													.getProtocolsStat();
											for (int i = 0; i < tableStatItem.length; i++) {
												tableStatItem[i].setText(2, ""
														+ pStat[i][0]);
												tableStatItem[i].setText(3, ""
														+ pStat[i][1]);
											}

											BigInteger numIP = BigInteger
													.valueOf((pStat[2][0] * 100)
															/ pStat[0][0]);
											BigInteger numARP = BigInteger
													.valueOf((pStat[3][0] * 100)
															/ pStat[0][0]);
											BigInteger numTCP = BigInteger
													.valueOf((pStat[4][0] * 100)
															/ pStat[0][0]);
											BigInteger numUDP = BigInteger
													.valueOf((pStat[5][0] * 100)
															/ pStat[0][0]);
											BigInteger numICMP = BigInteger
													.valueOf((pStat[6][0] * 100)
															/ pStat[0][0]);
											BigInteger numOther = BigInteger
													.valueOf(((pStat[7][0]
															+ pStat[8][0] + pStat[9][0]) * 100)
															/ pStat[0][0]);
											progressBarIP.setSelection(numIP
													.intValue());
											progressBarARP.setSelection(numARP
													.intValue());
											progressBarTCP.setSelection(numTCP
													.intValue());
											progressBarUDP.setSelection(numUDP
													.intValue());
											progressBarICMP
													.setSelection(numICMP
															.intValue());
											progressBarOther
													.setSelection(numOther
															.intValue());
											percentIP.setText(numIP.toString()
													+ " %");
											percentARP.setText(numARP
													.toString()
													+ " %");
											percentTCP.setText(numTCP
													.toString()
													+ " %");
											percentUDP.setText(numUDP
													.toString()
													+ " %");
											percentICMP.setText(numICMP
													.toString()
													+ " %");
											percentOther.setText(numOther
													.toString()
													+ " %");
										}

										// ����
										while (idar.alertRulesBuffer.size() != 0) {
											Rule r = idar.alertRulesBuffer
													.removeFirst();
											TableItems alertInfo = new TableItems();
											alertInfo.analyzePacket(p);
											String[] tableItem = new String[8];
											tableItem[0] = String
													.valueOf(index);
											for (int i = 0; i < 6; i++) {
												if (alertInfo
														.getTableItemInfo()[i] != null)
													tableItem[i + 1] = alertInfo
															.getTableItemInfo()[i];
												else
													tableItem[i + 1] = "*";
											}
											tableItem[7] = r.msg;
											new TableItem(tableAlert, SWT.NONE)
													.setText(tableItem);
											tableAlert.setTopIndex(index);

											if (dbm.conn == null
													&& isDBconnected) {
												isDBconnected = false;
												MsgBox.warning(shell, "���ݿ�Ͽ�");
											}
											if (dbm.conn != null
													&& !isDBconnected) {
												isDBconnected = true;
												MsgBox.warning(shell, "���ݿ�������");
											}
											String oprResult = null;
											switch (r.action) {
											// 1:Alert; 2:Log; 3:Pass
											case 1: {
												// Alert
												if (isDBconnected) {
													oprResult = "�ѷ�����������д�����ݿ�";
													try {
														dbm
																.addAlertInfo(
																		index,
																		p,
																		r
																				.getStringRule(),
																		oprResult);
													} catch (SQLException e) {
														oprResult = "�ѷ���������δд�����ݿ�";
													}

												} else
													oprResult = "�ѷ���������δд�����ݿ�";
											}
												break;
											case 2: {
												// log
												// д����־
												try {
													filewriter
															.write(new java.util.Date(
																	p.sec
																			* 1000
																			+ p.usec
																			/ 1000)
																	.toString()
																	+ " Packet: length="
																	+ p.caplen
																	+ "; protocol="
																	+ r
																			.getProtocol()
																	+ "; RuleMsg:"
																	+ r.msg
																	+ "\n");
													oprResult = "�ѷ�����������д����־";
												} catch (IOException e1) {
													oprResult = "�ѷ���������δд����־";
												}

												// д�����ݿ�
												if (isDBconnected) {
													oprResult += "����д�����ݿ�";
													try {
														dbm
																.addAlertInfo(
																		index,
																		p,
																		r
																				.getStringRule(),
																		oprResult);
													} catch (SQLException e) {
														oprResult += "��δд�����ݿ�";
													}
												} else {
													oprResult += "��δд�����ݿ�";
												}

											}
												break;

											case 3: {
												// pass
												oprResult = "�Ѻ���";
											}
												break;
											default:
												break;

											}
											alertList.add(new Alert(r, p,
													oprResult));
											index++;

										}

										Thread.yield();

									}
								}
							});
						}

						try {
							filewriter.close();
						} catch (IOException e) {
						}
					}
				};
				t.setPriority(Thread.MIN_PRIORITY);
				t.start();
			}

			public void Stop() {
				isRunning = false;
			}
		}

		final ThreadAnalysis threadAnalysis = new ThreadAnalysis();

		toolItemHelp.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				try {
					// �򿪰����ĵ�
					Runtime.getRuntime().exec("cmd /c  start .\\Help.chm ");
				} catch (IOException e1) {
					MsgBox.warning(shell, "�޷��򿪰����ļ��������ļ������Ѷ�ʧ");
				}
			}
		});

		toolItemDatabase.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				DatabaseDlg dbDlg = new DatabaseDlg(dbm, isDBconnected);
				// ��һ����Ҫע�⣺
				// ����dbm����Ϊһ�����崫�ݸ�DatabaseDlg�ģ����ݵ��ǵ�ַ����
				// ��ˣ���dbDlg�������κθı䶼��ֱ��Ӱ��dbm��
				// ���ԣ�����dbDlg����Ҫ�ٷ���һ��DBManager���͸�dbm
				if (dbDlg.open()) {
					isDBconnected = true;
				} else {
					if (isDBconnected) {
						isDBconnected = false;

						int isContinue = MsgBox.OKCancel(shell, "���ݿ�Ͽ�:\n"
								+ "\nϵͳ�����Լ������������޷������ݿ���д�����ݣ�Ҫ������?"
								+ "\n�����ȷ���������������ȡ�����˳�...");
						if (isContinue == SWT.OK) {
							isDBconnected = false;
						} else {
							isDBconnected = false;
							System.exit(0);
						}
					}
				}
			}
		});
		toolItemRules.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				RulesDlg rDlg = new RulesDlg();
				rDlg.open();
			}
		});
		toolItemSetting.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				SettingDlg sDlg = new SettingDlg(shell, SWT.NONE, idc
						.getDevIndex(), idc.getMaxLen(), idc.getIsProm());
				sDlg.open();
				idc.setDevIndex(sDlg.getSelectDev());
				idc.setMaxLen(sDlg.getMaxPacketLen());
				idc.setIsProm(sDlg.getIsPromiscuous());
			}
		});

		buttonCheck.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				if (buttonCheck.getSelection()) {
					toolItemRefresh.setEnabled(true);
					manualRefresh = true;
				} else {
					// String msg = "���Ƽ�ʹ�÷��ֶ�ˢ�£�" + "\n\n���ֶ�ˢ������ϵͳ�Զ�����ͳ������ˢ��,"
					// + "\n������������ϵͳ������ʱ����ʧ���ݰ���" + "\n��ȷ��ʹ�÷��ֶ�ˢ����";
					// if (SWT.YES == MsgBox.YesNo(shell, msg)) {
					toolItemRefresh.setEnabled(false);
					manualRefresh = false;
					// } else
					// buttonCheck.setSelection(true);
				}
			}
		});

		toolItemStart.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				toolItemStart.setEnabled(false);
				toolItemSetting.setEnabled(false);
				toolItemRules.setEnabled(false);
				toolItemReloadRules.setEnabled(false);
				toolItemOpen.setEnabled(false);
				toolItemSave.setEnabled(false);
				idar.clearProtocolsStat();
				tableAlert.removeAll();
				treePacketInfo.removeAll();
				textPacketData.setText("");
				textMatchedRule.setText("");
				textResult.setText("");

				alertList.clear();

				idc.start();
				threadAnalysis.Start();
				toolItemStop.setEnabled(true);
			}
		});

		toolItemStop.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				idc.stop();

				try {
					Thread.sleep(100);
					toolItemStop.setEnabled(false);
					toolItemStart.setEnabled(true);
					toolItemSetting.setEnabled(true);
					toolItemReloadRules.setEnabled(true);
					toolItemOpen.setEnabled(true);
					toolItemSave.setEnabled(true);
					toolItemRules.setEnabled(true);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				threadAnalysis.Stop();
			}
		});

		toolItemRefresh.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				long pStat[][] = idar.getProtocolsStat();
				for (int i = 0; i < tableStatItem.length; i++) {
					tableStatItem[i].setText(2, "" + pStat[i][0]);
					tableStatItem[i].setText(3, "" + pStat[i][1]);
				}

				BigInteger numIP = BigInteger.valueOf((pStat[2][0] * 100)
						/ pStat[0][0]);
				BigInteger numARP = BigInteger.valueOf((pStat[3][0] * 100)
						/ pStat[0][0]);
				BigInteger numTCP = BigInteger.valueOf((pStat[4][0] * 100)
						/ pStat[0][0]);
				BigInteger numUDP = BigInteger.valueOf((pStat[5][0] * 100)
						/ pStat[0][0]);
				BigInteger numICMP = BigInteger.valueOf((pStat[6][0] * 100)
						/ pStat[0][0]);
				BigInteger numOther = BigInteger.valueOf(((pStat[7][0]
						+ pStat[8][0] + pStat[9][0]) * 100)
						/ pStat[0][0]);
				progressBarIP.setSelection(numIP.intValue());
				progressBarARP.setSelection(numARP.intValue());
				progressBarTCP.setSelection(numTCP.intValue());
				progressBarUDP.setSelection(numUDP.intValue());
				progressBarICMP.setSelection(numICMP.intValue());
				progressBarOther.setSelection(numOther.intValue());
				percentIP.setText(numIP.toString() + " %");
				percentARP.setText(numARP.toString() + " %");
				percentTCP.setText(numTCP.toString() + " %");
				percentUDP.setText(numUDP.toString() + " %");
				percentICMP.setText(numICMP.toString() + " %");
				percentOther.setText(numOther.toString() + " %");
			}
		});

		shell.addShellListener(new ShellAdapter() {
			public void shellClosed(final ShellEvent e) {
				idc.stop();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
				}
				threadAnalysis.Stop();
				try {
					dbm.closeConnection();
				} catch (SQLException e1) {
				}
			}
		});

		shell.addPaintListener(new PaintListener() {
			public void paintControl(final PaintEvent e) {
				if (!isInit) {
					isInit = true;

					shell.setEnabled(false);
					final Shell initShell = new Shell(SWT.ON_TOP);
					final GridLayout gd = new GridLayout();
					gd.numColumns = 3;
					gd.marginHeight = 0;
					gd.marginWidth = 0;
					gd.horizontalSpacing = 0;
					gd.verticalSpacing = 0;
					initShell.setLayout(gd);
					initShell.setSize(360, 140);

					Image image = new Image(display, "icons/Init.gif");
					final Canvas canvas = new Canvas(initShell, SWT.NONE);
					final GridData gd_canvas = new GridData(SWT.LEFT, SWT.FILL,
							false, true, 1, 2);
					gd_canvas.widthHint = 70;
					canvas.setLayoutData(gd_canvas);
					canvas.setBackgroundImage(image);

					final Label label_2 = new Label(initShell, SWT.NONE);
					final GridData gd_label2 = new GridData(SWT.FILL, SWT.FILL,
							false, true, 1, 2);
					gd_label2.widthHint = 20;
					label_2.setLayoutData(gd_label2);

					final Label label = new Label(initShell, SWT.NONE);
					label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
							true, true));
					label.setText("���ڳ�ʼ��...");

					final Label labelInit = new Label(initShell, SWT.NONE);
					labelInit.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM,
							true, true));

					final ProgressBar pBar = new ProgressBar(initShell,
							SWT.NONE);
					pBar.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM,
							false, false, 3, 1));
					initShell.setLocation((shell.getSize().x
							+ shell.getLocation().x - 180) / 2, (shell
							.getSize().y
							+ shell.getLocation().y - 70) / 2);
					//
					initShell.open();
					initShell.layout();

					// ������γ������ڽ��洴��ʱ�Զ���������ļ�
					File dir = new File(".\\data\\rules");
					if (!dir.isDirectory()) {
						dir.mkdirs();
					}
					idar.ethernetList.clear();
					idar.ipList.clear();
					idar.arpList.clear();
					idar.tcpList.clear();
					idar.udpList.clear();
					idar.icmpList.clear();
					idar.otherList.clear();
					boolean isError = false;
					int fileCount = 0;
					String[] fileListName = dir.list();
					for (int i = 0; i < fileListName.length; i++) {
						if (fileListName[i].endsWith(".rule")) {
							// .substring(fileListName[i].length() - 5,
							// fileListName[i].length()).equals(".rule")
							fileCount++;
							pBar.setSelection((pBar.getMaximum() * (i + 1))
									/ (fileListName.length * 2));
							labelInit.setText("���ڶ�ȡ�����ļ���" + fileListName[i]
									+ "...");
							try {
								Compiler c = new Compiler();
								String msg;
								FileReader fileReader = new FileReader(
										".\\data\\rules\\" + fileListName[i]);
								BufferedReader reader = new BufferedReader(
										fileReader);
								String line = null;
								while ((line = reader.readLine()) != null) {
									msg = c.compile(line);
									if (msg.equals("����ɹ�")) {
										switch (c.getRule().protocol) {
										case 1:
											idar.ethernetList.add(c.getRule());
											break;
										case 2:
											idar.ipList.add(c.getRule());
											break;
										case 3:
											idar.arpList.add(c.getRule());
											break;
										case 4:
											idar.tcpList.add(c.getRule());
											break;
										case 5:
											idar.udpList.add(c.getRule());
											break;
										case 6:
											idar.icmpList.add(c.getRule());
											break;
										case 7:
											idar.otherList.add(c.getRule());
											break;
										}
									} else {
										isError = true;
									}
								}
								fileReader.close();
							} catch (IOException ioE) {
								MsgBox.error(initShell, "��ȡ�ļ�ʧ�ܣ�\n"
										+ ioE.toString());
								return;
							}

						}
					}
					if (fileCount == 0)
						MsgBox
								.warning(initShell,
										"û�ж����κι����ļ���.\\data\\rules\\�ļ�����û�з���Ҫ��� .rule �ļ�");
					else {
						if (isError)
							MsgBox.warning(initShell, "���������⣬�����е�ĳЩ�ļ�"
									+ "\n���һЩ������ڴ���ϵͳ�Ѿ�����"
									+ "\n����Щ���������ʹ�ù����������" + "\n����Щ������򣬲��޸ġ�");
					}

					// �����ǳ�ʼ�����ݿ�
					pBar.setSelection((pBar.getMaximum() * 3) / 4);
					labelInit.setText("�������ݿ�...");
					DBConnectDlg dbDlg = new DBConnectDlg(initShell, dbm.url,
							dbm.driverName, dbm.username, dbm.password);
					if (!dbDlg.open()) {
						int isContinue = MsgBox.OKCancel(initShell,
								"��ѡ���˲�ʹ�����ݿ⣬"

								+ "\n\n" + "ϵͳ�����Լ������������޷������ݿ���д�����ݣ�Ҫ������?"
										+ "\n�����ȷ���������������ȡ�����˳�...");
						pBar.setSelection((pBar.getMaximum() * 5) / 6);
						if (isContinue == SWT.OK) {
							isDBconnected = false;
							shell.setEnabled(true);
							initShell.close();
							return;
						} else {
							isDBconnected = false;
							initShell.close();
							System.exit(0);
							return;
						}
					}
					dbm.url = dbDlg.getURL();
					dbm.driverName = dbDlg.getDriverName();
					dbm.username = dbDlg.getUserName();
					dbm.password = dbDlg.getPassword();

					labelInit.setText("�����������ݿ�...");
					try {
						pBar.setSelection((pBar.getMaximum() * 5) / 6);
						dbm.connect();
						isDBconnected = true;
						pBar.setSelection(pBar.getMaximum());
						labelInit.setText("������!");
						shell.setEnabled(true);
						initShell.close();
					} catch (Exception e1) {
						int isContinue = MsgBox.OKCancel(initShell,
								"���ݿ�����ʧ��:\n" + e1.toString() + "\n\n"
										+ "ϵͳ�����Լ������������޷������ݿ���д�����ݣ�Ҫ������?"
										+ "\n�����ȷ���������������ȡ�����˳�...");
						if (isContinue == SWT.OK) {
							isDBconnected = false;
							shell.setEnabled(true);
							initShell.close();
							return;
						} else {
							isDBconnected = false;
							initShell.close();
							System.exit(0);
							return;
						}
					}

				}
			}
		});

		tableAlert.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				int selIndex = tableAlert.getSelectionIndex();
				Alert a = alertList.get(selIndex);
				Packet p = a.p;
				textPacketData.setText(PacketData.showPacketData(p));
				textMatchedRule.setText(a.r.getStringRule());
				textResult.setText(a.oprResult);
				treePacketInfo.removeAll();
				List<IDPacketAnalyzer> analyzers = new PacketAnalyzerLoader()
						.getAnalyzers();
				for (IDPacketAnalyzer analyzer : analyzers) {
					if (analyzer.isAnalyzable(p)) {
						analyzer.analyze(p);
						TreeItem treeNode = new TreeItem(treePacketInfo,
								SWT.NONE);
						treeNode.setText(analyzer.getProtocolName());
						treeNode.setImage(new Image(display,
								"icons/PrimaryKey.png"));
						String[] names = analyzer.getValueNames();
						Object[] values = analyzer.getValues();
						if (names == null)
							continue;

						for (int j = 0; j < names.length; j++) {
							if (values[j] != null) {
								new TreeItem(treeNode, SWT.NULL)
										.setText(names[j] + ": " + values[j]);
							} else {
								new TreeItem(treeNode, SWT.NULL)
										.setText(names[j] + ": Not available");
							}
						}
						treeNode.setExpanded(true);
					}
				}
			}
		});

		toolItemReloadRules.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				File dir = new File(".\\data\\rules");
				if (!dir.isDirectory()) {
					dir.mkdirs();
				}
				idar.ethernetList.clear();
				idar.ipList.clear();
				idar.arpList.clear();
				idar.tcpList.clear();
				idar.udpList.clear();
				idar.icmpList.clear();
				idar.otherList.clear();
				boolean isError = false;
				int fileCount = 0;
				String[] fileListName = dir.list();
				for (int i = 0; i < fileListName.length; i++) {
					if (fileListName[i].endsWith(".rule")) {
						fileCount++;
						try {
							Compiler c = new Compiler();
							String msg;
							FileReader fileReader = new FileReader(
									".\\data\\rules\\" + fileListName[i]);
							BufferedReader reader = new BufferedReader(
									fileReader);
							String line = null;
							while ((line = reader.readLine()) != null) {
								msg = c.compile(line);
								if (msg.equals("����ɹ�")) {
									switch (c.getRule().protocol) {
									case 1:
										idar.ethernetList.add(c.getRule());
										break;
									case 2:
										idar.ipList.add(c.getRule());
										break;
									case 3:
										idar.arpList.add(c.getRule());
										break;
									case 4:
										idar.tcpList.add(c.getRule());
										break;
									case 5:
										idar.udpList.add(c.getRule());
										break;
									case 6:
										idar.icmpList.add(c.getRule());
										break;
									case 7:
										idar.otherList.add(c.getRule());
										break;
									}
								} else {
									isError = true;
								}
							}
							fileReader.close();
						} catch (IOException ioE) {
							MsgBox.error(shell, "��ȡ�ļ�ʧ�ܣ�\n" + ioE.toString());
							return;
						}

					}
				}
				if (fileCount == 0)
					MsgBox.warning(shell,
							"û�ж����κι����ļ���.\\data\\rules\\�ļ�����û�з���Ҫ��� .rule �ļ�");
				else {

					if (isError)
						MsgBox.warning(shell, "���������������⣬������ĳЩ�ļ�"
								+ "\n�е�һЩ������ڴ���ϵͳ�Ѿ�����" + "\n����Щ���������ʹ�ù����������"
								+ "\n����Щ������򣬲��޸ġ�");
					else
						MsgBox.information(shell, "�Ѷ�ȡ.\\data\\rules\\�ļ����µ�"
								+ fileCount + "�������ļ���������������������");
				}
			}

		});
		toolItemOpen.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				if (!(new File(".\\data\\sniffer")).isDirectory()) {
					(new File(".\\data\\sniffer")).mkdirs();
				}
				dlg.setText("���ѱ�������ݰ�");
				dlg.setFilterExtensions(new String[] { "*.snf" });
				dlg.setFilterPath(".\\data\\sniffer");
				String path = dlg.open();
				if (path == null)
					return;
				try {
					JpcapCaptor j = JpcapCaptor.openFile(path);
					if (j == null) {
						MsgBox.warning(shell, "��ȡ�ļ�ʧ�ܣ�(��ע�����·���в��ܺ�������)\n"
								+ path);
						return;
					}

					idar.clearProtocolsStat();
					tableAlert.removeAll();
					treePacketInfo.removeAll();
					textPacketData.setText("");
					textMatchedRule.setText("");
					textResult.setText("");

					alertList.clear();

					idc.loadFile(j);
					threadAnalysis.Start();

				} catch (IOException ioE) {
					MsgBox.warning(shell, "��ȡ�ļ�ʧ�ܣ�(��ע����ı����в��ܺ�������)\n"
							+ ioE.toString());
					return;
				}
			}
		});

		toolItemSave.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				FileDialog dlg = new FileDialog(shell, SWT.SAVE);
				if (!(new File(".\\data\\sniffer")).isDirectory()) {
					(new File(".\\data\\sniffer")).mkdirs();
				}
				dlg.setText("���沶������ݰ�");
				dlg.setFilterExtensions(new String[] { "*.snf" });
				dlg.setFilterPath(".\\data\\sniffer");
				String path = dlg.open();
				if (path == null)
					return;
				try {
					JpcapWriter writer = JpcapWriter.openDumpFile(idc
							.getJpcap(), path);
					for (int i = 0; i < alertList.size(); i++) {
						writer.writePacket(alertList.get(i).p);
					}
					writer.close();
				} catch (IOException ioE) {
					MsgBox.warning(shell, "д���ļ�ʧ�ܣ�(��ע�����·���в��ܺ�������)\n"
							+ ioE.toString());
				}
			}
		});

	}

}
