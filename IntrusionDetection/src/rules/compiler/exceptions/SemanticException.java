package rules.compiler.exceptions;

/**
 * 语义异常
 * @author 张广
 *
 */
public class SemanticException extends ExpressionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认语义异常
	 *
	 */
	public SemanticException() {
		this("语义错误");
	}

	/**
	 * 根据参数s构造异常
	 * @param s
	 */
	public SemanticException(String s) {
		super(s);
	}
}
