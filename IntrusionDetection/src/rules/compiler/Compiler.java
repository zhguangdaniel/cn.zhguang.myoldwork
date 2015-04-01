package rules.compiler;

import java.io.*;
import java.util.LinkedList;

import rules.compiler.LexicalAnalyzer;
import rules.compiler.SyntaxAnalyzer;
import rules.compiler.exceptions.*;
import rules.Rule;

/**
 * �������������������
 * 
 * @author �Ź�
 * 
 */
public class Compiler {
	private Rule rule = null;

	/**
	 * ����һ��������ʽ�������γɵĹ��򱣴���rule��
	 * 
	 * @param expression
	 *            ��Ҫ����Ĺ�����ʽ
	 * @return ����ɹ����ء�����ɹ��������򷵻��׳����쳣��
	 */
	public String compile(String expression) {
		LexicalAnalyzer lex = new LexicalAnalyzer();
		try {
			LinkedList<String> list = lex.analysis(expression);
			SyntaxAnalyzer syn = new SyntaxAnalyzer();
			syn.analysis(list);
			rule = syn.getRule();
			return "����ɹ�";
		} catch (ExpressionException e) {
			return e.getMessage();
		}
	}

	/**
	 * ����﷨�������Rule�������ڵ�����analysis����֮��ʹ�ã�
	 * 
	 * @return rule �﷨�������γɵ�rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * �����ַ�������
	 * 
	 * @return buffer :����ɹ� / null :����ʧ��
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
	// if (msg.equals("����ɹ�"))
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
	// // if (msg.equals("����ɹ�"))
	// // System.out.println(c.getStringRule());
	//	}

}
