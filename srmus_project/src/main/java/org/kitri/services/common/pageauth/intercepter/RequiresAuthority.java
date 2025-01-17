package org.kitri.services.common.pageauth.intercepter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresAuthority {
	String basicServiceId() default "";
	String editServiceId() default "";
	String value()  default "";
}
