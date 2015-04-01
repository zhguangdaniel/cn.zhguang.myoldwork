/**
 * 
 */
package opencee.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * opencee.validation.annotation.SRegularEx.java
 * 
 * @author wangcheng
 * 
 * @version $Revision:$
 *          $Author:$
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface SRegularEx {
	
	String messageKey() default "";
	
	String regex();
}
