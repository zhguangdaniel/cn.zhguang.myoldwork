package rules.compiler.exceptions;

/**
 * �ձ��ʽ�쳣
 * @author �Ź�
 *
 */
public class EmptyExpressionException extends ExpressionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����Ĭ���쳣
	 *
	 */
	public EmptyExpressionException() {
		this("���ʽΪ��");
	}

	/**
	 * ���ݲ���s�����쳣
	 * @param s
	 */
	public EmptyExpressionException(String s) {
		super(s);
	}
}
