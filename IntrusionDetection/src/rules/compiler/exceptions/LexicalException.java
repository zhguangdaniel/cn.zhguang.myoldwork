package rules.compiler.exceptions;

/**
 * 词法异常
 * @author 张广
 *
 */
public class LexicalException extends ExpressionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认词法异常
	 *
	 */
	public LexicalException() {
		this("词法错误");
	}

	/**
	 * 根据参数s构造异常
	 * @param s
	 */
	public LexicalException(String s) {
		super(s);
	}
}
