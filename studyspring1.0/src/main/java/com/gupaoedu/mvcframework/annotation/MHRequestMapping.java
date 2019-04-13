package com.gupaoedu.mvcframework.annotation;

import java.lang.annotation.*;
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MHRequestMapping {
    String value() default "";
}
