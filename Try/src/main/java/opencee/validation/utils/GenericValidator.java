/**
 * 
 */
package opencee.validation.utils;


/**
 * opencee.validation.utils.GenericValidator.java
 * 
 * @author wangcheng
 * @version $Revision:$ $Author:$
 */
public class GenericValidator {

	public static boolean isBlank(Object value) {
		return value == null;
		// || StringUtils.isBlank((String)value);
	}

	public static boolean isNotBlank(Object value) {
		return value != null;
		// && StringUtils.isNotBlank((String)value);
	}

	/**
	 * Validate the value length. Return true if the value is null.
	 * 
	 * @param value
	 * @param max
	 * @param min
	 * @return
	 */
	public static boolean validateLength(Object value, int max, int min) {
		if (value == null) {
			return true;
		}
		int length = value.toString().length();
		// StringUtils.length((String)value);
		return min <= length && length <= max;
	}

	/**
	 * Match the Regular Expression return true if the value is null or the regex is blank.
	 * 
	 * @param value
	 * @param regex
	 * @return
	 */
	public static boolean validateRegularEx(String value, String regex) {
		if (value == null) {
			// || StringUtils.isBlank(regex)) {
			return true;
		}
		return value.matches(regex);
	}
}
