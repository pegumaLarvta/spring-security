package com.john.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
* @author 作者 john
* @version 创建时间：2019年4月13日 下午6:20:41
*/
//@Aspect
//@Component
public class TimeAspect {

//	@Around("execution(* com.john.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("time aspect start");
		
		Object[] args = pjp.getArgs();
		for(Object arg : args) {
			System.out.println("arg is " + arg);
		}
		
		long start = new Date().getTime();
		
		Object object = pjp.proceed();
		
		System.out.println("time aspect 耗时：" + (new Date().getTime() - start));
		
		System.out.println("time aspect end");
		
		return object;
	}
	
}
