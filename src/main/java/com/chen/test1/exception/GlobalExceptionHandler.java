package com.chen.test1.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String defaultExceptionHandler(HttpServletRequest request, Exception exception) {
		if (log.isDebugEnabled()) {
			log.debug(exception.getMessage());
		}
		return "sorry,server is beasy";
	}
}
