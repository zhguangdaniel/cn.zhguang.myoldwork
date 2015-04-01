package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * 显示MessageBox
 * @author 张广
 *
 */
public class MsgBox {
	
	/**
	 * 显示含一个确定按钮的警告框
	 * @param shell 对话框的母shell窗体
	 * @param message 要显示的警告消息
	 */
	public static void warning(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK); 
		msgWarning.setText("警告"); 
		msgWarning.setMessage(message);
		msgWarning.open();
	}
	
	/**
	 * 显示含一个确定按钮的信息提示框
	 * @param shell 对话框的母shell窗体
	 * @param message 要显示的信息
	 */
	public static void information(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK); 
		msgWarning.setText("信息"); 
		msgWarning.setMessage(message);
		msgWarning.open();
	}
	
	/**
	 * 显示含一个确定按钮的错误框
	 * @param shell 对话框的母shell窗体
	 * @param message 要显示的错误消息
	 */
	public static void error(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK); 
		msgWarning.setText("错误"); 
		msgWarning.setMessage(message);
		msgWarning.open();
	}
	
	/**
	 * 显示含一个 确定/取消 按钮的确认框
	 * @param shell 对话框的母shell窗体
	 * @param message 要显示的确认信息
	 * @return SWT.OK:确定 / SWT.CANCEL:取消
	 */
	public static int OKCancel(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL); 
		msgWarning.setText("确认"); 
		msgWarning.setMessage(message);
		return msgWarning.open();
	}
	
	/**
	 * 显示含一个 是/否 按钮的选择框
	 * @param shell 对话框的母shell窗体
	 * @param message 要显示的选择信息
	 * @return SWT.YES:是 / SWT.NO:否
	 */
	public static int YesNo(Shell shell, String message){
		MessageBox msgWarning = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO); 
		msgWarning.setText("选择"); 
		msgWarning.setMessage(message);
		return msgWarning.open();
	}
}
