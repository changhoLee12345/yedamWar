package com.dev.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {

	public static SqlSessionFactory sessionFactory;

	static {
		String resource = "com/dev/mybatisdb/mybatis-config.xml";
		InputStream inputStream = null;

		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		Configuration config = sessionFactory.getConfiguration();
		System.out.println("config: " + config.getDatabaseId());
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sessionFactory;
	}

}
