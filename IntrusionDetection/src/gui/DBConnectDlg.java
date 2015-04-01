package gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 数据库连接对话框
 * 
 * @author 张广
 * 
 */
public class DBConnectDlg extends Dialog {

	protected Shell shell;

	private boolean result = false;

	private String URL;

	private String DriverName;

	private String Username;

	private String Password;

	/**
	 * 构造对话框
	 * 
	 * @param parent
	 *            父shell
	 * @param url
	 * @param driverName
	 * @param username
	 * @param password
	 */
	public DBConnectDlg(Shell parent, String url, String driverName,
			String username, String password) {
		super(parent, SWT.NONE);
		URL = url;
		DriverName = driverName;
		Username = username;
		Password = password;
	}

	/**
	 * 获得url，其中含有IP，端口，数据库名称
	 * 
	 * @return 返回url
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * 获得JDBC驱动的名字
	 * 
	 * @return DriverName
	 */
	public String getDriverName() {
		return DriverName;
	}

	/**
	 * 获得用户名
	 * 
	 * @return username
	 */
	public String getUserName() {
		return Username;
	}

	/**
	 * 获得密码
	 * 
	 * @return password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * Open the dialog
	 * 
	 * @return the result
	 */
	public boolean open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return result;
	}

	/**
	 * Create contents of the dialog
	 */
	protected void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		shell.setLayout(gridLayout);
		shell.setSize(367, 285);
		shell.setText("数据库连接");

		final Text textPassword;
		final Text textUsername;
		final Text textDBName;
		final Text textPort;
		final Text textIP;

		final Label label_3 = new Label(shell, SWT.NONE);
		label_3.setLayoutData(new GridData());
		label_3.setText("         ");

		final Label label = new Label(shell, SWT.NONE);
		label.setText("IP地址：");

		textIP = new Text(shell, SWT.BORDER);

		final GridData gd_textIP = new GridData(SWT.LEFT, SWT.CENTER, true,
				false);
		gd_textIP.widthHint = 190;
		textIP.setLayoutData(gd_textIP);
		new Label(shell, SWT.NONE);

		final Label label_1 = new Label(shell, SWT.NONE);
		label_1.setLayoutData(new GridData());
		label_1.setText("端口：");

		textPort = new Text(shell, SWT.BORDER);
		final GridData gd_textPort = new GridData(SWT.LEFT, SWT.CENTER, true,
				false);
		gd_textPort.widthHint = 75;
		textPort.setLayoutData(gd_textPort);
		new Label(shell, SWT.NONE);

		final Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("数据库名称：");

		textDBName = new Text(shell, SWT.BORDER);
		final GridData gd_textDBName = new GridData(SWT.LEFT, SWT.CENTER, true,
				false);
		gd_textDBName.widthHint = 190;
		textDBName.setLayoutData(gd_textDBName);
		new Label(shell, SWT.NONE);

		final Button radio2005 = new Button(shell, SWT.RADIO);
		final GridData gd_radio2005 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1);
		radio2005.setLayoutData(gd_radio2005);
		radio2005.setText("Microsoft SQL server 2005");
		new Label(shell, SWT.NONE);

		final Button radio2000 = new Button(shell, SWT.RADIO);
		final GridData gd_radio2000 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1);
		radio2000.setLayoutData(gd_radio2000);
		radio2000.setText("Microsoft SQL server 2000");

		final Label label_4 = new Label(shell, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				3, 1));
		label_4.setText(" ");
		new Label(shell, SWT.NONE);

		final Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("用户名：");

		textUsername = new Text(shell, SWT.BORDER);
		textUsername.setText(Username);
		final GridData gd_textUsername = new GridData(SWT.LEFT, SWT.CENTER,
				true, false);
		gd_textUsername.widthHint = 120;
		textUsername.setLayoutData(gd_textUsername);
		new Label(shell, SWT.NONE);

		final Label label_6 = new Label(shell, SWT.NONE);
		label_6.setText("密码：");

		textPassword = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		textPassword.setText(Password);
		final GridData gd_textPassword = new GridData(SWT.LEFT, SWT.CENTER,
				true, false);
		gd_textPassword.widthHint = 120;
		textPassword.setLayoutData(gd_textPassword);
		new Label(shell, SWT.NONE);

		final Label label_7 = new Label(shell, SWT.NONE);
		label_7.setText(" ");

		final Button buttonRemember = new Button(shell, SWT.CHECK);
		final GridData gd_buttonRemember = new GridData(SWT.CENTER, SWT.CENTER,
				false, false);
		buttonRemember.setLayoutData(gd_buttonRemember);
		buttonRemember.setText("记住该连接");
		buttonRemember.setSelection(true);

		final Label label_8 = new Label(shell, SWT.NONE);
		label_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				3, 1));
		new Label(shell, SWT.NONE);

		final Button buttonOK = new Button(shell, SWT.NONE);
		final GridData gd_buttonOK = new GridData(SWT.RIGHT, SWT.BOTTOM, false,
				true);
		buttonOK.setLayoutData(gd_buttonOK);
		buttonOK.setText("连接");

		final Button buttonCancel = new Button(shell, SWT.NONE);

		final GridData gd_buttonCancel = new GridData(SWT.CENTER, SWT.BOTTOM,
				false, true);
		buttonCancel.setLayoutData(gd_buttonCancel);
		buttonCancel.setText("取消");
		buttonCancel.setToolTipText("单击“取消”放弃使用数据库");

		// 下面解析URL：
		String IP;
		String Port;
		String DBName;

		if (URL.startsWith("jdbc:sqlserver://")) {
			// "jdbc:sqlserver://localhost:1433;DatabaseName=IDS"
			int idxIP = URL.indexOf("//") + 2;
			int idxPort = URL.indexOf(":", idxIP) + 1;
			IP = URL.substring(idxIP, idxPort - 1);
			Port = URL.substring(idxPort, URL.indexOf(";", idxPort));
			DBName = URL.substring(URL.indexOf("=", idxPort) + 1);
			radio2005.setSelection(true);
			radio2000.setSelection(false);
		} else {
			// "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=IDS"
			int idxIP = URL.indexOf("//") + 2;
			int idxPort = URL.indexOf(":", idxIP) + 1;
			IP = URL.substring(idxIP, idxPort - 1);
			Port = URL.substring(idxPort, URL.indexOf(";", idxPort));
			DBName = URL.substring(URL.indexOf("=", idxPort) + 1);
			radio2005.setSelection(false);
			radio2000.setSelection(true);
		}
		textIP.setText(IP);
		textPort.setText(Port);
		textDBName.setText(DBName);
		//
		buttonOK.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String IP;
				String Port;
				String DBName;

				// 检测IP地址
				if (textIP.getText().toLowerCase().equals("localhost"))
					IP = "localhost";
				else if (textIP.getText().matches(
						"\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
					String[] tempIP = textIP.getText().split("\\.");
					if (Integer.parseInt(tempIP[0]) < 256
							&& Integer.parseInt(tempIP[1]) < 256
							&& Integer.parseInt(tempIP[2]) < 256
							&& Integer.parseInt(tempIP[3]) < 256) {
						IP = textIP.getText();
					} else {
						MsgBox.warning(shell, "IP地址的每一项都必须在[0,255]之间");
						return;
					}
				} else {
					MsgBox.warning(shell, "IP地址格式不合法");
					return;
				}
				// 检测端口
				if (textPort.getText().matches("[0-9]+")
						&& Integer.parseInt(textPort.getText()) <= 65535)
					Port = textPort.getText();
				else {
					MsgBox.warning(shell, "端口必须是数字，且大小在[0,65535]之间");
					return;
				}

				DBName = textDBName.getText();
				Username = textUsername.getText();
				Password = textPassword.getText();

				if (radio2005.getSelection()) {
					DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					URL = "jdbc:sqlserver://" + IP + ":" + Port
							+ ";DatabaseName=" + DBName;
					// radio2000.setSelection(false);
				} else {
					DriverName = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
					URL = "jdbc:microsoft:sqlserver://" + IP + ":" + Port
							+ ";DatabaseName=" + DBName;
					// radio2000.setSelection(true);
				}
				result = true;

				if (buttonRemember.getSelection()) {
					if (!(new File(".\\data")).isDirectory()) {
						(new File(".\\data")).mkdirs();
					}
					try {
						FileWriter filewriter = new FileWriter(
								".\\data\\defaultDatabase.ini");
						filewriter.write("driverName = " + DriverName + "\n");
						filewriter.write("url = " + URL + "\n");
						filewriter.write("username = " + Username + "\n");
						filewriter.write("password = " + Password + "\n");
						filewriter.close();
					} catch (IOException ioE) {
						MsgBox.error(shell, "写入文件失败：" + ioE.toString());
						return;
					}
				}
				shell.close();
			}
		});

		buttonCancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				result = false;
				shell.close();
			}
		});

	}

}
