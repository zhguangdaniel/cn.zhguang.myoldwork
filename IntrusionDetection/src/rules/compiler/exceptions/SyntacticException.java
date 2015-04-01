package rules.compiler.exceptions;

/**
 * 语法异常
 * @author 张广
 *
 */
public class SyntacticException extends ExpressionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认语法异常
	 *
	 */
	public SyntacticException() {
		this("语法错误");
	}

	/**
	 * 根据参数s构造异常
	 * @param s
	 */
	public SyntacticException(String s) {
		super(s);
	}
}
