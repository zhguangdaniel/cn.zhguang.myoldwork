package news;

import java.sql.*;
import java.util.ArrayList;

import database.DBConnection;
import page.PageBean;
import manage.TextGetter;

/**
 * 用于处理News的发布，更新（修改），删除，新闻条目的获取等
 * 
 * @author 张广
 * 
 */
public class NewsBean {

	/**
	 * 获得按发布时间排序的前count个新闻
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SingleNews> getTopCountNews(int count) throws Exception {
		ArrayList<SingleNews> newsList = new ArrayList<SingleNews>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top " + count
				+ " id,title,createTime from news order by createTime desc");

		while (rSet.next()) {
			SingleNews aNews = new SingleNews();
			aNews.setId(rSet.getInt("id"));
			aNews.setTitle(rSet.getString("title"));
			aNews.setCreateTime(rSet.getString("createTime"));
			newsList.add(aNews);
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

		return newsList;
	}
	/**
	 * 查找具有指定关键字的所有新闻
	 * 
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SingleNews> searchNews(String keyword) throws Exception {
		ArrayList<SingleNews> newsList = new ArrayList<SingleNews>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select id,title,createTime from news where title like '%"
		+ keyword + "%'  order by createTime desc");
		while (rSet.next()) {
			SingleNews aNews = new SingleNews();
			aNews.setId(rSet.getInt("id"));
			aNews.setTitle(rSet.getString("title"));
			aNews.setCreateTime(rSet.getString("createTime"));
			newsList.add(aNews);
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

		return newsList;
	}

	/**
	 * 获得指定ID的新闻
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SingleNews getNews(int id) throws Exception {
		SingleNews news = new SingleNews();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from news where id=" + id);

		if (rSet.next()) {
			news.setId(rSet.getInt("id"));
			news.setTitle(rSet.getString("title"));
			news.setCreater(rSet.getString("creater"));
			news.setCreateTime(rSet.getString("createTime"));
			news.setModifyTime(rSet.getString("modifyTime"));
			news.setModifyUser(rSet.getString("modifyUser"));
			news.setContent(rSet.getString("newsContent"));
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

		return news;
	}
	
	/**
	 * 获得指定ID的新闻的作者（用于权限判断）
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String getNewsCreater(int id) throws Exception {
		String creater = null;
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select creater from news where id=" + id);

		if (rSet.next()) {
			creater = rSet.getString("creater");
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

		return creater;
	}

	/**
	 * 返回所有记录的数量
	 * 
	 * @return
	 * @throws Exception
	 */
	private int getTotalNewsCount() throws Exception {
		int count = 0;
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select count(id) from news");
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
		p.setRecordNum(this.getTotalNewsCount());
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
						+ " no=identity(int,1,1),id*1 as id,title,createTime into #temptable from  news order by createTime desc"
						+ " select * from #temptable where no>" + beginIndex
						+ " And no <= " + endIndex + "drop table #temptable");
		
		while (rSet.next()) {
			SingleNews aNews = new SingleNews();
			aNews.setId(rSet.getInt("id"));
			aNews.setTitle(rSet.getString("title"));
			aNews.setCreateTime(rSet.getString("createTime"));
			p.resultList.add(aNews);
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
		p.setRecordNum(this.getTotalNewsCount());
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
						+ " no=identity(int,1,1),id*1 as id,title,creater,createTime,newsContent into #temptable from  news order by createTime desc"
						+ " select * from #temptable where no>" + beginIndex
						+ " And no <= " + endIndex + "drop table #temptable");
		
		while (rSet.next()) {
			SingleNews aNews = new SingleNews();
			aNews.setId(rSet.getInt("id"));
			aNews.setTitle(rSet.getString("title"));
			aNews.setCreater(rSet.getString("creater"));
			aNews.setCreateTime(rSet.getString("createTime"));
			String contentSummary = TextGetter.getText(rSet.getString("newsContent"));
			if (contentSummary.length() > 90) {
				contentSummary = contentSummary.substring(0, 89) + "...";
			}
			aNews.setContent(contentSummary);
			p.resultList.add(aNews);
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
