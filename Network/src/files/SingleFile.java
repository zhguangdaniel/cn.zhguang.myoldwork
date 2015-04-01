package files;

/**
 * @author 张广 
 *
 */
public class SingleFile {
	//属性
	private int id;
	private String name;
	private String type;
	private int size;
	private String uploadtime;	
	private String storeName;
	private String description;
	private String creator;
	
	//getter方法
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public String getUploadtime(){
		return this.uploadtime;
	}
	
	public String getStoreName(){
		return this.storeName;
	}
	public String getDescription(){
		return this.description;
	}
	
	//setter方法
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public void setUploadtime(String uploadtime){
		this.uploadtime = uploadtime;
	}
	
	public void setStoreName(String storeName){
		this.storeName = storeName;
	}
	public void setDescription(String description){
		this.description = description;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreator() {
		return creator;
	}

}
