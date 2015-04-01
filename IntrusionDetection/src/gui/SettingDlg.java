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
 * ���ø��ּ������Եļ����Ի���
 * 
 * @author �Ź�
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
	 * �������öԻ���
	 * 
	 * @param parent
	 * @param style
	 * @param selectDev
	 * @param maxPackLen
	 * @param isProm
	 *            �Ƿ����û���ģʽ
	 */
	public SettingDlg(Shell parent, int style, int selectDev, int maxPackLen,
			boolean isProm) {
		super(parent, style);
		this.isProm = isProm;
		this.maxPackLen = maxPackLen;
		this.selectDev = selectDev;
	}

	/**
	 * �Ƿ�ʹ�û���ģʽ
	 * 
	 * @return true:��սģʽ
	 */
	public boolean getIsPromiscuous() {
		return isProm;
	}

	/**
	 * ÿ�β���İ��Ĵ�С
	 * 
	 * @return ���Ĵ�С
	 */
	public int getMaxPacketLen() {
		return maxPackLen;
	}

	/**
	 * ѡ��Ҫ�������豸
	 * 
	 * @return �豸��JpcapCaptor.getDeviceList()���õ���list�е����
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
		shell.setText("����");

		final Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));
		composite.setLayout(new GridLayout());

		final Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		label.setText("ѡ��������");

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
		label_5.setText("����С���ƣ�");

		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setToolTipText("ÿ�β���İ��Ĵ�С");
		final GridData gd_text_1 = new GridData(91, SWT.DEFAULT);
		text_1.setLayoutData(gd_text_1);
		text_1.setText(String.valueOf(maxPackLen));

		final Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		composite_2.setLayout(new GridLayout());

		final Button button = new Button(composite_2, SWT.RADIO);
		button.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		button.setText("����ģʽ");
		button.setToolTipText("����Ϊ����ģʽ");
		button.setSelection(isProm);

		final Button button_1 = new Button(composite_2, SWT.RADIO);
		button_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		button_1.setText("�ǻ���ģʽ");
		button_1.setSelection(!isProm);
		button_1.setToolTipText("����Ϊ�ǻ���ģʽ");

		final Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				if (!text_1.getText().matches("[0-9]+")) {
					MsgBox.warning(shell, "���ĳ��Ȳ���Ϊ�գ��ұ���������");
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
		button_3.setText("ȷ��");

		final Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				shell.close();
			}
		});
		button_2.setText("ȡ��");
		//
	}

}
