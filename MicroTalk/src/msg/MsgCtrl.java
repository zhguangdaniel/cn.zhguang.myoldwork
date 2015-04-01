package msg;

import java.util.ArrayList;
import database.*;

import java.sql.*;
/**
 * @author 张广
 *
 */
public class MsgCtrl {
	/**
	 * 获得按发布时间排序的前count个最新消息
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Msg> getTopNewMsgs(int count) throws Exception {
		ArrayList<Msg> msgList = new ArrayList<Msg>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top " + count
				+ " * from msg where isComment=0 order by createTime desc");

		while (rSet.next()) {
			Msg msg = new Msg();
			msg.setId(rSet.getInt("id"));
			msg.setCreateUserId(rSet.getInt("createUserId"));
			msg.setCreateTime(rSet.getString("createTime"));
			msg.setMsgContent(rSet.getString("msgContent"));
			msg.setCommentCount(rSet.getInt("commentCount"));
			msg.setTransmitCount(rSet.getInt("transmitCount"));
			msg.setComment(rSet.getInt("isComment")==0);
			msgList.add(msg);
		}

		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}

		return msgList;
	}
	/**
	 * 获得某个用户的按发布时间排序的前count个最新消息
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Msg> getTopNewMsgsOfUser(int count,int id) throws Exception {
		ArrayList<Msg> msgList = new ArrayList<Msg>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top " + count
				+ " * from msg where isComment=0 and createUserId = "+id+" order by createTime desc");

		while (rSet.next()) {
			Msg msg = new Msg();
			msg.setId(rSet.getInt("id"));
			msg.setCreateUserId(rSet.getInt("createUserId"));
			msg.setCreateTime(rSet.getString("createTime"));
			msg.setMsgContent(rSet.getString("msgContent"));
			msg.setCommentCount(rSet.getInt("commentCount"));
			msg.setTransmitCount(rSet.getInt("transmitCount"));
			msg.setComment(rSet.getInt("isComment")==0);
			msgList.add(msg);
		}

		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}

		return msgList;
	}
	/**
	 * 获得按热度排序的前count个最热（最热的意思是回复数和转发数之和最多）消息
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Msg> getTopHotMsgs(int count) throws Exception {
		ArrayList<Msg> msgList = new ArrayList<Msg>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top " + count
				+ " * from msg where isComment=0 order by (commentCount+transmitCount) desc");

		while (rSet.next()) {
			Msg msg = new Msg();
			msg.setId(rSet.getInt("id"));
			msg.setCreateUserId(rSet.getInt("createUserId"));
			msg.setCreateTime(rSet.getString("createTime"));
			msg.setMsgContent(rSet.getString("msgContent"));
			msg.setCommentCount(rSet.getInt("commentCount"));
			msg.setTransmitCount(rSet.getInt("transmitCount"));
			msg.setComment(rSet.getInt("isComment")==0);
			msgList.add(msg);
		}

		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}

		return msgList;
	}
	/**
	 * 获得按评论数排序的前count个消息
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Msg> getMostCommentMsgs(int count) throws Exception {
		ArrayList<Msg> msgList = new ArrayList<Msg>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top " + count
				+ " * from msg where isComment=0 order by commentCount desc");

		while (rSet.next()) {
			Msg msg = new Msg();
			msg.setId(rSet.getInt("id"));
			msg.setCreateUserId(rSet.getInt("createUserId"));
			msg.setCreateTime(rSet.getString("createTime"));
			msg.setMsgContent(rSet.getString("msgContent"));
			msg.setCommentCount(rSet.getInt("commentCount"));
			msg.setTransmitCount(rSet.getInt("transmitCount"));
			msg.setComment(rSet.getInt("isComment")==0);
			msgList.add(msg);
		}

		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}

		return msgList;
	}
	
	/**
	 * 获得按转发数数排序的前count个消息
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Msg> getMostTransMsgs(int count) throws Exception {
		ArrayList<Msg> msgList = new ArrayList<Msg>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top " + count
				+ " * from msg where isComment=0 order by transmitCount desc");

		while (rSet.next()) {
			Msg msg = new Msg();
			msg.setId(rSet.getInt("id"));
			msg.setCreateUserId(rSet.getInt("createUserId"));
			msg.setCreateTime(rSet.getString("createTime"));
			msg.setMsgContent(rSet.getString("msgContent"));
			msg.setCommentCount(rSet.getInt("commentCount"));
			msg.setTransmitCount(rSet.getInt("transmitCount"));
			msg.setComment(rSet.getInt("isComment")==0);
			msgList.add(msg);
		}

		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}

		return msgList;
	}
	
	/**
	 * 查找具有指定关键字的所有消息
	 * 
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Msg> searchMsgs(String keyword) throws Exception {
		ArrayList<Msg> msgList = new ArrayList<Msg>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt
				.executeQuery("select * from msg where msgContent like '%"
						+ keyword + "%' and isComment=0 order by createTime desc");
		while (rSet.next()) {
			Msg msg = new Msg();
			msg.setId(rSet.getInt("id"));
			msg.setCreateUserId(rSet.getInt("createUserId"));
			msg.setCreateTime(rSet.getString("createTime"));
			msg.setMsgContent(rSet.getString("msgContent"));
			msg.setCommentCount(rSet.getInt("commentCount"));
			msg.setTransmitCount(rSet.getInt("transmitCount"));
			msg.setComment(rSet.getInt("isComment")==0);
			msgList.add(msg);
		}

		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}

		return msgList;
	}

	/**
	 * 获得指定ID的消息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Msg getMsg(int id) throws Exception {
		Msg msg = new Msg();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from msg where id=" + id);

		if (rSet.next()) {
			msg.setId(rSet.getInt("id"));
			msg.setCreateUserId(rSet.getInt("createUserId"));
			msg.setCreateTime(rSet.getString("createTime"));
			msg.setMsgContent(rSet.getString("msgContent"));
			msg.setCommentCount(rSet.getInt("commentCount"));
			msg.setTransmitCount(rSet.getInt("transmitCount"));
			msg.setComment(rSet.getInt("isComment")==0);
		}

		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}

		return msg;
	}

	/**
	 * 返回所有记录(仅限于消息，不包括回复)的数量
	 * 
	 * @return
	 * @throws Exception
	 */
	private int getTotalMsgCount() throws Exception {
		int count = 0;
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select count(id) from msg where isComment=0");
		while (rSet.next())
			count = rSet.getInt(1);
		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
		return count;
	}
	

	/**
	 * 获得指定ID消息的按时间逆序排列的所有回复
	 * 
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Msg> getCommentOfMsgId(int msgId) throws Exception {
		ArrayList<Msg> commentList = new ArrayList<Msg>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from msg where isComment=1 and commentId="+msgId+" order by createTime desc");

		while (rSet.next()) {
			Msg comt = new Msg();
			comt.setId(rSet.getInt("id"));
			comt.setCreateUserId(rSet.getInt("createUserId"));
			comt.setCreateTime(rSet.getString("createTime"));
			comt.setMsgContent(rSet.getString("msgContent"));
			comt.setCommentCount(rSet.getInt("commentCount"));
			comt.setTransmitCount(rSet.getInt("transmitCount"));
			comt.setComment(rSet.getInt("isComment")==1);
			comt.setCommentId(rSet.getInt("commentId"));
			commentList.add(comt);
		}

		if (rSet != null) {
			rSet.close();
			rSet = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}

		return commentList;
	}
	
	/**
	 * 添加一条Msg
	 * 
	 * @param msg
	 */
	public void addMsg(Msg msg) throws Exception {
		Connection con = new DBConnection().getConnection();
		String reg = "insert into msg values(?,?,?,?,?,?,?)";
		String createTime = new Timestamp(new java.util.Date().getTime())
				.toString();
		PreparedStatement pstmt = con.prepareStatement(reg);
		pstmt.setString(1, createTime);// createTime
		pstmt.setInt(2, msg.getCreateUserId());// creator
		pstmt.setString(3, msg.getMsgContent());// message
		pstmt.setInt(4, msg.isComment()?1:0);// isComment
		pstmt.setInt(5,0);//commentCount
		pstmt.setInt(6, 0);//transmitCount
		if (msg.isComment()) {
			pstmt.setInt(7, msg.getCommentId());// replyID
		} else {
			pstmt.setString(7, null);
		}
		if (msg.isComment()){//
			Statement stat = con.createStatement();
			stat.execute("update msg set commentCount=commentCount +1 where id="
					+ msg.getCommentId());
			if (stat != null) {
				stat.close();
				stat = null;
			}
		}
		pstmt.executeUpdate();

		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
	}
}