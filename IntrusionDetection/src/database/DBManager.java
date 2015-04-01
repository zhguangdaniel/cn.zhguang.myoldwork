package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import jpcap.packet.Packet;

/**
 * 
 * @author 张广
 * 
 */
public class DBManager {

	/**
	 * 当前的数据库链接，无连接时为null
	 */
	public Connection conn = null;

	/**
	 * 当前的查询语句，可能为null
	 */
	public Statement stmt = null;

	/**
	 * 当前的结果集，可能为null
	 */
	public ResultSet rs = null;

	/**
	 * JDBC驱动的名字
	 * 
	 * 如果是sql server 2005，dirvername
	 * 为："com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 * 
	 * 如果是sql server 2000，dirvername
	 * 为："com.microsoft.jdbc.sqlserver.SQLServerDriver";
	 */
	public String driverName = null;// 数据库驱动

	/**
	 * 数据库的类型，IP，端口，数据库名称。 如果是sql server 2005，url
	 * 为："jdbc:sqlserver://localhost:1433;DatabaseName=IDS"； 如果是sql server
	 * 2000，url 为："jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=IDS"；
	 * 上面只是举例，IP，端口，数据库名称都是可以改变的。
	 * 
	 */
	public String url = null;// 数据库地址

	/**
	 * 数据库用户名
	 */
	public String username = null;

	/**
	 * 数据库密码
	 */
	public String password = null;

	/**
	 * 初始化， 同时从"./data/defaultDatabase.ini"中读入默认的 （或上次保存的）数据库连接数据
	 * 
	 */
	public DBManager() {
		boolean isError = false;
		try {
			if (!(new File(".\\data")).isDirectory()) {
				(new File(".\\data")).mkdirs();
			}

			FileReader fileReader = new FileReader(
					".\\data\\defaultDatabase.ini");
			BufferedReader reader = new BufferedReader(fileReader);

			driverName = reader.readLine();
			url = reader.readLine();
			username = reader.readLine();
			password = reader.readLine();

			if (driverName == null || url == null || username == null
					|| password == null)
				throw new Exception();

			driverName = driverName.substring(driverName.indexOf("= ") + 2);
			url = url.substring(url.indexOf("= ") + 2);
			username = username.substring(username.indexOf("= ") + 2);
			password = password.substring(password.indexOf("= ") + 2);

			if (!driverName
					.equals("com.microsoft.sqlserver.jdbc.SQLServerDriver")
					&& !driverName
							.equals("com.microsoft.jdbc.sqlserver.SQLServerDriver"))
				throw new Exception();

			// 下面解析URL：
			if (url.startsWith("jdbc:sqlserver://")) {
				// "jdbc:sqlserver://localhost:1433;DatabaseName=IDS"
				int idxIP = url.indexOf("//") + 2;
				int idxPort = url.indexOf(":", idxIP) + 1;
				url.substring(idxIP, idxPort - 1);
				url.substring(idxPort, url.indexOf(";", idxPort));
				url.substring(url.indexOf("=", idxPort) + 1);
			} else if (url.startsWith("jdbc:microsoft:sqlserver://")) {
				// "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=IDS"
				int idxIP = url.indexOf("//") + 2;
				int idxPort = url.indexOf(":", idxIP) + 1;
				url.substring(idxIP, idxPort - 1);
				url.substring(idxPort, url.indexOf(";", idxPort));
				url.substring(url.indexOf("=", idxPort) + 1);
			} else
				throw new Exception();
			fileReader.close();
		} catch (Exception e) {
			isError = true;
		}
		if (isError) {
			driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			url = "jdbc:sqlserver://localhost:1433;DatabaseName=IDS";
			username = "admin";
			password = "123456";
		}
	}

	/**
	 * 建立数据库连接，连接之前必须已经设置了正确的driverName,url,username,password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void connect() throws SQLException, ClassNotFoundException {
		// load the driver
		Class.forName(driverName);
		// get Connection
		conn = DriverManager.getConnection(url, username, password);
	}

	/**
	 * 在数据库中添加一行
	 * 
	 * @param index
	 *            序列号
	 * @param p
	 *            要添加的包
	 * @param rule
	 *            匹配的规则
	 * @param result
	 *            处理的结果
	 * @throws SQLException
	 */
	public void addAlertInfo(int index, Packet p, String rule, String result)
			throws SQLException {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < p.header.length; i++) {
			String d = Integer.toHexString((int) ((p.header)[i] & 0xff));
			buf.append(d.length() == 1 ? "0" + d : d);
		}
		for (int i = 0; i < p.data.length; i++) {
			String d = Integer.toHexString((int) ((p.data)[i] & 0xff));
			buf.append(d.length() == 1 ? "0" + d : d);
		}
		stmt = conn.createStatement();
		String sql = "insert into AlertInfo values(" + index + ",'"
				+ buf.toString() + "','" + rule + "','" + result + "')";
		stmt.execute(sql);
		stmt.close();
	}

	/**
	 * 清空AlertInfo数据库
	 * 
	 * @throws SQLException
	 */
	public void clear() throws SQLException {
		stmt = conn.createStatement();
		String sql = "delete from AlertInfo";
		stmt.execute(sql);
		stmt.close();
	}

	/**
	 * 执行指定的sql语句，不返回任何数据
	 * 
	 * @param sql
	 *            要执行的sql语句
	 * @throws SQLException
	 */
	public void execute(String sql) throws SQLException {
		stmt = conn.createStatement();
		stmt.execute(sql);
		stmt.close();
	}

	/**
	 * 获得数据库中全部数据
	 * 
	 * @return 查询得到的结果集
	 * @throws SQLException
	 * 
	 */
	public ResultSet getAll() throws SQLException {
		stmt = conn.createStatement();
		String sql = "select * from AlertInfo";

		rs = stmt.executeQuery(sql);
		return rs;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
}
