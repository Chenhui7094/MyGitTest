package com.chen.test1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName: WebMvcConfig.java 
 * @Description:WEB配置
 * @author chenhuihui
 * @time 2017年9月13日下午2:33:33
 */
@Configuration
public class WebMvcConfig {

	@Bean
	public WebMvcConfigurer mvcConfigurer() {
		return new WebMvcConfigurerAdapter() {
			/** 跨域配置 */
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")// 1 设置访问源地址
						.allowedHeaders("*")// 2 设置访问源请求头
						.allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")// 3 设置访问源请求方法
						.allowCredentials(true).maxAge(3600);
			}

			/** 自定义拦截器配置 
			 * addPathPatterns 用于添加拦截规则
			 * excludePathPatterns 用户排除拦截
			 */
			// @Override
			// public void addInterceptors(InterceptorRegistry registry) {
			// // 注册拦截器
			// InterceptorRegistration ir = registry.addInterceptor(new
			// LoginInterceptor());
			// // 配置拦截的路径
			// ir.addPathPatterns("/**");
			// // 配置不拦截的路径
			// // 登录接口
			// ir.excludePathPatterns("/account/login");
			// // swagger
			// ir.excludePathPatterns("/webjars/**", "/swagger-resources/**");
			//
			// }

		};
	}
}
