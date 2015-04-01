package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import rules.Rule;
import rules.compiler.Compiler;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * 规则管理器
 * 
 * @author 张广
 * 
 */
public class RulesDlg {

	protected Shell shell;

	private String currentPath = null;

	private int modifyIndex;

	private LinkedList<Rule> rulesList = new LinkedList<Rule>();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RulesDlg window = new RulesDlg();
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
		shell.setSize(600, 400);
		final GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);
		shell.setText("IDS 规则管理器");
		Image image = new Image(display, "icons/Rules.png");
		shell.setImage(image);// 设置窗体标题图标

		final ToolBar toolBar = new ToolBar(shell, SWT.NONE);
		toolBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final ToolItem toolItemNew = new ToolItem(toolBar, SWT.PUSH);
		toolItemNew.setText("新建");
		toolItemNew.setToolTipText("新建规则文件");
		toolItemNew.setImage(new Image(display, "icons/NewDoc.png"));

		final ToolItem toolItemOpen = new ToolItem(toolBar, SWT.PUSH);
		toolItemOpen.setText("打开");
		toolItemOpen.setToolTipText("打开规则文件");
		toolItemOpen.setImage(new Image(display, "icons/Open.png"));

		final ToolItem toolItemSave = new ToolItem(toolBar, SWT.PUSH);
		toolItemSave.setText("保存");
		toolItemSave.setToolTipText("保存规则文件");
		toolItemSave.setImage(new Image(display, "icons/Save.png"));
		toolItemSave.setEnabled(false);

		final ToolItem toolItemSaveAs = new ToolItem(toolBar, SWT.PUSH);
		toolItemSaveAs.setText("另存为");
		toolItemSaveAs.setToolTipText("另存为规则文件");
		toolItemSaveAs.setImage(new Image(display, "icons/SaveAs.png"));

		ToolItem toolItemSptr_1 = new ToolItem(toolBar, SWT.SEPARATOR);
		Label label_1 = new Label(toolBar, SWT.CENTER | SWT.SEPARATOR);
		toolItemSptr_1.setControl(label_1);

		final ToolItem toolItemAddRule = new ToolItem(toolBar, SWT.PUSH);
		toolItemAddRule.setText("添加规则");
		toolItemAddRule.setImage(new Image(display, "icons/Add.png"));

		final ToolItem toolItemCompileRule = new ToolItem(toolBar, SWT.PUSH);
		toolItemCompileRule.setText("编译规则");
		toolItemCompileRule.setToolTipText("检查规则合法性");
		toolItemCompileRule.setImage(new Image(display, "icons/Compile.png"));

		final ToolItem toolItemModifyRule = new ToolItem(toolBar, SWT.PUSH);
		toolItemModifyRule.setText("修改规则");
		toolItemModifyRule.setImage(new Image(display, "icons/Modify.png"));

		final ToolItem toolItemRemoveRule = new ToolItem(toolBar, SWT.PUSH);
		toolItemRemoveRule.setText("移除规则");
		toolItemRemoveRule.setImage(new Image(display, "icons/Remove.png"));

		ToolItem toolItemSptr_3 = new ToolItem(toolBar, SWT.SEPARATOR);
		Label label_3 = new Label(toolBar, SWT.SEPARATOR);
		toolItemSptr_3.setControl(label_3);

		final ToolItem toolItemAbout = new ToolItem(toolBar, SWT.PUSH);
		toolItemAbout.setText("关于");
		toolItemAbout.setToolTipText("关于规则管理器");
		toolItemAbout.setImage(new Image(display, "icons/Help.png"));

		final ToolItem toolItemSeparator = new ToolItem(toolBar, SWT.SEPARATOR);
		toolItemSeparator.setWidth(50);

		final ToolItem newItemToolItem = new ToolItem(toolBar, SWT.SEPARATOR);
		newItemToolItem.setWidth(100);
		final Button checkAll = new Button(toolBar, SWT.CHECK);
		checkAll.setText("全选");
		newItemToolItem.setControl(checkAll);

		final SashForm sashForm_1 = new SashForm(shell, SWT.VERTICAL);
		final GridLayout gd = new GridLayout();
		gd.marginHeight = 0;
		gd.marginWidth = 0;
		gd.horizontalSpacing = 0;
		gd.verticalSpacing = 0;
		sashForm_1.setLayout(gd);
		sashForm_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Table table;
		table = new Table(sashForm_1, SWT.FULL_SELECTION | SWT.CHECK
				| SWT.BORDER);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn tableColumn0 = new TableColumn(table, SWT.NONE);
		tableColumn0.setWidth(50);
		tableColumn0.setText("序号");

		final TableColumn tableColumn1 = new TableColumn(table, SWT.CENTER);
		tableColumn1.setWidth(50);
		tableColumn1.setText("操作");

		final TableColumn tableColumn2 = new TableColumn(table, SWT.CENTER);
		tableColumn2.setWidth(70);
		tableColumn2.setText("协议");

		final TableColumn tableColumn3 = new TableColumn(table, SWT.CENTER);
		tableColumn3.setWidth(100);
		tableColumn3.setText("IP 1");

		final TableColumn tableColumn4 = new TableColumn(table, SWT.NONE);
		tableColumn4.setWidth(55);
		tableColumn4.setText("端口1");

		final TableColumn tableColumn5 = new TableColumn(table, SWT.CENTER);
		tableColumn5.setWidth(45);
		tableColumn5.setText("流向");

		final TableColumn tableColumn6 = new TableColumn(table, SWT.CENTER);
		tableColumn6.setWidth(100);
		tableColumn6.setText("IP 2");

		final TableColumn tableColumn7 = new TableColumn(table, SWT.NONE);
		tableColumn7.setWidth(55);
		tableColumn7.setText("端口 2");

		final TableColumn tableColumn8 = new TableColumn(table, SWT.NONE);
		tableColumn8.setWidth(230);
		tableColumn8.setText("选项");

		final TableColumn tableColumn9 = new TableColumn(table, SWT.NONE);
		tableColumn9.setWidth(150);
		tableColumn9.setText("消息");

		final SashForm sashForm_2 = new SashForm(sashForm_1, SWT.NONE);

		final Text textEditRule = new Text(sashForm_2, SWT.WRAP | SWT.V_SCROLL
				| SWT.MULTI | SWT.BORDER);

		final Text textCompInfo = new Text(sashForm_2, SWT.WRAP | SWT.V_SCROLL
				| SWT.READ_ONLY | SWT.MULTI | SWT.BORDER);
		textCompInfo.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		textCompInfo.setForeground(display.getSystemColor(SWT.COLOR_RED));
		textCompInfo.setText("请在左边编辑框内编辑规则...");
		sashForm_1.setWeights(new int[] { 5, 2 });

		sashForm_2.setWeights(new int[] { 5, 2 });

		toolItemAbout.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				MsgBox.information(shell, "入侵检测实验系统（Version 1.0）\n  规则管理器"
						+ "\n\n中山大学 网络工程05级 张广" + "\nzhguang@mail2.sysu.edu.cn"
						+ "\n2009年2月26日");
			}
		});

		toolItemNew.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				shell.setText("IDS 规则管理器 - 新rules文件...");
				rulesList.clear();
				table.removeAll();
				currentPath = null;
			}
		});
		toolItemOpen.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				if (toolItemSave.getEnabled())
					if (SWT.OK == MsgBox.OKCancel(shell, "当前的rule文件尚未保存，是否保存？")) {
						String paths = null;
						if (currentPath == null) {
							FileDialog dlgs = new FileDialog(shell, SWT.SAVE);
							if (!(new File(".\\data\\rules")).isDirectory()) {
								(new File(".\\data\\rules")).mkdirs();
							}
							dlgs.setText("保存规则文件");
							dlgs.setFilterExtensions(new String[] { "*.rule" });
							dlgs.setFilterPath(".\\data\\rules");
							paths = dlgs.open();
							if (paths == null)
								return;
						} else {
							paths = currentPath;
						}

						try {
							FileWriter filewriter = new FileWriter(paths);
							for (int i = 0; i < rulesList.size(); i++) {
								filewriter.write(rulesList.get(i)
										.getStringRule()
										+ "\n");
							}
							filewriter.close();
						} catch (IOException ioE) {
							MsgBox.error(shell, "写入文件失败：" + ioE.toString());
							return;
						}
						toolItemSave.setEnabled(false);
						MsgBox.information(shell, "已保存");
					}

				FileDialog dlg = new FileDialog(shell, SWT.OPEN);
				if (!(new File(".\\data\\rules")).isDirectory()) {
					(new File(".\\data\\rules")).mkdirs();
				}
				dlg.setText("打开规则文件");
				dlg.setFilterExtensions(new String[] { "*.rule" });
				dlg.setFilterPath(".\\data\\rules");
				String path = dlg.open();
				if (path == null)
					return;
				rulesList.clear();
				table.removeAll();
				try {
					Compiler c = new Compiler();
					String msg;
					FileReader fileReader = new FileReader(path);
					BufferedReader reader = new BufferedReader(fileReader);
					String line = null;
					int index = 0;
					while ((line = reader.readLine()) != null) {
						msg = c.compile(line);
						if (msg.equals("编译成功")) {
							rulesList.add(c.getRule());
							String[] tableItem = new String[10];
							tableItem[0] = String.valueOf(index++);
							tableItem[1] = c.getRule().getAction();
							tableItem[2] = c.getRule().getProtocol();
							tableItem[3] = c.getRule().getIP1();
							tableItem[4] = c.getRule().getPort1();
							tableItem[5] = c.getRule().packetDirection;
							tableItem[6] = c.getRule().getIP2();
							tableItem[7] = c.getRule().getPort2();
							tableItem[8] = c.getRule().getOptionList();
							tableItem[9] = c.getRule().msg;
							new TableItem(table, SWT.NONE).setText(tableItem);
						} else {
							textEditRule.setText(line);
							textCompInfo.setText("编译左边框中规则时出错：\n" + msg);
							return;
						}
					}
					currentPath = path;
					shell.setText("IDS 规则管理器 - " + dlg.getFileName());
					fileReader.close();
				} catch (IOException ioE) {
					MsgBox.error(shell, "读取文件失败：\n" + ioE.toString());
					return;
				}
			}
		});

		toolItemSave.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				String path = null;
				if (currentPath == null) {
					FileDialog dlg = new FileDialog(shell, SWT.SAVE);
					if (!(new File(".\\data\\rules")).isDirectory()) {
						(new File(".\\data\\rules")).mkdirs();
					}
					dlg.setText("保存规则文件");
					dlg.setFilterExtensions(new String[] { "*.rule" });
					dlg.setFilterPath(".\\data\\rules");
					path = dlg.open();
					if (path == null)
						return;
				} else {
					path = currentPath;
				}

				try {
					FileWriter filewriter = new FileWriter(path);
					for (int i = 0; i < rulesList.size(); i++) {
						filewriter.write(rulesList.get(i).getStringRule()
								+ "\n");
					}
					filewriter.close();
				} catch (IOException ioE) {
					MsgBox.error(shell, "写入文件失败：" + ioE.toString());
					return;
				}

				toolItemSave.setEnabled(false);
			}
		});
		toolItemSaveAs.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {

				FileDialog dlg = new FileDialog(shell, SWT.SAVE);
				if (!(new File(".\\data\\rules")).isDirectory()) {
					(new File(".\\data\\rules")).mkdirs();
				}
				dlg.setText("另存为规则文件");
				dlg.setFilterExtensions(new String[] { "*.rule" });
				dlg.setFilterPath(".\\data\\rules");
				String path = dlg.open();
				if (path == null)
					return;

				try {
					FileWriter filewriter = new FileWriter(path);
					for (int i = 0; i < rulesList.size(); i++) {
						filewriter.write(rulesList.get(i).getStringRule()
								+ "\n");
					}
					filewriter.close();
				} catch (IOException ioE) {
					MsgBox.error(shell, "写入文件失败：" + ioE.toString());
					return;
				}

				currentPath = path;
				shell.setText("IDS 规则管理器 - " + dlg.getFileName());
			}
		});
		toolItemAddRule.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				Compiler c = new Compiler();
				String msg = c.compile(textEditRule.getText());
				textCompInfo.setText(msg);
				if (msg.equals("编译成功")) {
					rulesList.add(c.getRule());
					String[] tableItem = new String[10];
					tableItem[0] = String.valueOf(table.getItemCount());
					tableItem[1] = c.getRule().getAction();
					tableItem[2] = c.getRule().getProtocol();
					tableItem[3] = c.getRule().getIP1();
					tableItem[4] = c.getRule().getPort1();
					tableItem[5] = c.getRule().packetDirection;
					tableItem[6] = c.getRule().getIP2();
					tableItem[7] = c.getRule().getPort2();
					tableItem[8] = c.getRule().getOptionList();
					tableItem[9] = c.getRule().msg;
					new TableItem(table, SWT.NONE).setText(tableItem);
					toolItemSave.setEnabled(true);
				}
			}
		});
		toolItemCompileRule.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				Compiler c = new Compiler();
				String msg = c.compile(textEditRule.getText());
				textCompInfo.setText(msg);
			}
		});
		toolItemModifyRule.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				if (toolItemModifyRule.getText().equals("修改规则")) {
					int checkedCount = 0;
					for (int i = 0; i < table.getItemCount(); i++) {
						if (table.getItem(i).getChecked()) {
							checkedCount++;
							modifyIndex = i;
						}
					}
					if (checkedCount == 0)
						MsgBox.information(shell, "请先勾选你要修改的规则");
					else if (checkedCount > 1)
						MsgBox.information(shell, "每次只能修改一个规则，请不要勾选多个");
					else {
						textCompInfo.setText("请在左边框内修改");
						textEditRule.setText(rulesList.get(modifyIndex)
								.getStringRule());
						textEditRule.selectAll();
						toolItemModifyRule.setText("确认修改");
						table.setEnabled(false);
						toolItemRemoveRule.setEnabled(false);
						toolItemAddRule.setEnabled(false);
						toolItemCompileRule.setEnabled(false);
						checkAll.setEnabled(false);
						toolItemNew.setEnabled(false);
						toolItemOpen.setEnabled(false);
						toolItemSave.setEnabled(false);
					}
				} else {
					Compiler c = new Compiler();
					String msg = c.compile(textEditRule.getText());
					textCompInfo.setText(msg);
					if (msg.equals("编译成功")) {
						rulesList.remove(modifyIndex);
						rulesList.add(modifyIndex, c.getRule());
						String[] tableItem = new String[10];
						tableItem[0] = String.valueOf(modifyIndex);
						tableItem[1] = c.getRule().getAction();
						tableItem[2] = c.getRule().getProtocol();
						tableItem[3] = c.getRule().getIP1();
						tableItem[4] = c.getRule().getPort1();
						tableItem[5] = c.getRule().packetDirection;
						tableItem[6] = c.getRule().getIP2();
						tableItem[7] = c.getRule().getPort2();
						tableItem[8] = c.getRule().getOptionList();
						tableItem[9] = c.getRule().msg;
						table.getItem(modifyIndex).setText(tableItem);
						textCompInfo.setText("修改成功");
						toolItemModifyRule.setText("修改规则");
						table.setEnabled(true);
						toolItemRemoveRule.setEnabled(true);
						toolItemAddRule.setEnabled(true);
						toolItemCompileRule.setEnabled(true);
						checkAll.setEnabled(true);
						toolItemNew.setEnabled(true);
						toolItemOpen.setEnabled(true);
						toolItemSave.setEnabled(true);
					}
				}
			}
		});
		toolItemRemoveRule.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				int checkedCount = 0;
				for (int i = 0; i < table.getItemCount(); i++) {
					if (table.getItem(i).getChecked()) {
						checkedCount++;
					}
				}
				if (checkedCount == 0)
					MsgBox.information(shell, "请先勾选你要移除的规则");
				else {
					if (SWT.OK == MsgBox.OKCancel(shell, "你确定要移除勾选的这些规则吗？")) {
						for (int i = 0; i < rulesList.size(); i++) {
							if (table.getItem(i).getChecked()) {
								table.remove(i);
								rulesList.remove(i);
								i--;
							}
						}
						toolItemSave.setEnabled(true);
					}
				}
			}
		});
		table.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				if (table.getSelectionIndex() < 0)
					return;
				textEditRule.setText(rulesList.get(table.getSelectionIndex())
						.getStringRule());
				textCompInfo.setText("");
			}
		});
		checkAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				if (checkAll.getSelection())
					for (int i = 0; i < table.getItemCount(); i++)
						table.getItem(i).setChecked(true);
				else
					for (int i = 0; i < table.getItemCount(); i++)
						table.getItem(i).setChecked(false);
			}
		});
		shell.addShellListener(new ShellAdapter() {
			public void shellClosed(final ShellEvent e) {
				if (toolItemSave.getEnabled())
					if (SWT.OK == MsgBox.OKCancel(shell, "当前的rule文件尚未保存，是否保存？")) {
						String path = null;
						if (currentPath == null) {
							FileDialog dlg = new FileDialog(shell, SWT.SAVE);
							if (!(new File(".\\data\\rules")).isDirectory()) {
								(new File(".\\data\\rules")).mkdirs();
							}
							dlg.setText("保存规则文件");
							dlg.setFilterExtensions(new String[] { "*.rule" });
							dlg.setFilterPath(".\\data\\rules");
							path = dlg.open();
							if (path == null)
								return;
						} else {
							path = currentPath;
						}

						try {
							FileWriter filewriter = new FileWriter(path);
							for (int i = 0; i < rulesList.size(); i++) {
								filewriter.write(rulesList.get(i)
										.getStringRule()
										+ "\n");
							}
							filewriter.close();
						} catch (IOException ioE) {
							MsgBox.error(shell, "写入文件失败：" + ioE.toString());
							return;
						}
					}
			}
		});

	}
}
