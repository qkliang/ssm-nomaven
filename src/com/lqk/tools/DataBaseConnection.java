package com.lqk.tools;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataBaseConnection {
	private ComboPooledDataSource cpds;
	private Connection conn;
	public Connection getConn(){
		try {
			cpds = new ComboPooledDataSource();
			Properties props = new Properties();
			InputStream inStream = DataBaseConnection.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			props.load(inStream);
			cpds.setDriverClass(props.getProperty("jdbc.driver"));
			cpds.setJdbcUrl(props.getProperty("jdbc.url"));
			cpds.setUser(props.getProperty("jdbc.username"));
			cpds.setPassword(props.getProperty("jdbc.password"));
			conn = cpds.getConnection();
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
