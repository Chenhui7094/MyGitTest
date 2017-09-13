package com.chen.test2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController.java 
 * @Description:
 * @author chenhuihui
 * @time 2017年9月13日下午3:00:27
 */
@RestController
public class HelloController {
	@RequestMapping("/greeting")
	public String hello(){
		return "Hello World";
	}

}
