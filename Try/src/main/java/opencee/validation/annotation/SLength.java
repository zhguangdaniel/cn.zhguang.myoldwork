/**
 * 
 */
package opencee.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validate String Length
 * 
 * opencee.validation.annotation.SLength.java
 * 
 * @author wangcheng
 * 
 * @version $Revision:$
 *          $Author:$
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface SLength {
	
	String messageKey() default "";
	
	int max() default 255;
	
	int min() default 0;
}
