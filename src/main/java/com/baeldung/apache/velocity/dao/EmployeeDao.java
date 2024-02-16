package com.baeldung.apache.velocity.dao;

import com.baeldung.apache.velocity.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAllEmployee();

}
