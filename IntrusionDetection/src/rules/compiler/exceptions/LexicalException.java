package rules.compiler.exceptions;

/**
 * �ʷ��쳣
 * @author �Ź�
 *
 */
public class LexicalException extends ExpressionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ĭ�ϴʷ��쳣
	 *
	 */
	public LexicalException() {
		this("�ʷ�����");
	}

	/**
	 * ���ݲ���s�����쳣
	 * @param s
	 */
	public LexicalException(String s) {
		super(s);
	}
}
