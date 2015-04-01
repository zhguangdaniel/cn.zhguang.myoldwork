package rules.compiler.exceptions;

/**
 * 表达式异常
 * @author 张广
 *
 */
public class ExpressionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认异常
	 *
	 */
	public ExpressionException() {
		this("表达式中存在错误");
	}

	/**
	 * 根据参数s构造异常
	 * @param s
	 */
	public ExpressionException(String s) {
		super(s);
	}
}
