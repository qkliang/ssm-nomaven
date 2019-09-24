package com.lqk.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class RedisDemo {
	public static void main(String[] args) {
	
		Jedis jedis = new Jedis("192.168.56.101");
		Map<String, String> user = jedis.hgetAll("user1");
		for(Map.Entry<String, String> entry : user.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		System.out.println("服务正在运行: "+jedis.ping());
		Iterator<Map.Entry<String, String>> iterator = user.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		Map<String, String> emp = new HashMap<String,String>(16);
		emp.put("id", "0001");
		emp.put("name", "jock");
		jedis.hmset("emp", emp);
		
		
	}
}
