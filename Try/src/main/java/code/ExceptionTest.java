/**
 *   _/          _/  _/        _/_/_/    
 *  _/          _/  _/        _/    _/   
 * _/    _/    _/  _/        _/_/_/      
 *  _/  _/  _/    _/        _/    _/     
 *   _/  _/      _/_/_/_/  _/_/_/     
 * 
 * Project: Try
 * 
 * ExceptionTest.java File Created at 下午11:27:45
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
public class ExceptionTest {
	public void testException() {
		int a = 0;
		int b = 5;
		int c = b / a;

		System.out.println(c);
	}

	public static String buildExceptionInfo(Exception e) {
		StringBuilder sb = new StringBuilder();
		sb.append(e.getClass().getName()).append(" : ");
		sb.append(e.getLocalizedMessage());
		StackTraceElement stackTraceElement = e.getStackTrace()[0];
		sb.append("[").append(stackTraceElement.toString()).append("]");
		return sb.toString();
	}

	/**
	 * @version 1.0
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ExceptionTest test = new ExceptionTest();
			test.testException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getClass().getName());
			StackTraceElement stackTraceElement = e.getStackTrace()[0];// 得到异常棧的首个元素
			System.out.println("Class=" + stackTraceElement.getClassName());
			System.out.println("File=" + stackTraceElement.getFileName());// 打印文件名
			System.out.println("Line=" + stackTraceElement.getLineNumber());// 打印出错行号
			System.out.println("Method=" + stackTraceElement.getMethodName());// 打印出错方法
			System.out.println(stackTraceElement.toString());
			System.out.println(ExceptionTest.buildExceptionInfo(e));
		}
	}

}
