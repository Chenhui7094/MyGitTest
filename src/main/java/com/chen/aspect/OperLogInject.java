package com.chen.aspect;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @ClassName: OperLogInject.java 
 * @Description:统一操作日志入库注解
 * @author chenhuihui
 * @time 2017年9月13日下午2:12:34
 */
/**
 * 自定义一个注解
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface OperLogInject {

	/** 操作内容 ,这里的value指的是在controller的各个方法上@OperLogInject注解上的value值*/
	String value();

	/** 操作备注 */
	String memo() default "";
}
