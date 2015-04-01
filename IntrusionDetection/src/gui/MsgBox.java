package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * ��ʾMessageBox
 * @author �Ź�
 *
 */
public class MsgBox {
	
	/**
	 * ��ʾ��һ��ȷ����ť�ľ����
	 * @param shell �Ի����ĸshell����
	 * @param message Ҫ��ʾ�ľ�����Ϣ
	 */
	public static void warning(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK); 
		msgWarning.setText("����"); 
		msgWarning.setMessage(message);
		msgWarning.open();
	}
	
	/**
	 * ��ʾ��һ��ȷ����ť����Ϣ��ʾ��
	 * @param shell �Ի����ĸshell����
	 * @param message Ҫ��ʾ����Ϣ
	 */
	public static void information(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK); 
		msgWarning.setText("��Ϣ"); 
		msgWarning.setMessage(message);
		msgWarning.open();
	}
	
	/**
	 * ��ʾ��һ��ȷ����ť�Ĵ����
	 * @param shell �Ի����ĸshell����
	 * @param message Ҫ��ʾ�Ĵ�����Ϣ
	 */
	public static void error(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK); 
		msgWarning.setText("����"); 
		msgWarning.setMessage(message);
		msgWarning.open();
	}
	
	/**
	 * ��ʾ��һ�� ȷ��/ȡ�� ��ť��ȷ�Ͽ�
	 * @param shell �Ի����ĸshell����
	 * @param message Ҫ��ʾ��ȷ����Ϣ
	 * @return SWT.OK:ȷ�� / SWT.CANCEL:ȡ��
	 */
	public static int OKCancel(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL); 
		msgWarning.setText("ȷ��"); 
		msgWarning.setMessage(message);
		return msgWarning.open();
	}
	
	/**
	 * ��ʾ��һ�� ��/�� ��ť��ѡ���
	 * @param shell �Ի����ĸshell����
	 * @param message Ҫ��ʾ��ѡ����Ϣ
	 * @return SWT.YES:�� / SWT.NO:��
	 */
	public static int YesNo(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO); 
		msgWarning.setText("ѡ��"); 
		msgWarning.setMessage(message);
		return msgWarning.open();
	}
}
