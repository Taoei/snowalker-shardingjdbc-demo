package com.snowalker.shardingjdbc.snowalker.demo.shardCommon.dataSourceRoute.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:wangshuo
 * @date：2020/2/4
 * @description: 从库读
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NonShard {
}
