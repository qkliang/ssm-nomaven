package com.lqk.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * 推荐：
 *	使用 entrySet 遍历 Map 类集合 KV，而不是 keySet 方式进行遍历。
 *	说明： keySet 其实是遍历了 2 次，一次是转为 Iterator 对象，另一次是从 hashMap 中取出key 所对应的 value。
 *		而 entrySet 只是遍历了一次就把 key 和 value 都放到了 entry 中，效率更高。
 *	如果是 JDK8，使用 Map.foreach 方法。
 *	正例： values()返回的是 V 值集合，是一个 list 集合对象； keySet()返回的是 K 值集合，是一个 Set 集合对象； entrySet()返回的是 K-V 值组合集合 
 * 
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>(16);
		map.put("id", "001");
		map.put("name", "lqk");
		map.put("age", "23");
		map.put("email", "qkliang@foxmail.com");
		
		System.out.println(map.keySet());
		 //获取所有的 key，根据 key 取出对应的value
		for(String key : map.keySet()){
			System.out.println("key:" + key + ",value:" + map.get(key));
		}
		
		System.out.println("------ 获取map种所有的value：map.values() ------");
		//遍历所有的value
		for(String value : map.values()){
			System.out.println("value:"+ value);
		}
		
		System.out.println("------ 获取键值对：map.entrySet() ------");
		//取出对应的 key，value 键值对,容量大时推荐使用
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println("键值对：" + entry);
			System.out.println("key:" + entry.getKey());
			System.out.println("value:" + entry.getValue());
		}
		System.out.println("------ 通过 Map.entrySet使用iterator遍历 key 和 value ------");
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> entry = iterator.next();
			System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
		}
		System.out.println("------ map.forEach JDK1.8 新特性 ------");
		
		map.forEach((key,value)->{
			System.out.println("key=" +key+",value ="+value);
		});
		
		
	}
}
