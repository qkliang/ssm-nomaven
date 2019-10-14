package com.lqk.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lqk.mybatis.service.UserService;

/**
 * @author lqk
 * @date 2019/08/11
 */
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@RequestMapping("/selectByName")
	public String selectByName(){
		boolean flag = userService.selectByName();
		String path = "";
		if(flag){
			path = "error";
		}else{
			path = "list";
		}
		return path;
	}
}
