package com.jxnu.util;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		// 获取容器信息
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		System.out.println(ac.getStartupDate());
		System.out.println("web启动，监听器开始运行");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("方法执行");
	}
}
