package user;
import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;


/**
 * 用于处理用户注册，登录，申请权限，用户管理的事务
 * @author 张广
 *
 */
public class UserBean {
	
	/**
	 * 用户注册
	 * @param userInfo
	 * @throws Exception
	 */
	public void regist(User userInfo) throws Exception {
		Connection con = new DBConnection().getConnection();

		String reg = "insert into users values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(reg);
		pstmt.setString(1, userInfo.getEmail());
		pstmt.setString(2, userInfo.getName());
		pstmt.setString(3, userInfo.getPassword());
		pstmt.setInt(4, userInfo.getRole());// role
		pstmt.setString(5, userInfo.getAuthority());// Authority
		pstmt.setString(6, userInfo.getPasswordQuestion());
		pstmt.setString(7, userInfo.getPasswordAnswer());
		String regTime = new Timestamp(new java.util.Date().getTime()).toString();
		pstmt.setString(8, regTime);// regTime
		pstmt.setInt(9, 0);// logCount
		pstmt.setString(10, regTime);// lastLogTime
		pstmt.setString(11, userInfo.getRegUserInfo());// regUserInfo
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
	 * 获得按注册时间排列的所有用户，显示需要审核的用户，再是其它用户
	 * @param
	 * @return
	 * @throws Exception
	 */
	public ArrayList<User> getAllUsers() throws Exception {
		ArrayList<User> usersList =new ArrayList<User>();
		
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select email,name,role,authority,logCount,lastLogTime from users where role = 1 order by regTime desc");
		
		while(rSet.next()){
			User u=new User();			
			u.setEmail(rSet.getString("email"));
			u.setName(rSet.getString("name"));
			u.setRole(rSet.getInt("role"));
			u.setLogCount(rSet.getInt("logCount"));
			u.setLastLogTime(rSet.getString("lastLogTime"));
			usersList.add(u);			
		}
		rSet = stmt.executeQuery("select email,name,role,authority,logCount,lastLogTime from users where role != 1 order by regTime");
		
		while(rSet.next()){
			User u=new User();			
			u.setEmail(rSet.getString("email"));
			u.setName(rSet.getString("name"));
			u.setRole(rSet.getInt("role"));
			u.setLogCount(rSet.getInt("logCount"));
			u.setLastLogTime(rSet.getString("lastLogTime"));
			usersList.add(u);			
		}
		
		if(rSet != null){
			rSet.close();
			rSet=null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
		
		return usersList;
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
		ResultSet rSet = stmt
				.executeQuery("select count(email) from users");
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
	 * 获得指定email的用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getUser(String email) throws Exception {
		User u=new User();	

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from users where email='" + email+"'");

		if (rSet.next()) {
			u.setEmail(rSet.getString("email"));
			u.setName(rSet.getString("name"));
			u.setRole(rSet.getInt("role"));
			u.setAuthority(rSet.getString("authority"));
			u.setRegUserInfo(rSet.getString("regUserInfo"));
			u.setRegTime(rSet.getString("regTime"));
			u.setPasswordQuestion(rSet.getString("passwordQuestion"));
			u.setPasswordAnswer(rSet.getString("passwordAnswer"));
			u.setLogCount(rSet.getInt("logCount"));
			u.setLastLogTime(rSet.getString("lastLogTime"));
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

}
