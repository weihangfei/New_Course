package com.example.administrator.new_course.base;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)//运行时注解
@Target(TYPE)   //作用域
public @interface ViewInject {

    int mainLayoutid() default -1;
}
