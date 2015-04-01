package page;

import java.util.ArrayList;

/**
 * @author 张广
 * 
 */
public class PageBean {

	// 属性
	private int curPage;// 当前是第几页
	
	private int maxPage;// 一共多少页（最大页数）
	
	private int recordPerPage;// 每页显示的记录数

	private int recordNum;// 总记录数

	public ArrayList<Object> resultList = new ArrayList<Object>();// 结果表，

	// getter方法
	public int getCurPage() {
		return this.curPage;
	}

	public int getMaxPage() {
		return this.maxPage;
	}

	public int getRecordPerPage() {
		return this.recordPerPage;
	}

	public int getRecordNum() {
		return this.recordNum;
	}

	// setter方法：
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}

	// 其它方法
	/**
	 * 计算最大页数，要求总记录数recordNum已知
	 */
	public void countMaxPage() {
		if (this.recordNum % this.recordPerPage == 0)
			this.maxPage = this.recordNum / this.recordPerPage;
		else
			this.maxPage = this.recordNum / this.recordPerPage + 1;
		if (this.maxPage == 0)
			maxPage = 1;// recordNum=0的情况下，也要有1页，虽然这一页没有数据
	}

	/**
	 * 输出分页控制条
	 * 
	 */
	public String printCtrl() {
		String strHtml = "";

		strHtml += "<table width=\"100%\" height=\"20px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
				+ "<tr>\r\n" + "<td height=\"20px\" align=\"center\">\r\n";

		int i = curPage - (curPage - 1) % 10;
		int end = 9 + curPage - (curPage - 1) % 10;
		if (maxPage < end)
			end = maxPage;
		if (curPage == 1) {
			strHtml += "<span id=\"blackText\">首页&nbsp;</span>\r\n";
		} else if (curPage > 1) {
			strHtml += "<a href=\"?page=1\" target=\"_self\" class=\"blueText\">首页&nbsp;</a>\r\n";
		}
		if (curPage <= 10) {
			strHtml += "<span id=\"blackText\">&nbsp;前10页&nbsp;</span>\r\n";
		} else {
			strHtml += "<a href=\"?page="
					+ (i - 10)
					+ "\" target=\"_self\" class=\"blueText\">&nbsp;前10页&nbsp;</a>\r\n";
		}
		while (i <= end) {
			if (i == curPage) {

				strHtml += "\r\n" + "\t\t<span id=\"blackText\">&nbsp;" + i
						+ "&nbsp;</span>\r\n" + "\t\t";
			} else {

				strHtml += "\r\n" + "\t\t<a href=\"?page=" + i
						+ "\" target=\"_self\" class=\"blueText\">&nbsp;" + i
						+ "&nbsp;</a>\r\n" + "\t\t";
			}
			i++;
		}
		if (maxPage <= end) {
			strHtml += "<span id=\"blackText\">&nbsp;后10页&nbsp;</span>\r\n";
		} else {
			strHtml += "<a href=\"?page="
					+ (end + 1)
					+ "\" target=\"_self\" class=\"blueText\">&nbsp;后10页&nbsp;</a>\r\n";
		}
		if (curPage == maxPage) {
			strHtml += "<span id=\"blackText\">&nbsp;末页</span>\r\n";
		} else if (curPage < maxPage) {
			strHtml += "<a href=\"?page=" + maxPage
					+ "\" target=\"_self\" class=\"blueText\">&nbsp;末页</a>\r\n";
		}
		strHtml += "\r\n" + "</td>\r\n" + "</tr>\r\n" + "</table>\r\n";

		return strHtml;
	}

}
