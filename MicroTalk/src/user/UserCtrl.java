package user;
import java.util.ArrayList;
import database.*;

import java.sql.*;

/**
 * @author 张广
 *
 */
public class UserCtrl {

	/**
	 * 用户注册
	 * 
	 * @param userInfo
	 * @throws Exception
	 */
	public void regist(User userInfo) throws Exception {
		Connection con = new DBConnection().getConnection();

		String reg = "insert into users values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(reg);
		pstmt.setString(1, userInfo.getUserName());
		pstmt.setString(2, userInfo.getEmail());
		pstmt.setString(3, userInfo.getPassword());
		pstmt.setInt(4, userInfo.getRole());// role
		pstmt.setString(5, userInfo.getSelfDescription());// SelfDescription
		pstmt.setString(6, userInfo.getUserIconPath());
		String regTime = new Timestamp(new java.util.Date().getTime()).toString();
		pstmt.setString(7, regTime);// regTime
		pstmt.setString(8, regTime);// lastLogTime
		pstmt.setString(9, null);//attentionWho
		pstmt.setString(10, null);//Who attention me
		pstmt.setInt(11, 0);//attentionMeNum;
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
	 * 获得按被关注数排序的前count个用户
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<User> getMostAttentionUsers(int count) throws Exception {
		ArrayList<User> userList = new ArrayList<User>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top " + count
				+ " id,userName,userIconPath,attentionMeNum from users order by attentionMeNum desc");
		while (rSet.next()) {
			User u = new User();
			u.setId(rSet.getInt("id"));
			u.setUserName(rSet.getString("userName"));
			u.setUserIconPath(rSet.getString("userIconPath"));
			u.setAttentionMeNum(rSet.getInt("attentionMeNum"));
			userList.add(u);
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

		return userList;
	}

	/**
	 * 返回所有用户的数量
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getTotalUsersCount() throws Exception {
		int count = 0;
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select count(id) from users");
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
	 * 获得指定id的用户
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getUser(int id) throws Exception {
		User u = new User();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from users where id='"
				+ id + "'");

		if (rSet.next()) {
			u.setId(id);
			u.setUserName(rSet.getString("userName"));
			u.setEmail(rSet.getString("email"));
			u.setPassword(rSet.getString("password"));
			u.setRole(rSet.getInt("role"));
			u.setSelfDescription(rSet.getString("selfDescription"));
			u.setUserIconPath(rSet.getString("userIconPath"));
			u.setRegTime(rSet.getString("regTime"));
			u.setLastLogTime(rSet.getString("lastLogTime"));
			u.setAttentionWho(rSet.getString("attentionWho"));
			u.setWhoAttentionMe(rSet.getString("whoAttentionMe"));
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

		return u;
	}
	/**
	 * 获得指定id的用户的主要信息id,UserName,userIconPath
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public User getUserBrief(int id) throws Exception {
		User u = new User();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select id,userName,userIconPath from users where id='"
				+ id + "'");

		if (rSet.next()) {
			u.setId(id);
			u.setUserName(rSet.getString("userName"));
			u.setUserIconPath(rSet.getString("userIconPath"));
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

		return u;
	}
	/**
	 * 通过用户email获得指定id的用户的主要信息id
	 * 
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public int getUserId(String email) throws Exception {

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select id from users where email='"
				+ email + "'");

		if (rSet.next()) {
			return rSet.getInt("id");
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

		return 0;
	}
}
