package com.gupaoedu.framework.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MHAutowired {
    String value() default "";
}
