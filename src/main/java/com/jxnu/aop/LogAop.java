package com.jxnu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  
public class LogAop {  
      
	 //方法执行前调用  
    @Before("execution (* com.jxnu.service.impl.*.*(..))")
    public void before() {  
        System.out.println("AOP方法执行前记录");  
    }  
      
    //方法执行后调用  
    @After("execution (* com.jxnu.service.impl.*.*(..))")
    public void after() {  
        System.out.println("AOP方法执行之后调用");  
    }  
      
    //方法执行的前后调用  
    @Around("execution (* com.jxnu.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable{  
        System.out.println("aop around 方法执行前");  
       
        Object object = point.proceed();  
        
        System.out.println("aop around 方法执行后");  
        return object;  
    }  
      
    //方法运行出现异常时调用  
    @AfterThrowing(pointcut = "execution (* com.jxnu.service.impl.*.*(..))",throwing = "ex")
    public void afterThrowing(Exception ex){  
        System.out.println("afterThrowing");  
        System.out.println(ex);  
    }  
}  