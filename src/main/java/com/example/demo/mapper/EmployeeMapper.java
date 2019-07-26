package com.example.demo.mapper;

import com.example.demo.bo.Employee;

import java.util.List;

/**
 * create by sunzhongwei on 2019/07/26
 * Desc:
 **/
public interface EmployeeMapper {
    //根据id查询Employee
    Employee selectEmployeeById(Integer id);
    //查询所有Employee
    List<Employee> selectAllEmployee();
    //根据id删除Employee
    void deleteEmployeeById(Integer id);

}
