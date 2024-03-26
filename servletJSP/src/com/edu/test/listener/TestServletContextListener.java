package com.edu.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
//<listener>
//<listener-class>com.edu.test.listener.TestServletContextListener</listener-class>
//</listener>

public class TestServletContextListener implements ServletContextListener {

	public TestServletContextListener() {
		System.out.println("TestServletContextListener 객체 생성");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext 객체 초기화");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext 객체 해제");
	}
}
