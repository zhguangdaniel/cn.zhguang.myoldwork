package rules.compiler.exceptions;

/**
 * ���ʽ�쳣
 * @author �Ź�
 *
 */
public class ExpressionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ĭ���쳣
	 *
	 */
	public ExpressionException() {
		this("���ʽ�д��ڴ���");
	}

	/**
	 * ���ݲ���s�����쳣
	 * @param s
	 */
	public ExpressionException(String s) {
		super(s);
	}
}
