package com.ljq.test_springboot.DynamicDataSource.config;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    String name() default "";

}