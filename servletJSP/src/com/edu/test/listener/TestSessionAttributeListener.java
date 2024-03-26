package com.edu.test.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestSessionAttributeListener implements HttpSessionAttributeListener {

	public TestSessionAttributeListener() {
		System.out.println("TestSessionAttributeListener 객체 생성");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("세션 객체에 속성 추가");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("세션 객체에 추가된 속성 삭제");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("세션 객체에 추가된 속성 대체");
	}
}
