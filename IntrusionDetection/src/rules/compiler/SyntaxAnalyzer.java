package rules.compiler;

import java.util.LinkedList;
import rules.compiler.exceptions.*;
import rules.Rule;
import rules.RuleOption;

import java.lang.Integer;

/**
 * �﷨�������������
 * 
 * @author �Ź�
 * 
 */
public class SyntaxAnalyzer {

	private int state;

	private Rule rule = new Rule();

	/**
	 * ����﷨�������Rule�������ڵ�����analysis����֮��ʹ�ã�
	 * 
	 * @return rule �﷨�������γɵ�rule
	 */
	public Rule getRule() {
		return rule;
	}

	/**
	 * �﷨����
	 * 
	 * @param list
	 *            �����ʷ���������ȷ�����뵥�ʱ�
	 * @throws SyntacticException
	 *             �׳��﷨����
	 * @throws SemanticException
	 *             �׳��������
	 */
	public void analysis(LinkedList<String> list) throws SyntacticException,
			SemanticException {
		int pos = 0;// ���ڶ�ȡ�ĵ��ʱ��δ֪
		state = 0;// ״̬ת��
		boolean isLenShort = false;// ���򵥴ʱ�ĳ����Ƿ����
		while (true) {
			if (isLenShort)
				throw new SyntacticException(
						"�﷨����\n������ʽ���ȹ��̣�����ȱ��ĳЩ�ɷ֣���ȷ��ʽΪ��Action Protocol IP Port [->|<>] IP Port [( OptionList)] msg:\"Str\"��");
			switch (state) {
			case 0: {
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				String act = list.get(pos);
				// ������ 1:Alert; 2:Log; 3:Pass;
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
							"�﷨����\n��������(��һ������)����ϵͳ��ʱֻ֧�� \"alert\",\"log\",\"pass\" ����");
			}
				break;
			case 1: {
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				String protocol = list.get(pos);
				// Э�飺 1:Ethernet 2:IP 3:ARP 4:TCP 5:UDP 6:ICMP 7:Other
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
							"�﷨����\nЭ������ȱʧ����ϵͳ��ʱֻ"
									+ "\"Ethernet\",\"IP\",\"ARP\",\"TCP\",\"UDP\",\"ICMP\",\"Other\"�ȼ���Э��");
			}
				break;
			case 2: {
				// ʶ���һ��IP��ַ
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
								"�������\n��һ��IP��ַ������EthernetЭ���£�IP��ַ��Ч������ֻ��ʹ��any");
					rule.srcIPNot = true;
					pos++;
					String IP = "";
					if (pos < list.size() && list.get(pos).equals("any")) {
						throw new SyntacticException(
								"�﷨����\n��һ��IP��ַ��ʾ����,\"!\"���ܸ�any");
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
									"�������\n��һ��IP��ַ��ÿ��ֵ��Ҫ��[0,255]֮��");
					} else
						throw new SyntacticException("�﷨����\n��һ��IP��ַ��ʾ����");
				} else if (list.get(pos).matches("[0-9]+")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"�������\n��һ��IP��ַ������EthernetЭ���£�IP��ַ��Ч������ֻ��ʹ��any");
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
									"�������\n��һ��IP��ַ��ÿ��ֵ��Ҫ��[0,255]֮��");
					} else
						throw new SyntacticException("�﷨����\n��һ��IP��ַ��ʾ����");
				} else
					throw new SyntacticException("�﷨����\n��һ��IP��ַ�����ȱʧ");
			}
				break;
			case 3: {
				// ʶ���һ���˿�Port
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
								"�������\n��һ���˿ڴ�����Ethernet,IP,ARP,ICMPЭ���£��˿���Ч������ֻ��ʹ��any");
					rule.srcPortNot = true;
					pos++;
					if (pos < list.size() && list.get(pos).equals("any")) {
						throw new SyntacticException(
								"�﷨����\n��һ���˿ڱ�ʾ����,\"!\"���ܸ�any");
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
										"�������\n��һ���˿ڵ�ֵҪ��[0,65535]֮��");
							if (Integer.parseInt(list.get(pos)) >= Integer
									.parseInt(list.get(pos + 2)))
								throw new SemanticException(
										"�������\n��һ���˿ڵ���ʽnum1:num2�У�num1����С��num2");

							rule.srcPort = list.get(pos) + list.get(pos + 1)
									+ list.get(pos + 2);
							pos += 3;
							state = 4;
						} else if (list.get(pos + 1).equals(":")
								&& (!list.get(pos + 2).matches("\\d{1,5}"))) {
							throw new SyntacticException(
									"�﷨����\n��һ���˿ڵġ�:����ȱʧ�����");
						} else {
							if (Integer.parseInt(list.get(pos)) >= 65536)
								throw new SemanticException(
										"�������\n��һ���˿ڵ�ֵҪ��[0,65535]֮��");
							rule.srcPort = list.get(pos);
							pos++;
							state = 4;
						}
					} else
						throw new SyntacticException("�﷨����\n��һ���˿�ȱʧ�����");
				} else if (list.get(pos).matches("\\d{1,5}")) {
					if (rule.protocol == 1 || rule.protocol == 2
							|| rule.protocol == 3 || rule.protocol == 6)
						throw new SemanticException(
								"�������\n��һ���˿ڴ�����Ethernet,IP,ARP,ICMPЭ���£��˿���Ч������ֻ��ʹ��any");
					if (pos >= list.size()) {
						isLenShort = true;
						break;
					}
					if (list.get(pos + 1).equals(":")
							&& list.get(pos + 2).matches("\\d{1,5}")) {
						if (Integer.parseInt(list.get(pos)) >= 65536
								|| Integer.parseInt(list.get(pos + 2)) >= 65536)
							throw new SemanticException(
									"�������\n��һ���˿ڵ�ֵҪ��[0,65535]֮��");
						if (Integer.parseInt(list.get(pos)) >= Integer
								.parseInt(list.get(pos + 2)))
							throw new SemanticException(
									"�������\n��һ���˿ڵ���ʽnum1:num2�У�num1����С��num2");
						rule.srcPort = list.get(pos) + list.get(pos + 1)
								+ list.get(pos + 2);
						pos += 3;
						state = 4;
					} else if (list.get(pos + 1).equals(":")
							&& (!list.get(pos + 2).matches("\\d{1,5}"))) {
						throw new SyntacticException("�﷨����\n��һ���˿ڵġ�:����ȱʧ�����");
					} else {
						if (Integer.parseInt(list.get(pos)) >= 65536)
							throw new SemanticException(
									"�������\n��һ���˿ڵ�ֵҪ��[0,65535]֮��");
						rule.srcPort = list.get(pos);
						pos++;
						state = 4;
					}
				} else
					throw new SyntacticException("�﷨����\n��һ���˿�ȱʧ�����");

			}
				break;
			case 4: {
				// ʶ������
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
							"�﷨����\n�������� (\"->\",\"<>\") �����ȱʧ");
			}
				break;
			case 5: {
				// ʶ��ڶ���IP��ַ
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
								"�������\n�ڶ���IP��ַ������EthernetЭ���£�IP��ַ��Ч������ֻ��ʹ��any");
					rule.dstIPNot = true;
					pos++;
					String IP = "";
					if (pos < list.size() && list.get(pos).equals("any")) {
						throw new SyntacticException(
								"�﷨����\n�ڶ���IP��ַ��ʾ����,\"!\"���ܸ�any");
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
									"�������\n�ڶ���IP��ַ��ÿ��ֵ��Ҫ��[0,255]֮��");
					} else
						throw new SyntacticException("�﷨����\n�ڶ���IP��ַ��ʾ����");
				} else if (list.get(pos).matches("[0-9]+")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"�������\n�ڶ���IP��ַ������EthernetЭ���£�IP��ַ��Ч������ֻ��ʹ��any");
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
									"�������\n�ڶ���IP��ַ��ÿ��ֵ��Ҫ��[0,255]֮��");
					} else
						throw new SyntacticException("�﷨����\n�ڶ���IP��ַ��ʾ����");
				} else
					throw new SyntacticException("�﷨����\n�ڶ���IP��ַ�����ȱʧ");
			}
				break;
			case 6: {
				// ʶ��ڶ����˿�Port
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
								"�������\n�ڶ����˿ڴ�����Ethernet,IP,ARP,ICMPЭ���£��˿���Ч������ֻ��ʹ��any");
					rule.dstPortNot = true;
					pos++;
					if (pos < list.size() && list.get(pos).equals("any")) {
						throw new SyntacticException(
								"�﷨����\n�ڶ����˿ڱ�ʾ����,\"!\"���ܸ�any");
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
										"�������\n�ڶ����˿ڵ�ֵҪ��[0,65535]֮��");
							if (Integer.parseInt(list.get(pos)) >= Integer
									.parseInt(list.get(pos + 2)))
								throw new SemanticException(
										"�������\n�ڶ����˿ڵ���ʽnum1:num2�У�num1����С��num2");
							rule.dstPort = list.get(pos) + list.get(pos + 1)
									+ list.get(pos + 2);
							pos += 3;
							state = 7;
						} else if (list.get(pos + 1).equals(":")
								&& (!list.get(pos + 2).matches("\\d{1,5}"))) {
							throw new SyntacticException(
									"�﷨����\n�ڶ����˿ڵġ�:����ȱʧ�����");
						} else {
							if (Integer.parseInt(list.get(pos)) >= 65536)
								throw new SemanticException(
										"�������\n�ڶ����˿ڵ�ֵҪ��[0,65535]֮��");
							rule.dstPort = list.get(pos);
							pos++;
							state = 7;
						}
					} else
						throw new SyntacticException("�﷨����\n�ڶ����˿�ȱʧ�����");
				} else if (list.get(pos).matches("\\d{1,5}")) {
					if (rule.protocol == 1 || rule.protocol == 2
							|| rule.protocol == 3 || rule.protocol == 6)
						throw new SemanticException(
								"�������\n�ڶ����˿ڴ�����Ethernet,IP,ARP,ICMPЭ���£��˿���Ч������ֻ��ʹ��any");
					if (pos + 2 >= list.size()) {
						isLenShort = true;
						break;
					}
					if (list.get(pos + 1).equals(":")
							&& list.get(pos + 2).matches("\\d{1,5}")) {
						if (Integer.parseInt(list.get(pos)) >= 65536
								|| Integer.parseInt(list.get(pos + 2)) >= 65536)
							throw new SemanticException(
									"�������\n�ڶ����˿ڵ�ֵҪ��[0,65535]֮��");
						if (Integer.parseInt(list.get(pos)) >= Integer
								.parseInt(list.get(pos + 2)))
							throw new SemanticException(
									"�������\n�ڶ����˿ڵ���ʽnum1:num2�У�num1����С��num2");
						rule.dstPort = list.get(pos) + list.get(pos + 1)
								+ list.get(pos + 2);
						pos += 3;
						state = 7;
					} else if (list.get(pos + 1).equals(":")
							&& (!list.get(pos + 2).matches("\\d{1,5}"))) {
						throw new SyntacticException("�﷨����\n�ڶ����˿ڵġ�:����ȱʧ�����");
					} else {
						if (Integer.parseInt(list.get(pos)) >= 65536)
							throw new SemanticException(
									"�������\n�ڶ����˿ڵ�ֵҪ��[0,65535]֮��");
						rule.dstPort = list.get(pos);
						pos++;
						state = 7;
					}
				} else
					throw new SyntacticException("�﷨����\n�ڶ����˿�ȱʧ�����");
			}
				break;
			case 7: {
				// ʶ��ת��ѡ���Msg
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
							"�﷨����\n�ڶ����˿ں���Ӧ����(ѡ��)��Msg����ѡ������Ų���ȱ��");
			}
				break;
			case 8: {
				// ʶ��Msg
				if (pos < list.size() && list.get(pos).equals("msg")
						&& (pos + 1) < list.size()
						&& list.get(pos + 1).equals(":")
						&& (pos + 2) < list.size()
						&& list.get(pos + 2).matches("\"[\\x00-\\x7F]*\"")) {
					rule.msg = list.get(pos + 2);
					pos += 3;
				} else
					throw new SyntacticException(
							"�﷨����\nMsg����ȱʧ���ʽ������ȷ��ʽ��msg:\"str\"����str����Ϊ��");
				if (pos != list.size())
					throw new SyntacticException("�﷨����msg:" + rule.msg
							+ " ���ж���ķ���");
				return;
			}
			case 9: {
				// ʶ�����ѡ��
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
								"�������\nttlѡ����IPѡ���������Ethernet��ARPЭ��");
					rule.optionsList.add(new RuleOption());
					state = 11;
				} else if (list.get(pos).equals("id")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"�������\nidѡ����IPѡ���������Ethernet��ARPЭ��");
					rule.optionsList.add(new RuleOption());
					state = 12;
				} else if (list.get(pos).equals("size")) {
					rule.optionsList.add(new RuleOption());
					state = 13;
				} else if (list.get(pos).equals("flags")) {
					if (rule.protocol != 4)
						throw new SemanticException("�������\nflagsѡ��ֻ������TCPЭ��");
					rule.optionsList.add(new RuleOption());
					state = 14;
				} else if (list.get(pos).equals("seq")) {
					if (rule.protocol != 4)
						throw new SemanticException("�������\nseqѡ��ֻ������TCPЭ��");
					rule.optionsList.add(new RuleOption());
					state = 15;
				} else if (list.get(pos).equals("ack")) {
					if (rule.protocol != 4)
						throw new SemanticException("�������\nackѡ��ֻ������TCPЭ��");
					rule.optionsList.add(new RuleOption());
					state = 16;
				} else if (list.get(pos).equals("itype")) {
					if (rule.protocol != 6)
						throw new SemanticException("�������\nitypeѡ��ֻ������ICMPЭ��");
					rule.optionsList.add(new RuleOption());
					state = 17;
				} else if (list.get(pos).equals("icmp_id")) {
					if (rule.protocol != 6)
						throw new SemanticException(
								"�������\nicmp_idѡ��ֻ������ICMPЭ��");
					rule.optionsList.add(new RuleOption());
					state = 18;
				} else if (list.get(pos).equals("icmp_seq")) {
					if (rule.protocol != 6)
						throw new SemanticException(
								"�������\nicmp_seqѡ��ֻ������ICMPЭ��");
					rule.optionsList.add(new RuleOption());
					state = 19;
				} else if (list.get(pos).equals("ipoption")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"�������\nipoptionѡ����IPѡ���������Ethernet��ARPЭ��");
					rule.optionsList.add(new RuleOption());
					state = 20;
				} else if (list.get(pos).equals("content")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"�������\nEthernet�²�����contentѡ�����contentѡ�������EthernetЭ��");
					rule.optionsList.add(new RuleOption());
					state = 21;
				} else if (list.get(pos).equals(")")) {
					if (rule.optionsList.size() == 0)
						throw new SyntacticException("�﷨����\n��( )���в���Ϊ��");
					state = 8;
					pos++;
				} else {
					if (rule.optionsList.size() == 0)
						throw new SyntacticException("�﷨����\n��һ��ѡ���ʾ����");
					else
						throw new SyntacticException(
								"�﷨����\nѡ�� "
										+ (rule.optionsList.getLast().optNot ? "!"
												: "")
										+ rule.optionsList.getLast().optionType
										+ ": "
										+ rule.optionsList.getLast().optionText
										+ " �ĺ�����ڱ�ʾ����");
				}
			}
				break;
			case 10: {
				// ǰ���С�!��������µ�
				if (pos >= list.size()) {
					isLenShort = true;
					break;
				}
				if (list.get(pos).equals("ttl")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"�������\nttlѡ����IPѡ���������Ethernet��ARPЭ��");
					state = 11;
				} else if (list.get(pos).equals("id")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"�������\nidѡ����IPѡ���������Ethernet��ARPЭ��");
					state = 12;
				} else if (list.get(pos).equals("size")) {
					state = 13;
				} else if (list.get(pos).equals("flags")) {
					if (rule.protocol != 4)
						throw new SemanticException("�������\nflagsѡ��ֻ������TCPЭ��");
					state = 14;
				} else if (list.get(pos).equals("seq")) {
					if (rule.protocol != 4)
						throw new SemanticException("�������\nseqѡ��ֻ������TCPЭ��");
					state = 15;
				} else if (list.get(pos).equals("ack")) {
					if (rule.protocol != 4)
						throw new SemanticException("�������\nackѡ��ֻ������TCPЭ��");
					state = 16;
				} else if (list.get(pos).equals("itype")) {
					if (rule.protocol != 6)
						throw new SemanticException("�������\nitypeѡ��ֻ������ICMPЭ��");
					state = 17;
				} else if (list.get(pos).equals("icmp_id")) {
					if (rule.protocol != 6)
						throw new SemanticException(
								"�������\nicmp_idѡ��ֻ������ICMPЭ��");
					state = 18;
				} else if (list.get(pos).equals("icmp_seq")) {
					if (rule.protocol != 6)
						throw new SemanticException(
								"�������\nicmp_seqѡ��ֻ������ICMPЭ��");
					state = 19;
				} else if (list.get(pos).equals("ipoption")) {
					if (rule.protocol == 1 || rule.protocol == 3)
						throw new SemanticException(
								"�������\nipoptionѡ����IPѡ���������Ethernet��ARPЭ��");
					state = 20;
				} else if (list.get(pos).equals("content")) {
					if (rule.protocol == 1)
						throw new SemanticException(
								"�������\nEthernet�²�����contentѡ�����contentѡ�������EthernetЭ��");
					state = 21;
				} else if (list.get(pos).equals(")")) {
					if (rule.optionsList.size() - 1 <= 0)
						throw new SyntacticException("�﷨����\n��( )���в���Ϊ��");
					state = 8;
					pos++;
				} else {
					if (rule.optionsList.size() - 1 <= 0)
						throw new SyntacticException("�﷨����\n��һ��ѡ���ʾ����");
					else
						throw new SyntacticException(
								"�﷨����\nѡ�� "
										+ (rule.optionsList
												.get(rule.optionsList.size() - 2).optNot ? "!"
												: "")
										+ rule.optionsList.get(rule.optionsList
												.size() - 2).optionType
										+ ": "
										+ rule.optionsList.get(rule.optionsList
												.size() - 2).optionText
										+ " ֮����ڱ�ʾ����");
				}
			}
				break;
			case 11: {
				// ttlѡ��
				if (rule.protocol != 2 && rule.protocol != 4
						&& rule.protocol != 5 && rule.protocol != 6)
					throw new SemanticException(
							"�������\nttl��IPѡ�ֻ������IP,TCP,UDP,ICMPЭ��");
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
									"�������\nttl�ķ�Χֻ����[0,255]");
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
								"�﷨����\nttl����ȱʧ���ʽ����(��ȷ��ʽ��ttl:num;),��num��ΧΪ[0,255]");
				} else 
					throw new SyntacticException(
							"�﷨����\nttl����ȱʧ���ʽ����(��ȷ��ʽ��ttl:num;),��num��ΧΪ[0,255]");				
			}
				break;
			case 12: {
				// idѡ��
				if (rule.protocol != 2 && rule.protocol != 4
						&& rule.protocol != 5 && rule.protocol != 6)
					throw new SemanticException(
							"�������\nid��IPѡ�ֻ������IP,TCP,UDP,ICMPЭ��");
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
						throw new SemanticException("�������\nid�ķ�Χֻ����[0,65535]");
				} else {
					throw new SyntacticException(
							"�﷨����\nid����ȱʧ���ʽ������ȷ��ʽ��id:num;)");
				}
			}
				break;
			case 13: {
				// sizeѡ��
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
									"�������\nsize�ķ�Χֻ����[0,65535]");
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
								"�﷨����\nsize����ȱʧ���ʽ������ȷ��ʽ��size:[>|<]num;��");
				} else {
					throw new SyntacticException(
							"�﷨����\nsize����ȱʧ���ʽ������ȷ��ʽ��size:[>|<]num;��");
				}
			}
				break;
			case 14: {
				// flagsѡ��
				if (rule.protocol != 4)
					throw new SemanticException("�������\nflagsֻ������TCPЭ��");
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
							"�﷨����\nflags����ȱʧ���ʽ������ȷ��ʽ��flags:[fsrpau21]+;��");
			}
				break;
			case 15: {
				// seq
				if (rule.protocol != 4)
					throw new SemanticException("�������\nseqѡ��ֻ������TCPЭ��");
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
							"�﷨����\nseq����ȱʧ���ʽ������ȷ��ʽ��seq:num;��");
			}
				break;
			case 16: {
				// ack
				if (rule.protocol != 4)
					throw new SemanticException("�������\nackѡ��ֻ������TCPЭ��");
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
							"�﷨����\nack����ȱʧ���ʽ������ȷ��ʽ��ack:num;��");
			}
				break;
			case 17: {
				// itypeѡ��
				if (rule.protocol != 6)
					throw new SemanticException("�������\nitypeѡ��ֻ������ICMPЭ��");
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
							"�﷨����\nitype����ȱʧ���ʽ������ȷ��ʽ��itype:num;��");
			}
				break;
			case 18: {
				// icmp_idѡ��
				if (rule.protocol != 6)
					throw new SemanticException("�������\nicmp_idѡ��ֻ������ICMPЭ��");
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
							"�﷨����\nicmp_id����ȱʧ���ʽ������ȷ��ʽ��icmp_id:num;��");

			}
				break;
			case 19: {
				// icmp_seqѡ��
				if (rule.protocol != 6)
					throw new SemanticException("�������\nicmp_seqѡ��ֻ������ICMPЭ��");
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
							"�﷨����\nicmp_seq����ȱʧ���ʽ������ȷ��ʽ��icmp_seq:num;��");
			}
				break;
			case 20: {
				// ipoption:
				if (rule.protocol != 2 && rule.protocol != 4
						&& rule.protocol != 5 && rule.protocol != 6)
					throw new SemanticException(
							"�������\nipoption��IPѡ�ֻ������IP,TCP,UDP,ICMPЭ��");
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
				// content ѡ��
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
										"�������\ncontentѡ���num1:num2��ʽ�У�num1����С��num2������num2Ϊ0(��ʱ��ʾһֱ���ҵ�����β��)");
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
									"�﷨����\ncontent����ȱʧ���ʽ������ȷ��ʽ��content:\"Str\"[,nocase][,num:num];��num<65536,Str�ǿգ�");
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
									"�������\ncontentѡ���num1:num2��ʽ�У�num1����С��num2������num2Ϊ0(��ʱ��ʾһֱ���ҵ�����β��)");
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
								"�﷨����\ncontent����ȱʧ���ʽ������ȷ��ʽ��content:\"Str\"[,nocase][,num:num];��num<65536,Str�ǿգ�");
				} else
					throw new SyntacticException(
							"�﷨����\ncontent����ȱʧ���ʽ������ȷ��ʽ��content:\"Str\"[,nocase][,num:num];��num<65536,Str�ǿգ�");
			}
				break;
			default:
				throw new SyntacticException("ϵͳ���󣺳���δ������﷨״̬");
			}
		}
	}
}
