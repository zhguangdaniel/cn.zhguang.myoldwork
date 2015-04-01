package database;

import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * 处理数据库连接，查询，关闭等任务的类，连接到SQL server 2005,没有使用连接池技术。
 * 
 * @author 张广 
 * 
 */
public class DBConnection {

	/**
	 * SQL server 2005的JDBC驱动的名字
	 */
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// 数据库驱动

	/**
	 * 数据库的类型，IP，端口，数据库名
	 */
	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=network";// 数据库地址

	/**
	 * 数据库用户名
	 */
	private static String username = "administrator";

	/**
	 * 数据库密码
	 */
	private static String password = "123456";

	private String propFileName = "/database.properties";

	private Properties prop = new Properties();

	public DBConnection() throws Exception {
		// 从属性文件database.properties中读入数据库信息到InputStream对象in中
		InputStream in = getClass().getResourceAsStream(propFileName);
		prop.load(in);
		driverName = prop.getProperty("DB_DRIVER_NAME");
		url = prop.getProperty("DB_URL");
		username = prop.getProperty("DB_USER");
		password = prop.getProperty("DB_PWD");

	}

	/**
	 * 建立默认的数据库连接
	 * 
	 * @return 如果连接成功返回Connection对象，否则返回null;
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Class.forName(driverName).newInstance();
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
}
