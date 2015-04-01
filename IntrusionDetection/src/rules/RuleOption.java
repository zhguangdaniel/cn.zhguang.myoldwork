package rules;

/**
 * 规则选项格式为：[!]optionType:"optionText";
 * @author 张广
 *
 */
public class RuleOption {
	/**
	 * 该选项是否取反
	 */
	public boolean optNot = false;

	/**
	 * 规则的选项类型，如  ttl，id，size，content，flags，seq，ack，itype，icmp_id，icmp_seq，ipoption
	 */
	public String optionType = "";

	/**
	 * 选项的内容
	 */
	public String optionText = "";
}
