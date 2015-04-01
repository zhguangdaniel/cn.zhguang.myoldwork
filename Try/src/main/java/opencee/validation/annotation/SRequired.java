/**
 * 
 */
package opencee.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validate String Required
 * 
 * opencee.validation.annotation.SRequired.java
 * 
 * @author wangcheng
 * 
 * @version $Revision:$
 *          $Author:$
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface SRequired {
	
	String messageKey() default "";
}
