package files;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import page.PageBean;
import database.DBConnection;

/**
 * 用于获得文件列表，获取文件等
 * @author 张广
 *
 */
public class FilesBean { 
	
	/**
	 * 获得按发布时间逆序排列（最近发布的在前）的前count个文件
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SingleFile> getTopCountFiles(int count) throws Exception {
		ArrayList<SingleFile> filesList = new ArrayList<SingleFile>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top " + count
				+ " * from files order by uploadTime desc");

		while (rSet.next()) {
			SingleFile f = new SingleFile();
			f.setId(rSet.getInt("id"));
			f.setName(rSet.getString("name"));
			f.setType(rSet.getString("type"));
			f.setSize(rSet.getInt("size"));
			f.setUploadtime(rSet.getString("uploadTime"));
			f.setStoreName(rSet.getString("storeName"));
			f.setDescription(rSet.getString("description"));
			f.setCreator(rSet.getString("creator"));
			filesList.add(f);
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

		return filesList;
	}
	
	/**
	 * 查找含指定关键字的所有文件
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<SingleFile> searchFiles(String keyword) throws Exception {
		ArrayList<SingleFile> filesList = new ArrayList<SingleFile>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from files where name like '%"
				+ keyword + "%' order by uploadTime desc");

		while (rSet.next()) {
			SingleFile f = new SingleFile();
			f.setId(rSet.getInt("id"));
			f.setName(rSet.getString("name"));
			f.setType(rSet.getString("type"));
			f.setSize(rSet.getInt("size"));
			f.setUploadtime(rSet.getString("uploadTime"));
			f.setStoreName(rSet.getString("storeName"));
			f.setDescription(rSet.getString("description"));
			f.setCreator(rSet.getString("creator"));
			filesList.add(f);
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

		return filesList;
	}


	/**
	 * 获得指定ID的文件
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SingleFile getFile(int id) throws Exception {
		SingleFile f = new SingleFile();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from files where id=" + id);

		if (rSet.next()) {
			f.setId(rSet.getInt("id"));
			f.setName(rSet.getString("name"));
			f.setType(rSet.getString("type"));
			f.setSize(rSet.getInt("size"));
			f.setUploadtime(rSet.getString("uploadTime"));
			f.setStoreName(rSet.getString("storeName"));
			f.setDescription(rSet.getString("description"));
			f.setCreator(rSet.getString("creator"));
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

		return f;
	}

	/**
	 * 返回所有记录的数量
	 * 
	 * @return
	 * @throws Exception
	 */
	private int getTotalFilesCount() throws Exception {
		int count = 0;
		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select count(id) from files");
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
		p.setRecordNum(this.getTotalFilesCount());
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
						+ " no=identity(int,1,1),id*1 as id,name,type,size,uploadTime,storeName,description,creator into #temptable from  files order by uploadTime desc"
						+ " select * from #temptable where no>" + beginIndex
						+ " And no <= " + endIndex + "drop table #temptable");
		
		while (rSet.next()) {
			SingleFile f = new SingleFile();
			f.setId(rSet.getInt("id"));
			f.setName(rSet.getString("name"));
			f.setType(rSet.getString("type"));
			f.setSize(rSet.getInt("size"));
			f.setUploadtime(rSet.getString("uploadTime"));
			f.setStoreName(rSet.getString("storeName"));
			f.setDescription(rSet.getString("description"));
			f.setCreator(rSet.getString("creator"));
			p.resultList.add(f);
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
