package rules.compiler;

import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import rules.compiler.exceptions.*;

/**
 * �ʷ�������
 * 
 * @author �Ź�
 * 
 */
public class LexicalAnalyzer {

	/**
	 * ���캯��
	 * 
	 */
	public LexicalAnalyzer() {
	}

	/**
	 * �ʷ�����
	 * 
	 * @param Expr
	 *            �������ı��ʽ
	 * @return �ʷ�������ĵ����б�
	 * @throws LexicalException
	 *             ���ڴʷ�����ʱ�׳����ʷ����󶼴洢��lexicalErrorList��
	 * @throws EmptyExpressionException
	 *             ���ʽΪ��ʱ�׳�
	 */
	public LinkedList<String> analysis(String Expr) throws LexicalException,
			EmptyExpressionException {

		if (Expr.length() == 0) {
			throw new EmptyExpressionException("���ʽΪ��");// �׳����ʽΪ�յ��쳣
		}

		LinkedList<String> list = new LinkedList<String>();
		int pos = 0;// ��ǰ������λ�á�

		String expr = Expr.toLowerCase();// �����д�дת����Сд

		while (pos < expr.length()) {
			boolean isError = false;
			switch (expr.charAt(pos)) {
			case ' ':
			case '\t':
			case '\n':
				pos++;
				break;

			case 'a': {
				if ((pos + 4) < expr.length()
						&& expr.substring(pos, pos + 5).equals("alert")) {
					list.add("alert");
					pos += 5;
				} else if ((pos + 2) < expr.length()
						&& expr.substring(pos, pos + 3).equals("any")) {
					list.add("any");
					pos += 3;
				} else if ((pos + 2) < expr.length()
						&& expr.substring(pos, pos + 3).equals("arp")) {
					list.add("arp");
					pos += 3;
				} else if ((pos + 2) < expr.length()
						&& expr.substring(pos, pos + 3).equals("ack")) {
					list.add("ack");
					pos += 3;
				} else
					isError = true;
			}
				break;

			case 'l': {
				if ((pos + 2) < expr.length()
						&& expr.substring(pos, pos + 3).equals("log")) {
					list.add("log");
					pos += 3;
				} else
					isError = true;
			}
				break;

			case 'p': {
				if ((pos + 3) < expr.length()
						&& expr.substring(pos, pos + 4).equals("pass")) {
					list.add("pass");
					pos += 4;
				} else
					isError = true;
			}
				break;

			case 'e': {
				if ((pos + 7) < expr.length()
						&& expr.substring(pos, pos + 8).equals("ethernet")) {
					list.add("ethernet");
					pos += 8;
				} else
					isError = true;
			}
				break;

			case 'i': {
				if ((pos + 1) < expr.length()
						&& expr.substring(pos, pos + 2).equals("id")) {
					list.add("id");
					pos += 2;
				} else if ((pos + 4) < expr.length()
						&& expr.substring(pos, pos + 5).equals("itype")) {
					list.add("itype");
					pos += 5;
				} else if ((pos + 6) < expr.length()
						&& expr.substring(pos, pos + 7).equals("icmp_id")) {
					list.add("icmp_id");
					pos += 7;
				} else if ((pos + 7) < expr.length()
						&& expr.substring(pos, pos + 8).equals("icmp_seq")) {
					list.add("icmp_seq");
					pos += 8;
				} else if ((pos + 3) < expr.length()
						&& expr.substring(pos, pos + 4).equals("icmp")) {
					list.add("icmp");
					pos += 4;
				} else if ((pos + 7) < expr.length()
						&& expr.substring(pos, pos + 8).equals("ipoption")) {
					list.add("ipoption");
					pos += 8;
					if (expr.charAt(pos) == ':') {
						pos++;
						list.add(":");
						// ��ipoption:�����rr|eol|nop|ts|sec|lsrr|srr|satid֮һ
						if ((pos + 1) < expr.length()
								&& expr.substring(pos, pos + 2).equals("rr")) {
							list.add("rr");
							pos += 2;
						} else if ((pos + 2) < expr.length()
								&& expr.substring(pos, pos + 3).equals("eol")) {
							list.add("eol");
							pos += 3;
						} else if ((pos + 1) < expr.length()
								&& expr.substring(pos, pos + 2).equals("nop")) {
							list.add("nop");
							pos += 2;
						} else if ((pos + 1) < expr.length()
								&& expr.substring(pos, pos + 2).equals("ts")) {
							list.add("ts");
							pos += 2;
						} else if ((pos + 2) < expr.length()
								&& expr.substring(pos, pos + 3).equals("sec")) {
							list.add("sec");
							pos += 3;
						} else if ((pos + 3) < expr.length()
								&& expr.substring(pos, pos + 4).equals("lsrr")) {
							list.add("lsrr");
							pos += 4;
						} else if ((pos + 2) < expr.length()
								&& expr.substring(pos, pos + 3).equals("srr")) {
							list.add("srr");
							pos += 3;
						} else if ((pos + 4) < expr.length()
								&& expr.substring(pos, pos + 5).equals("satid")) {
							list.add("satid");
							pos += 5;
						} else
							throw new LexicalException(
									"�﷨����\n��ipoption:�����ѡ��(rr|eol|nop|ts|sec|lsrr|srr|satid)ȱʧ�����");
					} else
						throw new LexicalException("�﷨����\nipoption ��ȱ�� ':'");

				} else if ((pos + 1) < expr.length()
						&& expr.substring(pos, pos + 2).equals("ip")) {
					list.add("ip");
					pos += 2;
				} else
					isError = true;
			}
				break;

			case 't': {
				if ((pos + 2) < expr.length()
						&& expr.substring(pos, pos + 3).equals("tcp")) {
					list.add("tcp");
					pos += 3;

				} else if ((pos + 2) < expr.length()
						&& expr.substring(pos, pos + 3).equals("ttl")) {
					list.add("ttl");
					pos += 3;

				} else
					isError = true;
			}
				break;

			case 'u': {
				if ((pos + 2) < expr.length()
						&& expr.substring(pos, pos + 3).equals("udp")) {
					list.add("udp");
					pos += 3;

				} else
					isError = true;
			}
				break;

			case 'o': {
				if ((pos + 4) < expr.length()
						&& expr.substring(pos, pos + 5).equals("other")) {
					list.add("other");
					pos += 5;

				} else
					isError = true;
			}
				break;

			case 's': {
				if ((pos + 2) < expr.length()
						&& expr.substring(pos, pos + 3).equals("seq")) {
					list.add("seq");
					pos += 3;

				} else if ((pos + 3) < expr.length()
						&& expr.substring(pos, pos + 4).equals("size")) {
					list.add("size");
					pos += 4;

				} else
					isError = true;
			}
				break;

			case 'c': {
				if ((pos + 6) < expr.length()
						&& expr.substring(pos, pos + 7).equals("content")) {
					list.add("content");
					pos += 7;

				} else
					isError = true;
			}
				break;

			case 'n': {
				if ((pos + 5) < expr.length()
						&& expr.substring(pos, pos + 6).equals("nocase")) {
					list.add("nocase");
					pos += 6;

				} else
					isError = true;
			}
				break;

			case 'f': {
				if ((pos + 4) < expr.length()
						&& expr.substring(pos, pos + 5).equals("flags")) {
					list.add("flags");
					pos += 5;
					if (expr.charAt(pos) == ':') {
						pos++;
						list.add(":");
						// ��flags:�����fsrpau21֮�е�һ������
						String str = "";
						while (true) {
							if (pos < expr.length() && expr.charAt(pos) != ';') {
								str += expr.charAt(pos);
								pos++;
							} else if (pos < expr.length()
									&& expr.charAt(pos) == ';')
								break;
							else
								throw new LexicalException("�﷨����\nflagsѡ���ȱ��;");
						}
						if (!str.matches("[fsrpau21]+"))
							throw new LexicalException(
									"�﷨���󣺡�\nflags:�����ѡ��ȱʧ�����");
						else
							list.add(str);
					} else
						throw new LexicalException("�﷨����\nflags ��ȱ�� ':'");

				} else
					isError = true;
			}
				break;

			case 'm': {
				if ((pos + 2) < expr.length()
						&& expr.substring(pos, pos + 3).equals("msg")) {
					list.add("msg");
					pos += 3;

				} else
					isError = true;
			}
				break;

			case '!': {
				list.add("!");
				pos++;
			}
				break;

			case ':': {
				list.add(":");
				pos++;
			}
				break;

			case ';': {
				list.add(";");
				pos++;
			}
				break;

			case ',': {
				list.add(",");
				pos++;
			}
				break;

			case '-': {
				if ((pos + 1) < expr.length()
						&& expr.substring(pos, pos + 2).equals("->")) {
					list.add("->");
					pos += 2;

				} else
					isError = true;
			}
				break;

			case '<': {
				if ((pos + 1) < expr.length()
						&& expr.substring(pos, pos + 2).equals("<>")) {
					list.add("<>");
					pos += 2;

				} else {
					list.add("<");
					pos++;
				}
			}
				break;

			case '>': {
				list.add(">");
				pos++;
			}
				break;

			case '(': {
				list.add("(");
				pos++;
			}
				break;

			case ')': {
				list.add(")");
				pos++;
			}
				break;

			case '.': {
				list.add(".");
				pos++;
			}
				break;

			case '"': {
				int casePos = pos;
				pos++;
				while (true) {
					if (pos < expr.length() && expr.charAt(pos) != '"') {
						pos++;
					} else if (pos < expr.length() && expr.charAt(pos) == '"') {
						pos++;
						list.add(Expr.substring(casePos, pos));
						break;
					} else {
						if (list.size() == 0)
							throw new LexicalException("�ʷ�����\n�ַ���û��������");
						else
							throw new LexicalException("�ʷ�����\n"
									+ list.getLast() + " ����ַ���û��������");
					}
				}
			}
				break;

			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': {
				String num = "";
				while (pos < expr.length() && expr.charAt(pos) <= '9'
						&& expr.charAt(pos) >= '0') {
					num += expr.charAt(pos);
					pos++;
				}
				list.add(num);
			}
				break;

			default: {
				pos++;
				isError = true;
			}

			}

			if (isError) {
				if (list.size() == 0)
					throw new LexicalException("�ʷ�����\n��һ�������޷�ʶ��");
				else
					throw new LexicalException("�ʷ�����\n" + list.getLast()
							+ " �����޷�ʶ��ĵ���");
			}
		}
		return list;

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
	// LexicalAnalyzer lex = new LexicalAnalyzer();
	// try {
	// String pathread = ".\\testcases\\test_lexicalError.txt";
	// FileReader fileReader = new FileReader(pathread);
	// BufferedReader reader = new BufferedReader(fileReader);
	// String line = null;
	// LinkedList<String> list = null;
	// while ((line = reader.readLine()) != null) {
	// try {
	// list = lex.analysis(line);
	// for (int i = 0; i < list.size(); i++)
	// System.out.print(list.get(i) + " ");
	// System.out.println();
	// try {
	// Thread.sleep(200);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// } catch (LexicalException e) {
	// System.err.println(e.getMessage());
	// } catch (EmptyExpressionException e) {
	// System.err.println(e.getMessage());
	// }
	// }
	//
	// fileReader.close();
	//
	// } catch (IOException e) {
	// }
	// }

}
