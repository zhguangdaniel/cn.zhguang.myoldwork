package message;

/**
 * 表示单个留言的类
 * 
 * @author 张广
 * 
 */
public class Message {
	// 属性
	private int id;

	private String creator;

	private String createTime;

	private String message;

	private int type;//留言的类型，类型为1，则为管理员的回复，为0时表示是用户的留言

	private int replyID;//留言的类型为1时有效，表示回复的是哪一个留言
	
	private int replyNum; //回复的条数

	// setter方法
	public void setId(int id) {
		this.id = id;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void setReplyID(int replyID){
		this.replyID = replyID;
	}
	
	public void setReplyNum(int replyNum){
		this.replyNum = replyNum;
	}


	// getter方法
	public int getId() {
		return this.id;
	}

	public String getCreator() {
		return this.creator;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public String getMessage() {
		return this.message;
	}

	public int getType() {
		return this.type;
	}
	
	public int getReplyID(){
		return this.replyID;
	}
	
	public int getReplyNum(){
		return this.replyNum;
	}
}
