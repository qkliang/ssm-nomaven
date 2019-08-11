package com.lqk.mybatis.dao;

import java.util.List;

import com.lqk.mybatis.bean.Employee;

/**
 * @author lqk
 * @date 2019/08/11
 */
public interface EmployeeMapper {
	public List<Employee> getEmps();
}
