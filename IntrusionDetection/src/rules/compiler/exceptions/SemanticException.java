package rules.compiler.exceptions;

/**
 * �����쳣
 * @author �Ź�
 *
 */
public class SemanticException extends ExpressionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ĭ�������쳣
	 *
	 */
	public SemanticException() {
		this("�������");
	}

	/**
	 * ���ݲ���s�����쳣
	 * @param s
	 */
	public SemanticException(String s) {
		super(s);
	}
}
