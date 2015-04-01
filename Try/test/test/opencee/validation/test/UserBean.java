/**
 * 
 */
package test.opencee.validation.test;

import opencee.validation.annotation.SLength;
import opencee.validation.annotation.SRegularEx;
import opencee.validation.annotation.SRequired;
import opencee.validation.utils.RegPatterns;

/**
 * opencee.validation.test.UserBean.java
 * 
 * @author wangcheng
 * @version $Revision:$ $Author:$
 */
public class UserBean {

	private String userName;

	private String password;

	private String email;

	@SRequired(messageKey = "Name is required.")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@SRequired(messageKey = "Password is required.")
	@SLength(min = 6, max = 20, messageKey = "Password is 6 - 20")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SRegularEx(regex = RegPatterns.EMAIL, messageKey = "Please input a valid email.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
