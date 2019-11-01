package com.duker.core.annotation;

import java.lang.annotation.*;

/**
 * 自定义验证注解
 * @author xiebq
 * @desc
 * @create 2019/10/18 0018
 * @since 1.0.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Security {
    public boolean value() default true;
}
