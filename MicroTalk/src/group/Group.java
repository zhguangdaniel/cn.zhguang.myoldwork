package group;

/**
 * @author 张广
 * 
 */
public class Group {
	private int id;
	private String groupName;
	private String createTime;
	private int memberNum;
	private String groupIconPath;// 群头像

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
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the memberNum
	 */
	public int getMemberNum() {
		return memberNum;
	}

	/**
	 * @param memberNum
	 *            the memberNum to set
	 */
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	/**
	 * @return the groupIconPath
	 */
	public String getGroupIconPath() {
		return groupIconPath;
	}

	/**
	 * @param groupIconPath the groupIconPath to set
	 */
	public void setGroupIconPath(String groupIconPath) {
		this.groupIconPath = groupIconPath;
	}


}
