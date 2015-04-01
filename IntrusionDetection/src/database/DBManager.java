package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import jpcap.packet.Packet;

/**
 * 
 * @author �Ź�
 * 
 */
public class DBManager {

	/**
	 * ��ǰ�����ݿ����ӣ�������ʱΪnull
	 */
	public Connection conn = null;

	/**
	 * ��ǰ�Ĳ�ѯ��䣬����Ϊnull
	 */
	public Statement stmt = null;

	/**
	 * ��ǰ�Ľ����������Ϊnull
	 */
	public ResultSet rs = null;

	/**
	 * JDBC����������
	 * 
	 * �����sql server 2005��dirvername
	 * Ϊ��"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 * 
	 * �����sql server 2000��dirvername
	 * Ϊ��"com.microsoft.jdbc.sqlserver.SQLServerDriver";
	 */
	public String driverName = null;// ���ݿ�����

	/**
	 * ���ݿ�����ͣ�IP���˿ڣ����ݿ����ơ� �����sql server 2005��url
	 * Ϊ��"jdbc:sqlserver://localhost:1433;DatabaseName=IDS"�� �����sql server
	 * 2000��url Ϊ��"jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=IDS"��
	 * ����ֻ�Ǿ�����IP���˿ڣ����ݿ����ƶ��ǿ��Ըı�ġ�
	 * 
	 */
	public String url = null;// ���ݿ��ַ

	/**
	 * ���ݿ��û���
	 */
	public String username = null;

	/**
	 * ���ݿ�����
	 */
	public String password = null;

	/**
	 * ��ʼ���� ͬʱ��"./data/defaultDatabase.ini"�ж���Ĭ�ϵ� �����ϴα���ģ����ݿ���������
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

			// �������URL��
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
	 * �������ݿ����ӣ�����֮ǰ�����Ѿ���������ȷ��driverName,url,username,password
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
	 * �����ݿ������һ��
	 * 
	 * @param index
	 *            ���к�
	 * @param p
	 *            Ҫ��ӵİ�
	 * @param rule
	 *            ƥ��Ĺ���
	 * @param result
	 *            ����Ľ��
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
	 * ���AlertInfo���ݿ�
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
	 * ִ��ָ����sql��䣬�������κ�����
	 * 
	 * @param sql
	 *            Ҫִ�е�sql���
	 * @throws SQLException
	 */
	public void execute(String sql) throws SQLException {
		stmt = conn.createStatement();
		stmt.execute(sql);
		stmt.close();
	}

	/**
	 * ������ݿ���ȫ������
	 * 
	 * @return ��ѯ�õ��Ľ����
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
	 * �ر����ݿ�����
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
