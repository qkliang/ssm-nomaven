package com.lqk.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqk.mybatis.bean.Employee;
import com.lqk.mybatis.dao.EmployeeMapper;

/**
 * @author lqk
 * @date 2019/08/11
 */

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> getEmps(){
		return employeeMapper.getEmps();
	}
}
