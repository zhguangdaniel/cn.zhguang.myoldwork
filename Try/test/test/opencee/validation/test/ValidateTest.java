/**
 * 
 */
package test.opencee.validation.test;

import java.util.List;

import opencee.validation.utils.ValidationUtils;

/**
 * opencee.validation.test.ValidateTest.java
 * 
 * @author wangcheng
 * @version $Revision:$ $Author:$
 */
public class ValidateTest {

	public static void main(String[] args) {
		UserBean user = new UserBean();
		List<String> messageList = ValidationUtils.validate(user);

		for (String s : messageList) {
			System.out.println(s);
		}
	}
}
