package com.gupaoedu.framework.annotation;


import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MHController {
    String value() default "";
}
