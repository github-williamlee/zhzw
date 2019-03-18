package com.oracle.hrb.zhzw.demo;

import java.lang.annotation.*;

@Documented// 可以生成文档的
@Inherited// 可以被继承的
@Target({ElementType.METHOD, ElementType.TYPE})// 注解可以使用范围
@Retention(RetentionPolicy.RUNTIME)// 注解的生命周期
public @interface MyRequestMapping {
    String[] value();
    String[] method() default {};
}
