package com.lqk.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	@org.junit.Test
	public void test() {
		Map<String,String> map = new HashMap<String,String>(16);
		map.put("id", "001");
		map.put("name", "lqk");
		map.put("email", "qkliang@foxmail.com");
		
		for(Map.Entry<String, String> m : map.entrySet()){
			System.out.println(m.getKey() + m.getValue());
		}
		
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String,String> entry = iterator.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
