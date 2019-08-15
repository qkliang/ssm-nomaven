package com.lqk.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author liangqiankun
 * @date 2019年8月13日
 */
public class FastJsonDemo {
	public static void main(String[] args) {
		json2JsonObject();
		System.out.println("---------json2JavaBean---------");
		json2JavaBean();
		System.out.println("---------map2Json---------");
		map2Json();
	}

	/**
	 * 将Json文本数据信息转换为JsonObject对象，然后利用键值对的方式获取信息
	 */
	public static void json2JsonObject() {
		String s = "{\"name\":\"lqk\"}";
		JSONObject jsonObject = JSON.parseObject(s);
		System.out.println(jsonObject.get("name"));
	}

	/**
	 * 将Json文本数据转换为JavaBean数据！ 注意：这时候的Json文本信息中的建的名称必须和JavaBean中的字段名称一样，
	 * 键中没有的在这个JavaBean中就显示为null！
	 */
	public static void json2JavaBean() {
		String s = "{\"id\":\"1001\",\"city\":\"周口郸城\"}";
		City city = JSON.parseObject(s, City.class);
		System.out.println(city.toString());
	}

	/**
	 * 将Map类型的数据转换为JsonString
	 */
	public static void map2Json() {
		Group group = new Group();
		group.setId(1);
		group.setName("group");
		
		User user1 = new User();
		user1.setId(2);
		user1.setName("user1");
		
		User user2 = new User();
		user2.setId(3);
		user2.setName("user2");
		group.getList().add(user1);
		group.getList().add(user2);
		
		Map<Integer,Object> map = new HashMap<Integer,Object>(16);
		map.put(1, "No.1");
		map.put(2, "No.2");
		map.put(3, group.getList());
		
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
	}
}

class Group {
	private int id;
	private String name;
	private List<User> list = new ArrayList<User>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
}

class User {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}

class City {
	private String id;
	private String city;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + "]";
	}

}