package com.xuxianda.mapper;

import com.xuxianda.entity.Employee;

import java.util.List;

/**
 * Created by Xianda Xu on 2018/04/18 09:34.
 */
public interface EmployeeMapper {
    //根据id查询Employee
    Employee selectEmployeeById(Integer id);
    //查询所有Employee
    List<Employee> selectAllEmployee();
    //根据id删除Employee
    void deleteEmployeeById(Integer id);
}
