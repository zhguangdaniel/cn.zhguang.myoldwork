package rules.compiler;

import java.util.LinkedList;
import rules.compiler.exceptions.*;
import rules.Rule;
import rules.RuleOption;

import java.lang.Integer;

/**
 * 语法分析和语义分析
 * 
 * @author 张广
 * 
 */
public class SyntaxAnalyzer {

	private int state;

	private Rule rule = new Rule();

	/**
	 * 获得语法分析后的Rule（必须在调用了analysis函数之后使用）
	 * 
	 * @return rule 语法分析后形成的rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * 语法分析
	 * 
	 * @param list
	 *            经过词法分析的正确的输入单词表
	 * @throws SyntacticException
	 *             抛出语法错误
	 * @throws SemanticException
	 *             抛出语义错误
	 */
	public void analysis(LinkedList<String> list) throws SyntacticException,
			SemanticException {
		int pos = 0;// 当期读取的单词表的未知
		state = 0;// 状态转换
		boolean isLenShort = false;// 规则单词表的长度是否过短
		while (true) {
			if (isLenShort)
				throw new SyntacticException(
						"语法错误：\n规则表达式长度过短，可能缺少某些成分（正确格式为：Action Protocol IP Port [->|<>] IP Port [( OptionList)] msg:\"Str\"）");
			switch (state) {
			case 0: {
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				String act = list.get(pos);
				// 操作： 1:Alert; 2:Log; 3:Pass;
				if (act.equals("alert")) {
					rule.action = 1;
					state = 1;
					pos++;
				} else if (act.equals("log")) {
					rule.action = 2;
					state = 1;
					pos++;
				} else if (act.equals("pass")) {
					rule.action = 3;
					state = 1;
					pos++;
				} else
					throw new SyntacticException(
							"语法错误：\n操作错误(第一个单词)，本系统暂时只支持 \"alert\",\"log\",\"pass\" 操作");
			}
				break;
			case 1: {
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				String protocol = list.get(pos);
				// 协议： 1:Ethernet 2:IP 3:ARP 4:TCP 5:UDP 6:ICMP 7:Other
				if (protocol.equals("ethernet")) {
					rule.protocol = 1;
					state = 2;
					pos++;
				} else if (protocol.equals("ip")) {
					rule.protocol = 2;
					state = 2;
					pos++;
				} else if (protocol.equals("arp")) {
					rule.protocol = 3;
					state = 2;
					pos++;
				} else if (protocol.equals("tcp")) {
					rule.protocol = 4;
					state = 2;
					pos++;
				} else if (protocol.equals("udp")) {
					rule.protocol = 5;
					state = 2;
					pos++;
				} else if (protocol.equals("icmp")) {
					rule.protocol = 6;
					state = 2;
					pos++;
				} else if (protocol.equals("other")) {
					rule.protocol = 7;
					state = 2;
					pos++;
				} else
					throw new SyntacticException(
							"语法错误：\n协议错误或缺失，本系统暂时只"
									+ "\"Ethernet\",\"IP\",\"ARP\",\"TCP\",\"UDP\",\"ICMP\",\"Other\"等几种协议");
			}
				break;
			case 2: {
				// 识别第一个IP地址
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("any")) {
					rule.srcIPAddr = "any";
					state = 3;
					pos++;
				} else if (list.get(pos).equals("!")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"语义错误：\n第一个IP地址错误，在Ethernet协议下，IP地址无效，所以只能使用any");
					rule.srcIPNot = true;
					pos++;
					String IP = "";
					if (pos < list.size() && list.get(pos).equals("any")) {
						throw new SyntacticException(
								"语法错误：\n第一个IP地址表示错误,\"!\"后不能跟any");
					}
					if (pos + 6 >= list.size()) {
						isLenShort = true;
						break;
					}
					for (int i = 0; i < 7; i++) {
						IP += list.get(pos + i);
					}

					if (IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
						if (Integer.parseInt(list.get(pos)) < 256
								&& Integer.parseInt(list.get(pos + 2)) < 256
								&& Integer.parseInt(list.get(pos + 4)) < 256
								&& Integer.parseInt(list.get(pos + 6)) < 256) {
							rule.srcIPAddr = IP;
							state = 3;
							pos += 7;
						} else
							throw new SemanticException(
									"语义错误：\n第一个IP地址的每个值都要在[0,255]之间");
					} else
						throw new SyntacticException("语法错误：\n第一个IP地址表示错误");
				} else if (list.get(pos).matches("[0-9]+")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"语义错误：\n第一个IP地址错误，在Ethernet协议下，IP地址无效，所以只能使用any");
					String IP = "";
					if (pos + 6 >= list.size()) {
						isLenShort = true;
						break;
					}
					for (int i = 0; i < 7; i++) {
						IP += list.get(pos + i);
					}

					if (IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
						if (Integer.parseInt(list.get(pos)) < 256
								&& Integer.parseInt(list.get(pos + 2)) < 256
								&& Integer.parseInt(list.get(pos + 4)) < 256
								&& Integer.parseInt(list.get(pos + 6)) < 256) {
							rule.srcIPAddr = IP;
							state = 3;
							pos += 7;
						} else
							throw new SemanticException(
									"语义错误：\n第一个IP地址的每个值都要在[0,255]之间");
					} else
						throw new SyntacticException("语法错误：\n第一个IP地址表示错误");
				} else
					throw new SyntacticException("语法错误：\n第一个IP地址错误或缺失");
			}
				break;
			case 3: {
				// 识别第一个端口Port
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("any")) {
					rule.srcPort = "any";
					state = 4;
					pos++;
				} else if (list.get(pos).equals("!")) {
					if (rule.protocol == 1 || rule.protocol == 2
							|| rule.protocol == 3 || rule.protocol == 6)
						throw new SemanticException(
								"语义错误：\n第一个端口错误，在Ethernet,IP,ARP,ICMP协议下，端口无效，所以只能使用any");
					rule.srcPortNot = true;
					pos++;
					if (pos < list.size() && list.get(pos).equals("any")) {
						throw new SyntacticException(
								"语法错误：\n第一个端口表示错误,\"!\"后不能跟any");
					}
					if (pos + 2 >= list.size()) {
						isLenShort = true;
						break;
					}
					if (list.get(pos).matches("\\d{1,5}")) {
						if (list.get(pos + 1).equals(":")
								&& list.get(pos + 2).matches("\\d{1,5}")) {
							if (Integer.parseInt(list.get(pos)) >= 65536
									|| Integer.parseInt(list.get(pos + 2)) >= 65536)
								throw new SemanticException(
										"语义错误：\n第一个端口的值要在[0,65535]之间");
							if (Integer.parseInt(list.get(pos)) >= Integer
									.parseInt(list.get(pos + 2)))
								throw new SemanticException(
										"语义错误：\n第一个端口的形式num1:num2中，num1必须小于num2");

							rule.srcPort = list.get(pos) + list.get(pos + 1)
									+ list.get(pos + 2);
							pos += 3;
							state = 4;
						} else if (list.get(pos + 1).equals(":")
								&& (!list.get(pos + 2).matches("\\d{1,5}"))) {
							throw new SyntacticException(
									"语法错误：\n第一个端口的“:”后缺失或错误");
						} else {
							if (Integer.parseInt(list.get(pos)) >= 65536)
								throw new SemanticException(
										"语义错误：\n第一个端口的值要在[0,65535]之间");
							rule.srcPort = list.get(pos);
							pos++;
							state = 4;
						}
					} else
						throw new SyntacticException("语法错误：\n第一个端口缺失或错误");
				} else if (list.get(pos).matches("\\d{1,5}")) {
					if (rule.protocol == 1 || rule.protocol == 2
							|| rule.protocol == 3 || rule.protocol == 6)
						throw new SemanticException(
								"语义错误：\n第一个端口错误，在Ethernet,IP,ARP,ICMP协议下，端口无效，所以只能使用any");
					if (pos >= list.size()) {
						isLenShort = true;
						break;
					}
					if (list.get(pos + 1).equals(":")
							&& list.get(pos + 2).matches("\\d{1,5}")) {
						if (Integer.parseInt(list.get(pos)) >= 65536
								|| Integer.parseInt(list.get(pos + 2)) >= 65536)
							throw new SemanticException(
									"语义错误：\n第一个端口的值要在[0,65535]之间");
						if (Integer.parseInt(list.get(pos)) >= Integer
								.parseInt(list.get(pos + 2)))
							throw new SemanticException(
									"语义错误：\n第一个端口的形式num1:num2中，num1必须小于num2");
						rule.srcPort = list.get(pos) + list.get(pos + 1)
								+ list.get(pos + 2);
						pos += 3;
						state = 4;
					} else if (list.get(pos + 1).equals(":")
							&& (!list.get(pos + 2).matches("\\d{1,5}"))) {
						throw new SyntacticException("语法错误：\n第一个端口的“:”后缺失或错误");
					} else {
						if (Integer.parseInt(list.get(pos)) >= 65536)
							throw new SemanticException(
									"语义错误：\n第一个端口的值要在[0,65535]之间");
						rule.srcPort = list.get(pos);
						pos++;
						state = 4;
					}
				} else
					throw new SyntacticException("语法错误：\n第一个端口缺失或错误");

			}
				break;
			case 4: {
				// 识别流向
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("->")) {
					state = 5;
					pos++;
				} else if (list.get(pos).equals("<>")) {
					rule.packetDirection = "<>";
					state = 5;
					pos++;
				} else
					throw new SyntacticException(
							"语法错误：\n包的流向 (\"->\",\"<>\") 错误或缺失");
			}
				break;
			case 5: {
				// 识别第二个IP地址
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("any")) {
					rule.dstIPAddr = "any";
					state = 6;
					pos++;
				} else if (list.get(pos).equals("!")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"语义错误：\n第二个IP地址错误，在Ethernet协议下，IP地址无效，所以只能使用any");
					rule.dstIPNot = true;
					pos++;
					String IP = "";
					if (pos < list.size() && list.get(pos).equals("any")) {
						throw new SyntacticException(
								"语法错误：\n第二个IP地址表示错误,\"!\"后不能跟any");
					}
					if (pos + 6 >= list.size()) {
						isLenShort = true;
						break;
					}
					for (int i = 0; i < 7; i++) {
						IP += list.get(pos + i);
					}

					if (IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
						if (Integer.parseInt(list.get(pos)) < 256
								&& Integer.parseInt(list.get(pos + 2)) < 256
								&& Integer.parseInt(list.get(pos + 4)) < 256
								&& Integer.parseInt(list.get(pos + 6)) < 256) {
							rule.dstIPAddr = IP;
							state = 6;
							pos += 7;
						} else
							throw new SemanticException(
									"语义错误：\n第二个IP地址的每个值都要在[0,255]之间");
					} else
						throw new SyntacticException("语法错误：\n第二个IP地址表示错误");
				} else if (list.get(pos).matches("[0-9]+")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"语义错误：\n第二个IP地址错误，在Ethernet协议下，IP地址无效，所以只能使用any");
					String IP = "";
					if (pos + 6 >= list.size()) {
						isLenShort = true;
						break;
					}
					for (int i = 0; i < 7; i++) {
						IP += list.get(pos + i);
					}

					if (IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
						if (Integer.parseInt(list.get(pos)) < 256
								&& Integer.parseInt(list.get(pos + 2)) < 256
								&& Integer.parseInt(list.get(pos + 4)) < 256
								&& Integer.parseInt(list.get(pos + 6)) < 256) {
							rule.dstIPAddr = IP;
							state = 6;
							pos += 7;
						} else
							throw new SemanticException(
									"语义错误：\n第二个IP地址的每个值都要在[0,255]之间");
					} else
						throw new SyntacticException("语法错误：\n第二个IP地址表示错误");
				} else
					throw new SyntacticException("语法错误：\n第二个IP地址错误或缺失");
			}
				break;
			case 6: {
				// 识别第二个端口Port
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("any")) {
					rule.dstPort = "any";
					state = 7;
					pos++;
				} else if (list.get(pos).equals("!")) {
					if (rule.protocol == 1 || rule.protocol == 2
							|| rule.protocol == 3 || rule.protocol == 6)
						throw new SemanticException(
								"语义错误：\n第二个端口错误，在Ethernet,IP,ARP,ICMP协议下，端口无效，所以只能使用any");
					rule.dstPortNot = true;
					pos++;
					if (pos < list.size() && list.get(pos).equals("any")) {
						throw new SyntacticException(
								"语法错误：\n第二个端口表示错误,\"!\"后不能跟any");
					}
					if (pos + 2 >= list.size()) {
						isLenShort = true;
						break;
					}
					if (list.get(pos).matches("\\d{1,5}")) {
						if (list.get(pos + 1).equals(":")
								&& list.get(pos + 2).matches("\\d{1,5}")) {
							if (Integer.parseInt(list.get(pos)) >= 65536
									|| Integer.parseInt(list.get(pos + 2)) >= 65536)
								throw new SemanticException(
										"语义错误：\n第二个端口的值要在[0,65535]之间");
							if (Integer.parseInt(list.get(pos)) >= Integer
									.parseInt(list.get(pos + 2)))
								throw new SemanticException(
										"语义错误：\n第二个端口的形式num1:num2中，num1必须小于num2");
							rule.dstPort = list.get(pos) + list.get(pos + 1)
									+ list.get(pos + 2);
							pos += 3;
							state = 7;
						} else if (list.get(pos + 1).equals(":")
								&& (!list.get(pos + 2).matches("\\d{1,5}"))) {
							throw new SyntacticException(
									"语法错误：\n第二个端口的“:”后缺失或错误");
						} else {
							if (Integer.parseInt(list.get(pos)) >= 65536)
								throw new SemanticException(
										"语义错误：\n第二个端口的值要在[0,65535]之间");
							rule.dstPort = list.get(pos);
							pos++;
							state = 7;
						}
					} else
						throw new SyntacticException("语法错误：\n第二个端口缺失或错误");
				} else if (list.get(pos).matches("\\d{1,5}")) {
					if (rule.protocol == 1 || rule.protocol == 2
							|| rule.protocol == 3 || rule.protocol == 6)
						throw new SemanticException(
								"语义错误：\n第二个端口错误，在Ethernet,IP,ARP,ICMP协议下，端口无效，所以只能使用any");
					if (pos + 2 >= list.size()) {
						isLenShort = true;
						break;
					}
					if (list.get(pos + 1).equals(":")
							&& list.get(pos + 2).matches("\\d{1,5}")) {
						if (Integer.parseInt(list.get(pos)) >= 65536
								|| Integer.parseInt(list.get(pos + 2)) >= 65536)
							throw new SemanticException(
									"语义错误：\n第二个端口的值要在[0,65535]之间");
						if (Integer.parseInt(list.get(pos)) >= Integer
								.parseInt(list.get(pos + 2)))
							throw new SemanticException(
									"语义错误：\n第二个端口的形式num1:num2中，num1必须小于num2");
						rule.dstPort = list.get(pos) + list.get(pos + 1)
								+ list.get(pos + 2);
						pos += 3;
						state = 7;
					} else if (list.get(pos + 1).equals(":")
							&& (!list.get(pos + 2).matches("\\d{1,5}"))) {
						throw new SyntacticException("语法错误：\n第二个端口的“:”后缺失或错误");
					} else {
						if (Integer.parseInt(list.get(pos)) >= 65536)
							throw new SemanticException(
									"语义错误：\n第二个端口的值要在[0,65535]之间");
						rule.dstPort = list.get(pos);
						pos++;
						state = 7;
					}
				} else
					throw new SyntacticException("语法错误：\n第二个端口缺失或错误");
			}
				break;
			case 7: {
				// 识别转向选项或Msg
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("msg")) {
					state = 8;
				} else if (list.get(pos).equals("(")) {
					state = 9;
					pos++;
				} else
					throw new SyntacticException(
							"语法错误：\n第二个端口后面应该是(选项)或Msg，且选项的括号不能缺少");
			}
				break;
			case 8: {
				// 识别Msg
				if (pos < list.size() && list.get(pos).equals("msg")
						&& (pos + 1) < list.size()
						&& list.get(pos + 1).equals(":")
						&& (pos + 2) < list.size()
						&& list.get(pos + 2).matches("\"[\\x00-\\x7F]*\"")) {
					rule.msg = list.get(pos + 2);
					pos += 3;
				} else
					throw new SyntacticException(
							"语法错误：\nMsg部分缺失或格式错误（正确格式：msg:\"str\"），str可以为空");
				if (pos != list.size())
					throw new SyntacticException("语法错误：msg:" + rule.msg
							+ " 后有多余的符号");
				return;
			}
			case 9: {
				// 识别各种选项
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("!")) {
					RuleOption ro = new RuleOption();
					ro.optNot = true;
					rule.optionsList.add(ro);
					pos++;
					state = 10;
				} else if (list.get(pos).equals("ttl")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"语义错误：\nttl选项是IP选项，不能用于Ethernet和ARP协议");
					rule.optionsList.add(new RuleOption());
					state = 11;
				} else if (list.get(pos).equals("id")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"语义错误：\nid选项是IP选项，不能用于Ethernet和ARP协议");
					rule.optionsList.add(new RuleOption());
					state = 12;
				} else if (list.get(pos).equals("size")) {
					rule.optionsList.add(new RuleOption());
					state = 13;
				} else if (list.get(pos).equals("flags")) {
					if (rule.protocol != 4)
						throw new SemanticException("语义错误：\nflags选项只能用于TCP协议");
					rule.optionsList.add(new RuleOption());
					state = 14;
				} else if (list.get(pos).equals("seq")) {
					if (rule.protocol != 4)
						throw new SemanticException("语义错误：\nseq选项只能用于TCP协议");
					rule.optionsList.add(new RuleOption());
					state = 15;
				} else if (list.get(pos).equals("ack")) {
					if (rule.protocol != 4)
						throw new SemanticException("语义错误：\nack选项只能用于TCP协议");
					rule.optionsList.add(new RuleOption());
					state = 16;
				} else if (list.get(pos).equals("itype")) {
					if (rule.protocol != 6)
						throw new SemanticException("语义错误：\nitype选项只能用于ICMP协议");
					rule.optionsList.add(new RuleOption());
					state = 17;
				} else if (list.get(pos).equals("icmp_id")) {
					if (rule.protocol != 6)
						throw new SemanticException(
								"语义错误：\nicmp_id选项只能用于ICMP协议");
					rule.optionsList.add(new RuleOption());
					state = 18;
				} else if (list.get(pos).equals("icmp_seq")) {
					if (rule.protocol != 6)
						throw new SemanticException(
								"语义错误：\nicmp_seq选项只能用于ICMP协议");
					rule.optionsList.add(new RuleOption());
					state = 19;
				} else if (list.get(pos).equals("ipoption")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"语义错误：\nipoption选项是IP选项，不能用于Ethernet和ARP协议");
					rule.optionsList.add(new RuleOption());
					state = 20;
				} else if (list.get(pos).equals("content")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"语义错误：\nEthernet下不会检测content选项，所以content选项不能用于Ethernet协议");
					rule.optionsList.add(new RuleOption());
					state = 21;
				} else if (list.get(pos).equals(")")) {
					if (rule.optionsList.size() == 0)
						throw new SyntacticException("语法错误：\n“( )”中不能为空");
					state = 8;
					pos++;
				} else {
					if (rule.optionsList.size() == 0)
						throw new SyntacticException("语法错误：\n第一个选项表示错误");
					else
						throw new SyntacticException(
								"语法错误：\n选项 "
										+ (rule.optionsList.getLast().optNot ? "!"
												: "")
										+ rule.optionsList.getLast().optionType
										+ ": "
										+ rule.optionsList.getLast().optionText
										+ " 的后面存在表示错误");
				}
			}
				break;
			case 10: {
				// 前面有“!”的情况下的
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("ttl")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"语义错误：\nttl选项是IP选项，不能用于Ethernet和ARP协议");
					state = 11;
				} else if (list.get(pos).equals("id")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"语义错误：\nid选项是IP选项，不能用于Ethernet和ARP协议");
					state = 12;
				} else if (list.get(pos).equals("size")) {
					state = 13;
				} else if (list.get(pos).equals("flags")) {
					if (rule.protocol != 4)
						throw new SemanticException("语义错误：\nflags选项只能用于TCP协议");
					state = 14;
				} else if (list.get(pos).equals("seq")) {
					if (rule.protocol != 4)
						throw new SemanticException("语义错误：\nseq选项只能用于TCP协议");
					state = 15;
				} else if (list.get(pos).equals("ack")) {
					if (rule.protocol != 4)
						throw new SemanticException("语义错误：\nack选项只能用于TCP协议");
					state = 16;
				} else if (list.get(pos).equals("itype")) {
					if (rule.protocol != 6)
						throw new SemanticException("语义错误：\nitype选项只能用于ICMP协议");
					state = 17;
				} else if (list.get(pos).equals("icmp_id")) {
					if (rule.protocol != 6)
						throw new SemanticException(
								"语义错误：\nicmp_id选项只能用于ICMP协议");
					state = 18;
				} else if (list.get(pos).equals("icmp_seq")) {
					if (rule.protocol != 6)
						throw new SemanticException(
								"语义错误：\nicmp_seq选项只能用于ICMP协议");
					state = 19;
				} else if (list.get(pos).equals("ipoption")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"语义错误：\nipoption选项是IP选项，不能用于Ethernet和ARP协议");
					state = 20;
				} else if (list.get(pos).equals("content")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"语义错误：\nEthernet下不会检测content选项，所以content选项不能用于Ethernet协议");
					state = 21;
				} else if (list.get(pos).equals(")")) {
					if (rule.optionsList.size() - 1 <= 0)
						throw new SyntacticException("语法错误：\n“( )”中不能为空");
					state = 8;
					pos++;
				} else {
					if (rule.optionsList.size() - 1 <= 0)
						throw new SyntacticException("语法错误：\n第一个选项表示错误");
					else
						throw new SyntacticException(
								"语法错误：\n选项 "
										+ (rule.optionsList
												.get(rule.optionsList.size() - 2).optNot ? "!"
												: "")
										+ rule.optionsList.get(rule.optionsList
												.size() - 2).optionType
										+ ": "
										+ rule.optionsList.get(rule.optionsList
												.size() - 2).optionText
										+ " 之后存在表示错误");
				}
			}
				break;
			case 11: {
				// ttl选项
				if (rule.protocol != 2 && rule.protocol != 4
						&& rule.protocol != 5 && rule.protocol != 6)
					throw new SemanticException(
							"语义错误：\nttl是IP选项，只能用于IP,TCP,UDP,ICMP协议");
				if (pos + 4 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("ttl")
						&& list.get(pos + 1).equals(":")) {
					if (list.get(pos + 2).matches("\\d{1,3}")
							&& list.get(pos + 3).equals(";")) {
						if (Integer.parseInt(list.get(pos + 2)) < 256) {
							rule.optionsList.getLast().optionType = "ttl";
							rule.optionsList.getLast().optionText = list
									.get(pos + 2);
							pos += 4;
							state = 9;
						} else
							throw new SemanticException(
									"语义错误：\nttl的范围只能是[0,255]");
					} else if ((list.get(pos + 2).equals("<") || list.get(
							pos + 2).equals(">"))
							&& list.get(pos + 3).matches("\\d{1,3}")
							&& list.get(pos + 4).equals(";")) {
						rule.optionsList.getLast().optionType = "ttl";
						rule.optionsList.getLast().optionText = list
								.get(pos + 2)
								+ list.get(pos + 3);
						pos += 5;
						state = 9;
					} else
						throw new SyntacticException(
								"语法错误：\nttl部分缺失或格式错误(正确格式：ttl:num;),且num范围为[0,255]");
				} else 
					throw new SyntacticException(
							"语法错误：\nttl部分缺失或格式错误(正确格式：ttl:num;),且num范围为[0,255]");				
			}
				break;
			case 12: {
				// id选项
				if (rule.protocol != 2 && rule.protocol != 4
						&& rule.protocol != 5 && rule.protocol != 6)
					throw new SemanticException(
							"语义错误：\nid是IP选项，只能用于IP,TCP,UDP,ICMP协议");
				if (pos + 3 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("id") && list.get(pos + 1).equals(":")
						&& list.get(pos + 2).matches("\\d{1,5}")
						&& list.get(pos + 3).equals(";")) {
					if (Integer.parseInt(list.get(pos + 2)) < 65536) {
						rule.optionsList.getLast().optionType = "id";
						rule.optionsList.getLast().optionText = list
								.get(pos + 2);
						pos += 4;
						state = 9;
					} else
						throw new SemanticException("语义错误：\nid的范围只能是[0,65535]");
				} else {
					throw new SyntacticException(
							"语法错误：\nid部分缺失或格式错误（正确格式：id:num;)");
				}
			}
				break;
			case 13: {
				// size选项
				if (pos + 4 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("size")
						&& list.get(pos + 1).equals(":")) {
					if (list.get(pos + 2).matches("\\d{1,5}")
							&& list.get(pos + 3).equals(";")) {
						if (Integer.parseInt(list.get(pos + 2)) < 65536) {
							rule.optionsList.getLast().optionType = "size";
							rule.optionsList.getLast().optionText = list
									.get(pos + 2);
							pos += 4;
							state = 9;
						} else
							throw new SemanticException(
									"语义错误：\nsize的范围只能是[0,65535]");
					} else if ((list.get(pos + 2).equals("<") || list.get(
							pos + 2).equals(">"))
							&& list.get(pos + 3).matches("\\d{1,5}")
							&& list.get(pos + 4).equals(";")) {
						rule.optionsList.getLast().optionType = "size";
						rule.optionsList.getLast().optionText = list
								.get(pos + 2)
								+ list.get(pos + 3);
						pos += 5;
						state = 9;
					} else
						throw new SyntacticException(
								"语法错误：\nsize部分缺失或格式错误（正确格式：size:[>|<]num;）");
				} else {
					throw new SyntacticException(
							"语法错误：\nsize部分缺失或格式错误（正确格式：size:[>|<]num;）");
				}
			}
				break;
			case 14: {
				// flags选项
				if (rule.protocol != 4)
					throw new SemanticException("语义错误：\nflags只能用于TCP协议");
				if (pos + 3 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("flags")
						&& list.get(pos + 1).equals(":")
						&& list.get(pos + 2).matches("[fsrpau21]+")
						&& list.get(pos + 3).equals(";")) {
					rule.optionsList.getLast().optionType = "flags";
					rule.optionsList.getLast().optionText = list.get(pos + 2);
					pos += 4;
					state = 9;
				} else
					throw new SyntacticException(
							"语法错误：\nflags部分缺失或格式错误（正确格式：flags:[fsrpau21]+;）");
			}
				break;
			case 15: {
				// seq
				if (rule.protocol != 4)
					throw new SemanticException("语义错误：\nseq选项只能用于TCP协议");
				if (pos + 3 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("seq")
						&& list.get(pos + 1).equals(":")
						&& list.get(pos + 2).matches("[0-9]+")
						&& list.get(pos + 3).equals(";")) {
					rule.optionsList.getLast().optionType = "seq";
					rule.optionsList.getLast().optionText = list.get(pos + 2);
					pos += 4;
					state = 9;
				} else
					throw new SyntacticException(
							"语法错误：\nseq部分缺失或格式错误（正确格式：seq:num;）");
			}
				break;
			case 16: {
				// ack
				if (rule.protocol != 4)
					throw new SemanticException("语义错误：\nack选项只能用于TCP协议");
				if (pos + 3 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("ack")
						&& list.get(pos + 1).equals(":")
						&& list.get(pos + 2).matches("[0-9]+")
						&& list.get(pos + 3).equals(";")) {
					rule.optionsList.getLast().optionType = "ack";
					rule.optionsList.getLast().optionText = list.get(pos + 2);
					pos += 4;
					state = 9;
				} else
					throw new SyntacticException(
							"语法错误：\nack部分缺失或格式错误（正确格式：ack:num;）");
			}
				break;
			case 17: {
				// itype选项
				if (rule.protocol != 6)
					throw new SemanticException("语义错误：\nitype选项只能用于ICMP协议");
				if (pos + 3 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("itype")
						&& list.get(pos + 1).equals(":")
						&& list.get(pos + 2).matches("[0-9]+")
						&& list.get(pos + 3).equals(";")) {
					rule.optionsList.getLast().optionType = "itype";
					rule.optionsList.getLast().optionText = list.get(pos + 2);
					pos += 4;
					state = 9;
				} else
					throw new SyntacticException(
							"语法错误：\nitype部分缺失或格式错误（正确格式：itype:num;）");
			}
				break;
			case 18: {
				// icmp_id选项
				if (rule.protocol != 6)
					throw new SemanticException("语义错误：\nicmp_id选项只能用于ICMP协议");
				if (pos + 3 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("icmp_id")
						&& list.get(pos + 1).equals(":")
						&& list.get(pos + 2).matches("[0-9]+")
						&& list.get(pos + 3).equals(";")) {
					rule.optionsList.getLast().optionType = "icmp_id";
					rule.optionsList.getLast().optionText = list.get(pos + 2);
					pos += 4;
					state = 9;
				} else
					throw new SyntacticException(
							"语法错误：\nicmp_id部分缺失或格式错误（正确格式：icmp_id:num;）");

			}
				break;
			case 19: {
				// icmp_seq选项
				if (rule.protocol != 6)
					throw new SemanticException("语义错误：\nicmp_seq选项只能用于ICMP协议");
				if (pos + 3 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("icmp_seq")
						&& list.get(pos + 1).equals(":")
						&& list.get(pos + 2).matches("[0-9]+")
						&& list.get(pos + 3).equals(";")) {
					rule.optionsList.getLast().optionType = "icmp_seq";
					rule.optionsList.getLast().optionText = list.get(pos + 2);
					pos += 4;
					state = 9;
				} else
					throw new SyntacticException(
							"语法错误：\nicmp_seq部分缺失或格式错误（正确格式：icmp_seq:num;）");
			}
				break;
			case 20: {
				// ipoption:
				if (rule.protocol != 2 && rule.protocol != 4
						&& rule.protocol != 5 && rule.protocol != 6)
					throw new SemanticException(
							"语义错误：\nipoption是IP选项，只能用于IP,TCP,UDP,ICMP协议");
				if (pos + 2 >= list.size()) {
					isLenShort = true;
					break;
				}
				rule.optionsList.getLast().optionType = "ipoption";
				rule.optionsList.getLast().optionText = list.get(pos + 2);
				pos += 4;
				state = 9;
			}
				break;
			case 21: {
				// content 选项
				if (pos + 2 >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("content")
						&& list.get(pos + 1).equals(":")
						&& list.get(pos + 2).matches("\"[\\x00-\\x7F]+\"")) {

					if (pos + 3 < list.size() && list.get(pos + 3).equals(";")) {
						rule.optionsList.getLast().optionType = "content";
						rule.optionsList.getLast().optionText = list
								.get(pos + 2);
						pos += 4;
						state = 9;
					} else if (pos + 4 < list.size()
							&& list.get(pos + 3).equals(",")
							&& list.get(pos + 4).equals("nocase")) {
						if (pos + 5 < list.size()
								&& list.get(pos + 5).equals(";")) {
							rule.optionsList.getLast().optionType = "content";
							rule.optionsList.getLast().optionText = list
									.get(pos + 2)
									+ list.get(pos + 3) + list.get(pos + 4);
							pos += 6;
							state = 9;
						} else if (pos + 9 < list.size()
								&& list.get(pos + 5).matches(",")
								&& list.get(pos + 6).matches("\\d{1,5}")
								&& list.get(pos + 7).equals(":")
								&& list.get(pos + 8).matches("\\d{1,5}")
								&& list.get(pos + 9).equals(";")) {
							if (Integer.parseInt(list.get(pos + 6)) >= Integer
									.parseInt(list.get(pos + 8))
									&& Integer.parseInt(list.get(pos + 8)) != 0)
								throw new SemanticException(
										"语义错误：\ncontent选项的num1:num2形式中，num1必须小于num2，除非num2为0(此时表示一直查找到包的尾部)");
							rule.optionsList.getLast().optionType = "content";
							rule.optionsList.getLast().optionText = list
									.get(pos + 2)
									+ list.get(pos + 3)
									+ list.get(pos + 4)
									+ list.get(pos + 5)
									+ list.get(pos + 6)
									+ list.get(pos + 7) + list.get(pos + 8);
							pos += 10;
							state = 9;
						} else
							throw new SyntacticException(
									"语法错误：\ncontent部分缺失或格式错误（正确格式：content:\"Str\"[,nocase][,num:num];且num<65536,Str非空）");
					} else if (pos + 7 < list.size()
							&& list.get(pos + 3).matches(",")
							&& list.get(pos + 4).matches("\\d{1,5}")
							&& list.get(pos + 5).equals(":")
							&& list.get(pos + 6).matches("\\d{1,5}")
							&& list.get(pos + 7).equals(";")) {
						if (Integer.parseInt(list.get(pos + 4)) >= Integer
								.parseInt(list.get(pos + 6))
								&& Integer.parseInt(list.get(pos + 6)) != 0)
							throw new SemanticException(
									"语义错误：\ncontent选项的num1:num2形式中，num1必须小于num2，除非num2为0(此时表示一直查找到包的尾部)");
						rule.optionsList.getLast().optionType = "content";
						rule.optionsList.getLast().optionText = list
								.get(pos + 2)
								+ list.get(pos + 3)
								+ list.get(pos + 4)
								+ list.get(pos + 5) + list.get(pos + 6);
						pos += 8;
						state = 9;
					} else
						throw new SyntacticException(
								"语法错误：\ncontent部分缺失或格式错误（正确格式：content:\"Str\"[,nocase][,num:num];且num<65536,Str非空）");
				} else
					throw new SyntacticException(
							"语法错误：\ncontent部分缺失或格式错误（正确格式：content:\"Str\"[,nocase][,num:num];且num<65536,Str非空）");
			}
				break;
			default:
				throw new SyntacticException("系统错误：出现未定义的语法状态");
			}
		}
	}
}
