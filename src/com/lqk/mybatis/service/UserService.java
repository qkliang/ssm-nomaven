package com.lqk.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqk.mybatis.bean.User;
import com.lqk.mybatis.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	public boolean selectByName(){
		boolean flag = false;
		User user =  userMapper.selectByName();
		if(user != null){
			flag = true;
		}
		return flag;
	}
}
