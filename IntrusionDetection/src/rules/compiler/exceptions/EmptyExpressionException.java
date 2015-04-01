package rules.compiler.exceptions;

/**
 * 空表达式异常
 * @author 张广
 *
 */
public class EmptyExpressionException extends ExpressionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造默认异常
	 *
	 */
	public EmptyExpressionException() {
		this("表达式为空");
	}

	/**
	 * 根据参数s构造异常
	 * @param s
	 */
	public EmptyExpressionException(String s) {
		super(s);
	}
}
