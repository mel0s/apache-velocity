package com.baeldung.apache.velocity.service.impl;

import com.baeldung.apache.velocity.dao.EmployeeDao;
import com.baeldung.apache.velocity.entity.Employee;
import com.baeldung.apache.velocity.entity.Pet;
import com.baeldung.apache.velocity.service.EmployeeServices;
import com.baeldung.apache.velocity.util.HibernateUtil;
import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@ApplicationScoped
public class EmployeeServicesImpl implements EmployeeServices {

    @Inject
    EmployeeDao employeeDao ;
    @Override
    public List<Employee> getAllEmployee() {

        return employeeDao.findAllEmployee();
    }

    @Override
    public List<Pet> getAllPet() {

        return employeeDao.findAllPet();
    }
}
