/**
 *   _/          _/  _/        _/_/_/    
 *  _/          _/  _/        _/    _/   
 * _/    _/    _/  _/        _/_/_/      
 *  _/  _/  _/    _/        _/    _/     
 *   _/  _/      _/_/_/_/  _/_/_/     
 * 
 * Project: Try
 * 
 * GenerateMapping.java File Created at 下午3:28:00
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
 * @since 2014年3月27日
 */
public class GenerateMapping {

	/**
	 * @version 1.0
	 * @param args
	 */
	public static void main(String[] args) {
		int intervals[] = { 2, 5, 5, 30, 30, 60, 60, 300, 600, 600, 1800, 1800, 3600, 3600, 7200, 7200, 86400, 86400,
				86400, 86400 };
		for (int i = 0; i < 20; i++) {
			System.out.println("<mapping>");
			System.out.println("<redocount>" + i + "</redocount>");
			System.out.println("<interval>" + intervals[i] + "</interval>");
			System.out.println("</mapping>");
		}
	}

}
