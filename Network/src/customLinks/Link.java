package customLinks;

/**
 * 用于表示自定义链接的javaBean
 * @author 张广
 *
 */
public class Link {
	//属性
	private int id;
	private String text;
	private String link;
	private String createTime;
	private String creator;
	
	//setter方法
	public void setId(int id){
		this.id = id;
	}
	public void setText(String text){
		this.text = text;
	}
	public void setLink(String link){
		this.link = link;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	
	//getter方法
	public int getId(){
		return this.id;
	}
	public String getText(){
		return this.text;
	}
	public String getLink(){
		return this.link;
	}
	public String getCreateTime(){
		return this.createTime;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreator() {
		return creator;
	}

}
