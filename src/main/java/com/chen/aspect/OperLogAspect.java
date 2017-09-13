package com.chen.aspect;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chen.bean.OperateLog;
import com.chen.dao.OperLogDao;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: OperLogAspect.java 
 * @Description:操作日志切面操作
 * @author chenhuihui
 * @time 2017年9月13日下午2:14:19
 */
@Aspect
@Component
@Slf4j
public class OperLogAspect {

	@Autowired
	private OperLogDao operLogDao;

	@Autowired
	private HttpServletRequest request;

	/** 设置日志注解的切点  也就是说在哪个方法里面添加@OperLogInject注解 */
	@Pointcut(value = "@annotation(logInject)", argNames = "logInject")
	public void serviceAspect(OperLogInject logInject) {

	}

	/** 方法结束后调用    在controller的添加@OperLogInject的方法结束后调用此方法*/
	@After(value = "serviceAspect(logInject)", argNames = "logInject")
	public void doAfter(JoinPoint joinPoint, OperLogInject logInject) {

		try {
			OperateLog operLog = new OperateLog();
			// IP地址+端口号
			operLog.setIp(request.getRemoteAddr() + ":" + request.getRemotePort());
			// 操作人ID 测试用从session或request取，实际哪里取待定
			// Optional.ofNullable(request.getSession().getAttribute("loginId"))
			// .ifPresent(x -> operLog.setAccountId((Integer) x));
			Optional.ofNullable(request.getParameter("loginId"))
					.ifPresent(x -> operLog.setAccountId(Integer.valueOf(x)));

			// 操作日志内容
			operLog.setContent(logInject.value());
			// 操作时间
			operLog.setOtime(new Date());
			// 操作日志备注
			operLog.setMemo(logInject.memo());

			// 数据库插入操作日志信息
			operLogDao.insertOperLog(operLog);
		} catch (Exception e) {
			log.error("操作日志入库异常：");
		}
	}

}
