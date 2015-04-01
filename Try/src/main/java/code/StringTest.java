/**
 *   _/          _/  _/        _/_/_/    
 *  _/          _/  _/        _/    _/   
 * _/    _/    _/  _/        _/_/_/      
 *  _/  _/  _/    _/        _/    _/     
 *   _/  _/      _/_/_/_/  _/_/_/     
 * 
 * Project: Try
 * 
 * StringTest.java File Created at 下午10:12:26
 * 
 * 
 * Copyright 2014 Taobao.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Taobao Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Taobao.com.
 */
package code;

/**
 * @author <a href="mailto:yinggang.zg@taobao.com">yinggang.zg</a>
 * @version 1.0
 * @since 2014年3月29日
 */
public class StringTest {

	/**
	 * @version 1.0
	 * @param args
	 */
	public static void main(String[] args) {
		// String configInfo = "test";
		// String[] blackTasks = configInfo.split(",");
		// System.out.println(blackTasks);

		// String configInfo = "  test 	ss,a		dsfd\t\n    ";
		// System.out.println(configInfo.replaceAll("\\s+", ""));
		StringBuilder sb = new StringBuilder("LP00021919546736");
		System.out.println(sb.reverse().toString());
	}

}
