/**
 * 
 */
package opencee.validation.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import opencee.validation.annotation.SLength;
import opencee.validation.annotation.SRegularEx;
import opencee.validation.annotation.SRequired;

/**
 * opencee.validation.utils.ValidationUtils.java
 * 
 * @author wangcheng
 * @version $Revision:$ $Author:$
 */
public class ValidationUtils {

	/**
	 * @param bean
	 * @return True if the bean is validate.
	 */
	public static boolean isValidate(Object bean) {
		return validate(bean).size() == 0;
	}

	/**
	 * @param bean
	 * @return Error Message List.
	 */
	public static List<String> validate(Object bean) {
		assert bean != null;

		List<String> messageList = new ArrayList<String>();

		validateMethods(bean, messageList);

		// validateFields(bean, messageList);

		return messageList;
	}

	private static void validateMethods(Object bean, List<String> messageList) {
		// get all of public methods
		Method[] publicMethods = bean.getClass().getMethods();
		for (Method method : publicMethods) {
			// ignore if it is not getXXX method
			if (!isGetterMethod(method)) {
				continue;
			}
			Object value = null;
			try {
				value = method.invoke(bean, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Annotation[] annotations = method.getDeclaredAnnotations();
			Annotation[] annotations = method.getAnnotations();
			for (Annotation annotation : annotations) {
				validateAnnotation(value, annotation, messageList);
			}
		}
	}

	private static boolean isGetterMethod(Method method) {
		if (method == null) {
			return false;
		}
		String methodName = method.getName();
		return methodName.startsWith("get");
	}

	/**
	 * @param bean
	 * @param messageList
	 */
	private static void validateFields(Object bean, List<String> messageList) {
		Field[] declaredFieldArray = bean.getClass().getDeclaredFields();
		for (Field field : declaredFieldArray) {
			Object fieldValue = null;
			if (field != null) {
				try {
					field.setAccessible(true);
					fieldValue = field.get(bean);
				} catch (Exception e) {
					//
				}
				Annotation[] annotations = field.getAnnotations();
				for (Annotation annotation : annotations) {
					validateAnnotation(fieldValue, annotation, messageList);
				}
			}
		}
	}

	private static void validateAnnotation(Object value, Annotation annotation, List<String> messageList) {

		if (annotation instanceof SRequired) {
			validateRequired(value, (SRequired) annotation, messageList);
		} else if (annotation instanceof SLength) {
			validateLength(value, (SLength) annotation, messageList);
		} else if (annotation instanceof SRegularEx) {
			validateRegularEx(value, (SRegularEx) annotation, messageList);
		}
	}

	private static void validateRegularEx(Object value, SRegularEx annotation, List<String> messageList) {

		if (!GenericValidator.validateRegularEx((String) value, annotation.regex())) {
			messageList.add(annotation.messageKey());
		}
	}

	private static void validateLength(Object value, SLength annotation, List<String> messageList) {

		if (!GenericValidator.validateLength(value, annotation.max(), annotation.min())) {
			messageList.add(annotation.messageKey());
		}
	}

	private static void validateRequired(Object value, SRequired annotation, List<String> messageList) {

		if (GenericValidator.isBlank(value)) {
			messageList.add(annotation.messageKey());
		}
	}

}
