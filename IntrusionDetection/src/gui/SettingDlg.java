package gui;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import gui.MsgBox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 设置各种监听属性的监听对话框
 * 
 * @author 张广
 * 
 */
public class SettingDlg extends Dialog {

	private Text text_1;

	private Combo combo;

	private boolean isProm;

	private int index = 0;

	private int selectDev;

	private int maxPackLen;

	protected Shell shell;

	/**
	 * 构造设置对话框
	 * 
	 * @param parent
	 * @param style
	 * @param selectDev
	 * @param maxPackLen
	 * @param isProm
	 *            是否设置混杂模式
	 */
	public SettingDlg(Shell parent, int style, int selectDev, int maxPackLen,
			boolean isProm) {
		super(parent, style);
		this.isProm = isProm;
		this.maxPackLen = maxPackLen;
		this.selectDev = selectDev;
	}

	/**
	 * 是否使用混杂模式
	 * 
	 * @return true:混战模式
	 */
	public boolean getIsPromiscuous() {
		return isProm;
	}

	/**
	 * 每次捕获的包的大小
	 * 
	 * @return 包的大小
	 */
	public int getMaxPacketLen() {
		return maxPackLen;
	}

	/**
	 * 选择要监听的设备
	 * 
	 * @return 设备在JpcapCaptor.getDeviceList()所得到的list中的序号
	 */
	public int getSelectDev() {
		return selectDev;
	}

	/**
	 * Open the dialog
	 */
	public void open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * Create contents of the dialog
	 */
	protected void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		shell.setLayout(gridLayout);
		shell.setSize(540, 175);
		shell.setText("设置");

		final Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));
		composite.setLayout(new GridLayout());

		final Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		label.setText("选择网卡：");

		combo = new Combo(composite, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		NetworkInterface[] devices = JpcapCaptor.getDeviceList();
		if (devices.length > 1)
			index = 1;
		String[] netCard = new String[devices.length - index];
		for (int i = 0; i < devices.length - index; i++) {
			netCard[i] = String.valueOf(index + i) + ", "
					+ devices[index + i].description;
		}
		combo.setItems(netCard);
		combo.select(selectDev - index);

		final Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		composite_1.setLayout(new GridLayout());

		final Label label_5 = new Label(composite_1, SWT.NONE);
		label_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label_5.setText("包大小限制：");

		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setToolTipText("每次捕获的包的大小");
		final GridData gd_text_1 = new GridData(91, SWT.DEFAULT);
		text_1.setLayoutData(gd_text_1);
		text_1.setText(String.valueOf(maxPackLen));

		final Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		composite_2.setLayout(new GridLayout());

		final Button button = new Button(composite_2, SWT.RADIO);
		button.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		button.setText("混杂模式");
		button.setToolTipText("设置为混杂模式");
		button.setSelection(isProm);

		final Button button_1 = new Button(composite_2, SWT.RADIO);
		button_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		button_1.setText("非混杂模式");
		button_1.setSelection(!isProm);
		button_1.setToolTipText("设置为非混杂模式");

		final Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				if (!text_1.getText().matches("[0-9]+")) {
					MsgBox.warning(shell, "包的长度不能为空，且必须是整数");
					return;
				}
				selectDev = combo.getSelectionIndex() + index;
				isProm = button.getSelection();
				maxPackLen = Integer.parseInt(text_1.getText());
				shell.close();
			}
		});
		button_3
				.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		button_3.setText("确定");

		final Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				shell.close();
			}
		});
		button_2.setText("取消");
		//
	}

}
