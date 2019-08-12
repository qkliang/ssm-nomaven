package com.lqk.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lqk.tools.DataBaseConnection;
/**
 * @author lqk
 * @date 2019/08/12
 */
public class ResultSetMetaDataDemo {
	public static void main(String[] args) throws Exception {
		DataBaseConnection db = DataBaseConnection.getInstance();
		Connection conn = db.getConn();
		String sql = "select id,lastName,gender,email from employee";
		ResultSet rs = conn.createStatement().executeQuery(sql);
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		while(rs.next()){
			Map<String,String> map = new HashMap<String,String>(16);
			for(int i = 1;i<=cols;i++){
				String colName = rsmd.getColumnName(i);
				String value = rs.getString(i);
				map.put(colName, value);
			}
			list.add(map);
		}

//		System.out.println(list);
		for(Map<String,String> map : list){
			System.out.println(map.get("id"));
			System.out.println(map.get("lastName"));
			System.out.println(map.get("gender"));
			System.out.println(map.get("email"));
			System.out.println("------------------------------");
		}
		db.close();
		sql = "select 1+1 from dual";
		rs = db.getConn().createStatement().executeQuery(sql);
		if(rs.next()){
			System.out.println("连接成功");
		}
		db.close();
	}
}
