package info;

import java.sql.*;
import java.util.ArrayList;

import manage.TextGetter; 

import page.PageBean;

import database.DBConnection;

/**
 * 用于处理通知信息的发布，更新（修改），删除，新闻条目的获取等
 * @author 张广
 *
 */
public class InfoBean {
	
	/**
	 * 获得按发布时间排序（逆序）的前count个通知，时间越近的越靠前
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Info> getTopCountInfo(int count) throws Exception {
		ArrayList<Info> infoList =new ArrayList<Info>();
		
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top "+count+" id,title,createTime from info order by createTime desc");
		
		while(rSet.next()){
			Info info=new Info();
			info.setId(rSet.getInt("id"));
			info.setTitle(rSet.getString("title"));
			info.setCreateTime(rSet.getString("createTime"));
			infoList.add(info);			
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
		
		return infoList;
	}
	
	/**
	 * 查找含指定关键字的所有通知
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Info> searchInfo(String keyword) throws Exception {
		ArrayList<Info> infoList =new ArrayList<Info>();
		
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select id,title,createTime from info where title like '%"
				+ keyword + "%' order by createTime desc");
		
		while(rSet.next()){
			Info info=new Info();
			info.setId(rSet.getInt("id"));
			info.setTitle(rSet.getString("title"));
			info.setCreateTime(rSet.getString("createTime"));
			infoList.add(info);			
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
		
		return infoList;
	}
	
	/**
	 * 获得指定ID的通知
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Info getInfo(int id) throws Exception{
		Info info = new Info();
		
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from info where id="+id);
		
		if(rSet.next()){
			info.setId(rSet.getInt("id"));
			info.setTitle(rSet.getString("title"));
			info.setCreater(rSet.getString("creater"));
			info.setCreateTime(rSet.getString("createTime"));
			info.setModifyTime(rSet.getString("modifyTime"));
			info.setModifyUser(rSet.getString("modifyUser"));
			info.setContent(rSet.getString("infoContent"));
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
		
		return info;
	}
	
	/**
	 * 获得指定ID的通知的作者（用于权限判定）
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String getInfoCreater(int id) throws Exception{
		String creater = null;
		
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select creater from info where id="+id);
		
		if(rSet.next()){

			creater = rSet.getString("creater");
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
		
		return creater;
	}
	
	/**
	 * 返回所有记录的数量
	 * 
	 * @return
	 * @throws Exception
	 */
	private int getTotalInfoCount() throws Exception {
		int count = 0;
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select count(id) from info");
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
	 * 获得指定页面的数据
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
		p.setRecordNum(this.getTotalInfoCount());
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
						+ " no=identity(int,1,1),id*1 as id,title,createTime into #temptable from info order by createTime desc"
						+ " select * from #temptable where no>" + beginIndex
						+ " And no <= " + endIndex + "drop table #temptable");
		
		while (rSet.next()) {
			Info i = new Info();
			i.setId(rSet.getInt("id"));
			i.setTitle(rSet.getString("title"));
			i.setCreateTime(rSet.getString("createTime"));
			p.resultList.add(i);
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
	
	/**
	 * 获得指定页面的数据，每个数据含有不到90字的内容（新闻内容的前90个字符）
	 * 
	 * @param page
	 *            指定的页面数
	 * @param recordPerPage
	 *            每页显示的记录数
	 * @return 含有指定页面数据的PageBean
	 * @throws Exception
	 */
	public PageBean getPageWithContent(int page, int recordPerPage) throws Exception {
		PageBean p = new PageBean();
		p.setRecordNum(this.getTotalInfoCount());
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
						+ " no=identity(int,1,1),id*1 as id,title,creater,createTime,infoContent into #temptable from info order by createTime desc"
						+ " select * from #temptable where no>" + beginIndex
						+ " And no <= " + endIndex + "drop table #temptable");
		
		while (rSet.next()) {
			Info i = new Info();
			i.setId(rSet.getInt("id"));
			i.setTitle(rSet.getString("title"));
			i.setCreater(rSet.getString("creater"));
			i.setCreateTime(rSet.getString("createTime"));
			String contentSummary = TextGetter.getText(rSet.getString("infoContent"));
			if (contentSummary.length() > 90) {
				contentSummary = contentSummary.substring(0, 89) + "...";
			}
			i.setContent(contentSummary);
			p.resultList.add(i);
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
