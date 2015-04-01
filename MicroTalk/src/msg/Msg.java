package msg;

/**
 * 用于表示消息对象
 * 
 * @author 张广
 * 
 */
public class Msg {
	private int id;
	private int createUserId;// 消息发布者的UserID
	private String createTime;
	private String msgContent;
	private boolean isComment;//是不是评论：0(false)：不是，1(true)：是
	private int commentCount;
	private int transmitCount;
	private int commentId;//回复的是哪个消息，只在isComment为1时有效

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
	 * @return the createUserId
	 */
	public int getCreateUserId() {
		return createUserId;
	}

	/**
	 * @param createUserId
	 *            the createUserId to set
	 */
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
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
	 * @return the msgContent
	 */
	public String getMsgContent() {
		return msgContent;
	}

	/**
	 * @param msgContent
	 *            the msgContent to set
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	/**
	 * @return the isComment
	 */
	public boolean isComment() {
		return isComment;
	}

	/**
	 * @param isComment
	 *            the isComment to set
	 */
	public void setComment(boolean isComment) {
		this.isComment = isComment;
	}

	/**
	 * @return the commentCount
	 */
	public int getCommentCount() {
		return commentCount;
	}

	/**
	 * @param commentCount
	 *            the commentCount to set
	 */
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * @return the transmitCount
	 */
	public int getTransmitCount() {
		return transmitCount;
	}

	/**
	 * @param transmitCount
	 *            the transmitCount to set
	 */
	public void setTransmitCount(int transmitCount) {
		this.transmitCount = transmitCount;
	}

	/**
	 * @return the commentId
	 */
	public int getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

}
