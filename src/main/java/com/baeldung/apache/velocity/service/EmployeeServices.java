package com.baeldung.apache.velocity.service;


import com.baeldung.apache.velocity.entity.Employee;


import javax.enterprise.context.ApplicationScoped;
import java.util.List;


@ApplicationScoped
public  interface EmployeeServices {
    public List<Employee> getAllEmployee();

}