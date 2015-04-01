package gui;

import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;

import database.DBManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * 数据库管理器窗口
 * 
 * @author 张广
 * 
 */
public class DatabaseDlg {

	protected Shell shell;

	private DBManager db;

	private boolean isConnected = false;

	/**
	 * 初始化该数据库管理器
	 * 
	 * @param dbm
	 * @param isConnected
	 */
	public DatabaseDlg(DBManager dbm, boolean isConnected) {
		db = dbm;
		this.isConnected = isConnected;
	}

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DatabaseDlg window = new DatabaseDlg(new DBManager(), false);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window
	 * 
	 * @return 如果建立了连接，返回true，否则，返回false
	 */
	public boolean open() {
		final Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return isConnected;
	}

	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		final Display display = Display.getDefault();
		shell = new Shell();
		shell.setSize(600, 400);
		final GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);
		Image image = new Image(display, "icons/db.png");
		shell.setImage(image);// 设置窗体标题图标

		final ToolBar toolBar = new ToolBar(shell, SWT.NONE);
		toolBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final ToolItem toolItemNew = new ToolItem(toolBar, SWT.PUSH);
		toolItemNew.setText("新建连接");
		toolItemNew.setToolTipText("新建数据库连接");
		toolItemNew.setImage(new Image(display, "icons/NewConnection.png"));

		final ToolItem toolItemCut = new ToolItem(toolBar, SWT.PUSH);
		toolItemCut.setText("断开连接");
		toolItemCut.setToolTipText("断开数据库连接");
		toolItemCut.setImage(new Image(display, "icons/CutConnection.png"));

		ToolItem toolItemSptr_1 = new ToolItem(toolBar, SWT.SEPARATOR);
		Label label_1 = new Label(toolBar, SWT.SEPARATOR);
		toolItemSptr_1.setControl(label_1);

		final ToolItem toolItemExe = new ToolItem(toolBar, SWT.PUSH);
		toolItemExe.setText("执行查询");
		toolItemExe.setImage(new Image(display, "icons/Add.png"));

		ToolItem toolItemSptr_3 = new ToolItem(toolBar, SWT.SEPARATOR);

		Label label_3 = new Label(toolBar, SWT.SEPARATOR);
		toolItemSptr_3.setControl(label_3);

		final ToolItem toolItemAbout = new ToolItem(toolBar, SWT.PUSH);
		toolItemAbout.setText("关于");

		toolItemAbout.setToolTipText("关于数据库管理器");
		toolItemAbout.setImage(new Image(display, "icons/Help.png"));

		final SashForm sashForm_1 = new SashForm(shell, SWT.VERTICAL);
		sashForm_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Table table;
		table = new Table(sashForm_1, SWT.FULL_SELECTION | SWT.BORDER);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final SashForm sashForm_2 = new SashForm(sashForm_1, SWT.NONE);

		final Text textEditQuery = new Text(sashForm_2, SWT.WRAP | SWT.V_SCROLL
				| SWT.MULTI | SWT.BORDER);

		final Text textDBInfo = new Text(sashForm_2, SWT.WRAP | SWT.V_SCROLL
				| SWT.READ_ONLY | SWT.MULTI | SWT.BORDER);
		textDBInfo.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		textDBInfo.setForeground(display.getSystemColor(SWT.COLOR_RED));

		sashForm_2.setWeights(new int[] { 5, 2 });
		sashForm_1.setWeights(new int[] { 3, 2 });

		if (isConnected) {
			// 下面解析URL：
			String IP;
			String Port;
			String DBName;

			if (db.url.startsWith("jdbc:sqlserver://")) {
				// "jdbc:sqlserver://localhost:1433;DatabaseName=IDS"
				int idxIP = db.url.indexOf("//") + 2;
				int idxPort = db.url.indexOf(":", idxIP) + 1;
				IP = db.url.substring(idxIP, idxPort - 1);
				Port = db.url.substring(idxPort, db.url.indexOf(";", idxPort));
				DBName = db.url.substring(db.url.indexOf("=", idxPort) + 1);
				shell.setText("IDS 数据库管理器 - " + IP + ":" + Port + " / "
						+ DBName + ":" + db.username + " / AlertInfo");
			} else {
				// "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=IDS"
				int idxIP = db.url.indexOf("//") + 2;
				int idxPort = db.url.indexOf(":", idxIP) + 1;
				IP = db.url.substring(idxIP, idxPort - 1);
				Port = db.url.substring(idxPort, db.url.indexOf(";", idxPort));
				DBName = db.url.substring(db.url.indexOf("=", idxPort) + 1);
				shell.setText("IDS 数据库管理器 - " + IP + ":" + Port + " / "
						+ DBName + ":" + db.username+" / AlertInfo");
			}
			// 下面从数据库读入数据
			try {
				ResultSet rs = db.getAll();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				TableColumn tableColumn0 = new TableColumn(table, SWT.NONE);
				tableColumn0.setWidth(50);
				tableColumn0.setText("index");
				int index = 0;
				for (int i = 0; i < columnCount; i++) {
					TableColumn tableColumn = new TableColumn(table, SWT.NONE);
					tableColumn.setWidth(100);
					tableColumn.setText(rsmd.getColumnName(i + 1));
				}

				while (rs.next()) {
					String[] tableItem = new String[columnCount + 1];
					tableItem[0] = "" + index;
					for (int i = 1; i <= columnCount; i++) {
						tableItem[i] = rs.getString(i);
					}
					new TableItem(table, SWT.NONE).setText(tableItem);
					index++;
				}
			} catch (SQLException e1) {
				MsgBox.error(shell, "数据库查询失败：\n" + e1.toString());
			}
			toolItemCut.setEnabled(true);
			toolItemExe.setEnabled(true);
		} else {
			shell.setText("IDS 数据库管理器 - 无连接");
			toolItemCut.setEnabled(false);
			toolItemExe.setEnabled(false);
		}

		toolItemAbout.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				MsgBox.information(shell, "入侵检测实验系统（Version 1.0）\n  数据库管理器"
						+ "\n\n中山大学 网络工程05级 张广" + "\nzhguang@mail2.sysu.edu.cn"
						+ "\n2009年3月23日");
			}
		});

		toolItemNew.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				if (isConnected) {
					int sel = MsgBox.OKCancel(shell, "要建立新的连接，必须断开当前数据库连接。"
							+ "\n要断开吗?点击“确定”断开");
					if (sel == SWT.OK) {
						isConnected = false;
						shell.setText("IDS 数据库管理器 - 无连接");
						toolItemCut.setEnabled(false);
						toolItemExe.setEnabled(false);
						try {
							db.closeConnection();
						} catch (SQLException e1) {
						}

					} else {
						return;
					}
				}

				DBConnectDlg dbDlg = new DBConnectDlg(shell, db.url,
						db.driverName, db.username, db.password);
				if (!dbDlg.open()) {
					return;
				}
				db.url = dbDlg.getURL();
				db.driverName = dbDlg.getDriverName();
				db.username = dbDlg.getUserName();
				db.password = dbDlg.getPassword();

				try {
					db.connect();
					isConnected = true;

					// 下面解析URL：
					String IP;
					String Port;
					String DBName;

					if (db.url.startsWith("jdbc:sqlserver://")) {
						// "jdbc:sqlserver://localhost:1433;DatabaseName=IDS"
						int idxIP = db.url.indexOf("//") + 2;
						int idxPort = db.url.indexOf(":", idxIP) + 1;
						IP = db.url.substring(idxIP, idxPort - 1);
						Port = db.url.substring(idxPort, db.url.indexOf(";",
								idxPort));
						DBName = db.url
								.substring(db.url.indexOf("=", idxPort) + 1);
						shell.setText("IDS 数据库管理器 - " + IP + ":" + Port + " / "
								+ DBName + ":" + db.username+" / AlertInfo");
					} else {
						// "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=IDS"
						int idxIP = db.url.indexOf("//") + 2;
						int idxPort = db.url.indexOf(":", idxIP) + 1;
						IP = db.url.substring(idxIP, idxPort - 1);
						Port = db.url.substring(idxPort, db.url.indexOf(";",
								idxPort));
						DBName = db.url
								.substring(db.url.indexOf("=", idxPort) + 1);
						shell.setText("IDS 数据库管理器 - " + IP + ":" + Port + " / "
								+ DBName + ":" + db.username+" / AlertInfo");
					}

				} catch (Exception e1) {
					MsgBox.error(shell, "数据库连接失败：\n" + e1.toString());
					return;
				}
				// 下面从数据库读入数据

				try {
					ResultSet rs;

					rs = db.getAll();
					ResultSetMetaData rsmd = rs.getMetaData();
					table.removeAll();
					while (table.getColumns().length > 0) {
						table.getColumn(0).dispose();
					}
					textDBInfo.setText("成功");

					int columnCount = rsmd.getColumnCount();
					TableColumn tableColumn0 = new TableColumn(table, SWT.NONE);
					tableColumn0.setWidth(50);
					tableColumn0.setText("index");
					int index = 0;
					for (int i = 0; i < columnCount; i++) {
						TableColumn tableColumn = new TableColumn(table,
								SWT.NONE);
						tableColumn.setWidth(100);
						tableColumn.setText(rsmd.getColumnName(i + 1));
					}

					while (rs.next()) {
						String[] tableItem = new String[columnCount + 1];
						tableItem[0] = "" + index;
						for (int i = 1; i <= columnCount; i++) {
							tableItem[i] = rs.getString(i);
						}
						new TableItem(table, SWT.NONE).setText(tableItem);
						index++;
					}
				} catch (SQLException e1) {
					MsgBox.error(shell, "数据库查询失败：\n" + e1.toString());
				}
				toolItemCut.setEnabled(true);
				toolItemExe.setEnabled(true);
			}
		});

		toolItemCut.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				isConnected = false;
				shell.setText("IDS 数据库管理器 - 无连接");
				try {
					db.closeConnection();
				} catch (SQLException e1) {
				}
				toolItemCut.setEnabled(false);
				toolItemExe.setEnabled(false);
			}
		});

		toolItemExe.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				try {
					db.stmt = db.conn.createStatement();

					String sql = textEditQuery.getText();
					ResultSetMetaData rsmd = null;
					if (sql.toLowerCase().startsWith("select")) {
						db.rs = db.stmt.executeQuery(sql);
						rsmd = db.rs.getMetaData();

					} else if (sql.toLowerCase().startsWith("insert")
							|| sql.toLowerCase().startsWith("update")
							|| sql.toLowerCase().startsWith("delete")) {
						db.stmt.execute(sql);
						db.rs = db.getAll();
						rsmd = db.rs.getMetaData();
					} else {
						textDBInfo.setText("查询失败：\n查询语句第一个字错误，或用户"
								+ db.username + "不具备该权限");
						return;
					}

					table.removeAll();
					while (table.getColumns().length > 0) {
						table.getColumn(0).dispose();
					}
					textDBInfo.setText("成功");

					int columnCount = rsmd.getColumnCount();
					TableColumn tableColumn0 = new TableColumn(table, SWT.NONE);
					tableColumn0.setWidth(50);
					tableColumn0.setText("index");
					int index = 0;
					for (int i = 0; i < columnCount; i++) {
						TableColumn tableColumn = new TableColumn(table,
								SWT.NONE);
						tableColumn.setWidth(100);
						tableColumn.setText(rsmd.getColumnName(i + 1));
					}

					while (db.rs.next()) {
						String[] tableItem = new String[columnCount + 1];
						tableItem[0] = "" + index;
						for (int i = 1; i <= columnCount; i++) {
							tableItem[i] = db.rs.getString(i);
						}
						new TableItem(table, SWT.NONE).setText(tableItem);
						index++;
					}
					db.stmt.close();
				} catch (SQLException e1) {
					textDBInfo.setText("查询失败：\n" + e1.toString());
				}
			}
		});

		//
	}

}
