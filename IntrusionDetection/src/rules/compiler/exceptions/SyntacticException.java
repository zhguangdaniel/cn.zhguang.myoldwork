package rules.compiler.exceptions;

/**
 * �﷨�쳣
 * @author �Ź�
 *
 */
public class SyntacticException extends ExpressionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ĭ���﷨�쳣
	 *
	 */
	public SyntacticException() {
		this("�﷨����");
	}

	/**
	 * ���ݲ���s�����쳣
	 * @param s
	 */
	public SyntacticException(String s) {
		super(s);
	}
}
