package user;

/**
 * @author 张广
 * 
 */
public class User {
	private int id;
	private String userName;
	private String email;
	private String password;
	private int role;
	private String selfDescription;// 用户自我描述
	private String userIconPath;// 用户头像
	private String regTime;
	private String lastLogTime;
	private String attentionWho;// 我关注谁（关注的人的User点列表）
	private String whoAttentionMe;// 谁关注我（关注我的人的UserId列表）
	private int attentionMeNum;//关注我的人数
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * @return the selfDescription
	 */
	public String getSelfDescription() {
		return selfDescription;
	}

	/**
	 * @param selfDescription
	 *            the selfDescription to set
	 */
	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	/**
	 * @return the userIconPath
	 */
	public String getUserIconPath() {
		return userIconPath;
	}

	/**
	 * @param userIconPath the userIconPath to set
	 */
	public void setUserIconPath(String userIconPath) {
		this.userIconPath = userIconPath;
	}

	/**
	 * @return the regTime
	 */
	public String getRegTime() {
		return regTime;
	}

	/**
	 * @param regTime
	 *            the regTime to set
	 */
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	/**
	 * @return the lastLogTime
	 */
	public String getLastLogTime() {
		return lastLogTime;
	}

	/**
	 * @param lastLogTime
	 *            the lastLogTime to set
	 */
	public void setLastLogTime(String lastLogTime) {
		this.lastLogTime = lastLogTime;
	}

	/**
	 * @return the attentionWho
	 */
	public String getAttentionWho() {
		return attentionWho;
	}

	/**
	 * @param attentionWho
	 *            the attentionWho to set
	 */
	public void setAttentionWho(String attentionWho) {
		this.attentionWho = attentionWho;
	}

	/**
	 * @return the whoAttentionMe
	 */
	public String getWhoAttentionMe() {
		return whoAttentionMe;
	}

	/**
	 * @param whoAttentionMe
	 *            the whoAttentionMe to set
	 */
	public void setWhoAttentionMe(String whoAttentionMe) {
		this.whoAttentionMe = whoAttentionMe;
	}

	/**
	 * @return the attentionMeNum
	 */
	public int getAttentionMeNum() {
		return attentionMeNum;
	}

	/**
	 * @param attentionMeNum the attentionMeNum to set
	 */
	public void setAttentionMeNum(int attentionMeNum) {
		this.attentionMeNum = attentionMeNum;
	}

}
