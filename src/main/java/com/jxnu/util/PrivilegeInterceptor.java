package com.jxnu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class PrivilegeInterceptor extends HandlerInterceptorAdapter {
	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截器回调执行");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("调用controller后进入");
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("拦截器拦截开始：");
		System.out.println(request.getRequestURI().toString());
		System.out.println("" + arg2.getClass().getCanonicalName());
		System.out.println(arg2.getClass().getSimpleName());
		return true;
	}
}
