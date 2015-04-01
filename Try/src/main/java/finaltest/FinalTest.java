/**
 *   _/          _/  _/        _/_/_/    
 *  _/          _/  _/        _/    _/   
 * _/    _/    _/  _/        _/_/_/      
 *  _/  _/  _/    _/        _/    _/     
 *   _/  _/      _/_/_/_/  _/_/_/     
 * 
 * Project: Try
 * 
 * FinalTest.java File Created at 上午1:19:15
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
package finaltest;

/**
 * @author <a href="mailto:yinggang.zg@taobao.com">yinggang.zg</a>
 * @version 1.0
 * @since 2014年3月30日
 */
public class FinalTest {
	public static void main(String hh[]) {
		LoginInfo login = null;
		if (login instanceof LoginInfo) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

		login = new LoginInfo();
		login.setPassword("1235");
		login.setUserName("mygod");
		System.out.println("username:" + login.getUserName() + ",password:" + login.getPassword());
		checkLoginInfo(login);
		System.out.println("username:" + login.getUserName() + ",password:" + login.getPassword());
	}

	public static void checkLoginInfo(final LoginInfo login) {
		int i = Integer.MAX_VALUE;
		System.out.println(i);
		login.setUserName("yun");
	}
}
