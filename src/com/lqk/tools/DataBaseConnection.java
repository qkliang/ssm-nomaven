package com.lqk.tools;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * @author lqk
 * @date 2019/08/12
 */
public class DataBaseConnection {
	private ComboPooledDataSource cpds;
	private Connection conn;
	private static DataBaseConnection instance  = new DataBaseConnection();
	private DataBaseConnection(){
		try {
			cpds = new ComboPooledDataSource();
			Properties props = new Properties();
			InputStream inStream = DataBaseConnection.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			props.load(inStream);
			cpds.setDriverClass(props.getProperty("jdbc.driver"));
			cpds.setJdbcUrl(props.getProperty("jdbc.url"));
			cpds.setUser(props.getProperty("jdbc.username"));
			cpds.setPassword(props.getProperty("jdbc.password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DataBaseConnection getInstance(){
		return instance;
	}
	public void close() throws Exception{
		if(conn != null){
			conn.close();
		}
	}
	public Connection getConn(){
		try {
			
			conn = cpds.getConnection();
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
