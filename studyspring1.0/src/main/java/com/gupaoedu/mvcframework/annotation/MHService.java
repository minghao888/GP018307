package com.gupaoedu.mvcframework.annotation;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MHService {
    String value() default "";
}

