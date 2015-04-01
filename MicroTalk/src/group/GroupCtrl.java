package group;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.DBConnection;

/**
 * @author 张广
 *
 */
public class GroupCtrl {
	/**
	 * 获得按人数排序的前count个部落
	 * 
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Group> getMostAttentionUsers(int count) throws Exception {
		ArrayList<Group> groupList = new ArrayList<Group>();

		Connection con = new DBConnection().getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("select top " + count
				+ " id,groupName,groupIconPath from groups order by memberNum desc");
		while (rSet.next()) {
			Group g = new Group();
			g.setId(rSet.getInt("id"));
			g.setGroupName(rSet.getString("groupName"));
			g.setGroupIconPath(rSet.getString("groupIconPath"));
			groupList.add(g);
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

		return groupList;
	}
}
