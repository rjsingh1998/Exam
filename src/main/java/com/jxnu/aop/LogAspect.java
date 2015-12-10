package com.jxnu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class LogAspect {
	
	//日志记录切面，拦截所有进出controller的操作
	@Around("execution(* com.jxnu.controller.*.*(..))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		long now = System.currentTimeMillis();  //now为当前时间
		StringBuffer sb = new StringBuffer();   //新建一个字符串
		sb.append(",class:").append(pjp.getSignature().getDeclaringType()).append(",method:").append(pjp.getSignature().getName());
		Object[] args = pjp.getArgs();
		if (args != null) {
			sb.append(",args:#");
			for (Object arg:args) {
				sb.append(arg).append("#");
			}
		}
		Object obj = null;
		Throwable e = null;
		try {
			obj = pjp.proceed(args);
		} catch (Throwable e1) {
			e = e1;
		}
		sb.insert(0, "time:#" + (System.currentTimeMillis() - now) + "#"); //sb存放的是日志信息，最终会存入日志中
		if (e != null) {
			throw e;
		}
		return obj;
	}
}
