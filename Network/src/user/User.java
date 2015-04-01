package user;


/**
 * 
 * 表示用户信息的javaBean
 * 
 * @author 张广
 * 
 */
public class User {
	// 属性
	private String email;// 用户Email，充当用户ID，是用户的唯一标识

	private String name;// 用户名

	private String password;// 用户密码

	private int role;// 用户的角色

	private String authority;// 用户的权限

	private String passwordQuestion;// 用户密码提示的问题

	private String passwordAnswer;// 密码提示问题的答案

	private String regTime;// 用户注册的时间

	private int logCount;// 用户登陆的次数

	private String lastLogTime;// 用户上次登陆的时间

	private String regUserInfo;// 用户向超级管理员提供的身份确认信息

	public static int SuperAdministrator = 0;// 具有一切权限的超级管理员

	public static int RegUser = 1;// 已经注册，等待审批的才能称为管理员的用户

	public static int Administrator = 2;// 已通过审批的管理员

	// 下面是用户的各种权限
	// 下面的各个权限值相或可得到用户的总权限
	// 将用户的权限和下面的权限值A相与，如果结果等于A，则用户具有权限A；如果等于0，则用户不具有权限A
	public static int publishNews = 0;// 1，发布新闻

	public static int editNews = 1;// 2，修改新闻

	public static int delNews = 2;// 3，删除新闻

	public static int publishInfo = 3;// 4，发布通知

	public static int editInfo = 4;// 5，修改通知

	public static int delInfo = 5;// 6，删除通知

	public static int uploadFile = 6;// 7，上传文件

	public static int delFile = 7;// 8，删除文件

	public static int addLink = 8;// 9，添加链接

	public static int editLink = 9;// 10，修改链接

	public static int delLink = 10;// 11，删除链接

	public static int replyMsg =11;// 12，回复留言

	public static int delMsg = 12;// 13，删除留言

	public static int delMsgReply = 13;// 14，删除留言的回复

	public static int publishAffiche = 14;// 15，发布后台首页公告

	public static int regNewUser = 15;// 16，主动注册新的用户

	public static int delUser = 16;// 17，删除一个用户

	public static int allowNewReg = 17;// 18，批准用户的注册，并赋予用户身份和权限

	public static int editUserPower = 18;// 19，修改某用户的身份和权限

	// getter方法
	public String getEmail() {
		return this.email;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public int getRole() {
		return this.role;
	}

	public String getAuthority() {
		return this.authority;
	}

	public String getPasswordQuestion() {
		return this.passwordQuestion;
	}

	public String getPasswordAnswer() {
		return this.passwordAnswer;
	}

	public String getRegTime() {
		return this.regTime;
	}

	public int getLogCount() {
		return this.logCount;
	}

	public String getLastLogTime() {
		return this.lastLogTime;
	}

	public String getRegUserInfo() {
		return this.regUserInfo;
	}

	// setter方法
	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setPasswordQuestion(String passwordQuestion) {
		this.passwordQuestion = passwordQuestion;
	}

	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public void setLogCount(int logCount) {
		this.logCount = logCount;
	}

	public void setLastLogTime(String lastLogTime) {
		this.lastLogTime = lastLogTime;
	}

	public void setRegUserInfo(String regUserInfo) {
		this.regUserInfo = regUserInfo;
	}

	/**
	 * 验证是否具有权限
	 * 
	 * @param authority
	 * @param len
	 * @return
	 */
	public static boolean checkHaveAuthority(String allAuthority,int theAuthority) {
		if (allAuthority.charAt(theAuthority)=='1')
			return true;
		else
			return false;
	}
}
