package message;

import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;
import page.PageBean;

/**
 * 用于处理留言Msg的发布，更新（修改），删除，获取等
 * 
 * @author 张广
 * 
 */
public class MsgBean {
	/**
	 * 获得指定id的留言的所有回复，按时间逆序排列
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Message> getReplyMsgs(int replyID) throws Exception {
		ArrayList<Message> msgList = new ArrayList<Message>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt
				.executeQuery("select * from message where type=1 and replyID ="
						+ replyID + " order by createTime");

		while (rSet.next()) {
			Message msg = new Message();
			msg.setId(rSet.getInt("id"));
			msg.setCreator(rSet.getString("creator"));
			msg.setCreateTime(rSet.getString("createTime"));
			msg.setMessage(rSet.getString("message"));
			msg.setReplyID(rSet.getInt("replyID"));
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
	 * 获得指定ID的消息（回复）的发布者（用于权限判断）
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String getMsgCreater(int id) throws Exception {
		String creator = null;
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select creator from message where id=" + id);

		if (rSet.next()) {
			creator = rSet.getString("creator");
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

		return creator;
	}
	/**
	 * 添加一个留言msg
	 * 
	 * @param msg
	 */
	public void addMsg(Message msg) throws Exception {
		Connection con = new DBConnection().getConnection();
		String reg = "insert into message values(?,?,?,?,?,?)";
		String createTime = new Timestamp(new java.util.Date().getTime())
				.toString();
		PreparedStatement pstmt = con.prepareStatement(reg);
		pstmt.setString(1, msg.getCreator());// creator

		pstmt.setString(2, createTime);// createTime
		pstmt.setString(3, msg.getMessage());// message
		pstmt.setInt(4, msg.getType());// type
		if (msg.getType() == 1) {
			pstmt.setInt(5, msg.getReplyID());// replyID
		} else {
			pstmt.setString(5, null);
		}
		pstmt.setInt(6, 0);// replyNum
		if (msg.getType() != 0){// 如果是回复
			Statement stat = con.createStatement();
			stat.execute("update message set replyNum=replyNum+1 where id="
					+ msg.getReplyID());
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

	/**
	 * type=0:删除一个留言Msg，并删除其所有回复；type=1:删除一个回复
	 * 
	 * @param id
	 *            要删除的留言的ID
	 */
	public void delMsg(int id, int type) throws Exception {
		Connection con = new DBConnection().getConnection();
		Statement stat = con.createStatement();
		if (type == 1) {
			ResultSet rSet = stat
					.executeQuery("select replyID from message where id=" + id);
			if (rSet.next()) {
				int replyID = rSet.getInt(1);
				stat.execute("update message set replyNum=replyNum-1 where id="
						+ replyID);
			}
			if (rSet != null) {
				rSet.close();
				rSet = null;
			}
		}
		stat.execute("delete from message where id=" + id);
		if (type == 0)
			stat.execute("delete from message where type=1 and replyID =" + id);
		if (stat != null) {
			stat.close();
			stat = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
	}

	/**
	 * 返回所有留言的数量（不含回复）
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getTotalMsgsCount() throws Exception {
		int count = 0;
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt
				.executeQuery("select count(id) from message where type = 0");
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
	 * 返回所有没有回复的留言的数量
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getMsgsCountWithNoReply() throws Exception {
		int count = 0;
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt
				.executeQuery("select count(id) from message where type = 0 and replyNum=0");
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
	 * 获得指定页面的数据，含留言的内容
	 * 
	 * @param page
	 *            指定的页面数
	 * @param recordPerPage
	 *            每页显示的记录数
	 * @return 含有指定页面数据的PageBean
	 * @throws Exception
	 */
	public PageBean getPage(int page, int recordPerPage) throws Exception {
		PageBean p = new PageBean();
		p.setRecordNum(this.getTotalMsgsCount());
		p.setRecordPerPage(recordPerPage);
		p.countMaxPage();
		p.setCurPage(page);

		int beginIndex = (page - 1) * recordPerPage;
		int endIndex = page * recordPerPage;

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt
				.executeQuery("select top "
						+ endIndex
						+ " no=identity(int,1,1),id*1 as id,creator,createTime,message into #temptable from  message where type=0 order by createTime desc"
						+ " select * from #temptable where no>" + beginIndex
						+ " And no <= " + endIndex + "drop table #temptable");

		while (rSet.next()) {
			Message msg = new Message();
			msg.setId(rSet.getInt("id"));
			msg.setCreator(rSet.getString("creator"));
			msg.setCreateTime(rSet.getString("createTime"));
			msg.setMessage(rSet.getString("message"));
			// msg.setIsReplyed(rSet.getInt("isReplyed"));
			p.resultList.add(msg);
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

		return p;
	}
}
