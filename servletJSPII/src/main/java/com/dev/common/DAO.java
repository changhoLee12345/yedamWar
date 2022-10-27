package com.dev.common;

import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {
	public Connection conn;
	public ResultSet rs;
	public PreparedStatement psmt;

	public Connection connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();

		} catch (NamingException | SQLException e) {

			Properties prop = new Properties();
			String path = null;
			path = "C:/Temp/database.properties";
			System.out.println(path);

			try {
				path = URLDecoder.decode(path, "UTF-8");
				prop.load(new FileReader(path));
				String url = prop.getProperty("url");
				String id = prop.getProperty("user");
				String pass = prop.getProperty("passwd");
				Class.forName(prop.getProperty("driver"));

				conn = DriverManager.getConnection(url, id, pass);
				System.out.println("connected.");

			} catch (ClassNotFoundException | SQLException | IOException e1) {
				e1.printStackTrace();
			}

		}
		return conn;

	}

	public void disconnect() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
