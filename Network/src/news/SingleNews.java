package news;

/**
 * 用于表示新闻信息的javaBean
 * @author 张广
 *
 */
public class SingleNews { 
	//属性
	private int id;
	private String title;
	private String creater;
	private String createTime;
	private String modifyTime;
	private String modifyUser;
	private String content;
	
	//setter方法
	public void setId(int id){
		this.id = id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setCreater(String creater){
		this.creater = creater;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public void setModifyTime(String modifyTime){
		this.modifyTime = modifyTime;
	}
	public void setModifyUser(String modifyUser){
		this.modifyUser = modifyUser;
	}
	public void setContent(String content){
		this.content = content;
	}
	
	//getter方法
	public int getId(){
		return this.id;
	}
	public String getTitle(){
		return this.title;
	}
	public String getCreater(){
		return this.creater;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	public String getModifyTime(){
		return this.modifyTime;
	}
	public String getModifyUser(){
		return this.modifyUser;
	}
	public String getContent(){
		return this.content;
	}
}
