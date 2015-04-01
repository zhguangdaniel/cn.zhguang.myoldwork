package files;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * 用于处理中文显示问题的类
 * @author hiker
 *
 */
public class EncodeTrans { 
	/**
	 * 处理中文显示问题。
	 * @param str
	 * @return 
	 */
	public static String trans(String str){
		if(str==null || str=="") return str;
		String res=null;
		byte []temp;
		try{
			temp=str.getBytes();
			res=new String(temp,"UTF-8");
		}catch(UnsupportedEncodingException e){
			return "";
		}
		return res;
	}
    public   static   String  encodefileName(String   sFileName)  
    {  
            String sRes=null;
			try {
				sRes = URLEncoder.encode(sFileName,"utf-8");
	            sRes   =   sRes.replace('+',   ' ');  

			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}
            return   sRes;  
    }  
}
