package com.baeldung.apache.velocity.dao;

import com.baeldung.apache.velocity.entity.Employee;
import com.baeldung.apache.velocity.entity.Pet;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAllEmployee();

    public List<Pet> findAllPet();

}
