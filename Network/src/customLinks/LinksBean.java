package customLinks;

import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;

/**
 * 用于处理自定义链接的发布，更新（修改），删除，获取等
 * @author 张广 
 *
 */
public class LinksBean {
	
	/**
	 * 获得按发布时间排序的前count个链接
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Link> getTopCountLinks(int count) throws Exception {
		ArrayList<Link> linksList =new ArrayList<Link>();
		
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top "+count+" text,link,createTime from customLinks order by createTime desc");
		
		while(rSet.next()){
			Link l=new Link();			
			l.setText(rSet.getString("text"));
			l.setLink(rSet.getString("link"));
			l.setCreateTime(rSet.getString("createTime"));
			linksList.add(l);			
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
		
		return linksList;
	}
	/**
	 * 获得按发布时间排序的所有链接
	 * @param
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Link> getAllLinks() throws Exception {
		ArrayList<Link> linksList =new ArrayList<Link>();
		
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from customLinks order by createTime desc");
		
		while(rSet.next()){
			Link l=new Link();			
			l.setId(rSet.getInt("id"));
			l.setText(rSet.getString("text"));
			l.setLink(rSet.getString("link"));
			l.setCreateTime(rSet.getString("createTime"));
			l.setCreator(rSet.getString("creator"));
			linksList.add(l);			
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
		
		return linksList;
	}
	
	/**
	 * 获得指定ID的链接
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Link getLink(int id) throws Exception{
		Link l = new Link();
		
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from customLinks where id="+id);
		
		if(rSet.next()){
			l.setId(rSet.getInt("id"));
			l.setText(rSet.getString("text"));
			l.setLink(rSet.getString("link"));
			l.setCreateTime(rSet.getString("createTime"));
			l.setCreator(rSet.getString("creator"));
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
		
		return l;
	}
}
