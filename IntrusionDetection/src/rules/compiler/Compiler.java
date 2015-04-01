package rules.compiler;

import java.io.*;
import java.util.LinkedList;

import rules.compiler.LexicalAnalyzer;
import rules.compiler.SyntaxAnalyzer;
import rules.compiler.exceptions.*;
import rules.Rule;

/**
 * 编译器，用来编译规则
 * 
 * @author 张广
 * 
 */
public class Compiler {
	private Rule rule = null;

	/**
	 * 编译一个规则表达式，并将形成的规则保存在rule中
	 * 
	 * @param expression
	 *            所要编译的规则表达式
	 * @return 编译成功返回“编译成功”，否则返回抛出的异常。
	 */
	public String compile(String expression) {
		LexicalAnalyzer lex = new LexicalAnalyzer();
		try {
			LinkedList<String> list = lex.analysis(expression);
			SyntaxAnalyzer syn = new SyntaxAnalyzer();
			syn.analysis(list);
			rule = syn.getRule();
			return "编译成功";
		} catch (ExpressionException e) {
			return e.getMessage();
		}
	}

	/**
	 * 获得语法分析后的Rule（必须在调用了analysis函数之后使用）
	 * 
	 * @return rule 语法分析后形成的rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * 读入字符串函数
	 * 
	 * @return buffer :输入成功 / null :输入失败
	 */
	public String StringIn() {
		String buffer;
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			buffer = input.readLine();
			return buffer;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// public static void main(String[] args) {
	// Compiler c = new Compiler();
	// String msg;
	// try {
	// String pathread = ".\\testcases\\test_right.txt";
	// FileReader fileReader = new FileReader(pathread);
	// BufferedReader reader = new BufferedReader(fileReader);
	// String line = null;
	//
	// while ((line = reader.readLine()) != null) {
	// msg = c.compile(line);
	// System.err.println(msg);
	// if (msg.equals("编译成功"))
	// System.out.println(c.getRule().getStringRule());
	// try {
	// Thread.sleep(100);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// fileReader.close();
	//
	// } catch (IOException e) {
	// }
	//
	// // msg = c.compile(c.StringIn());
	// // System.err.println(msg);
	// // if (msg.equals("编译成功"))
	// // System.out.println(c.getStringRule());
	//	}

}
