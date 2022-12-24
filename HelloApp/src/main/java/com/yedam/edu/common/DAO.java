package com.yedam.edu.common;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DAO {
	public static Connection conn;

	public static Connection connect() {
		Properties prop = new Properties();
		String path = null;
//		path = this.getClass().getResource("/config/db.properties").getPath(); // instance 일 경우(this사용)
		path = DAO.class.getResource("/config/db.properties").getPath(); // static 일 경우(DAO사용)
		System.out.println(path);

		try {
//			path = URLDecoder.decode(path, "UTF-8");
			prop.load(new FileReader(path));
			String url = prop.getProperty("jdbc.url");
			String id = prop.getProperty("jdbc.username");
			String pass = prop.getProperty("jdbc.password");
			Class.forName(prop.getProperty("jdbc.driver"));

			conn = DriverManager.getConnection(url, id, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
