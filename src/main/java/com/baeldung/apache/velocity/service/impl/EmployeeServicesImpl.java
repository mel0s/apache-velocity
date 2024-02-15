package com.baeldung.apache.velocity.service.impl;

import com.baeldung.apache.velocity.entity.Employee;
import com.baeldung.apache.velocity.service.EmployeeServices;
import com.baeldung.apache.velocity.util.HibernateUtil;
import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@ApplicationScoped
public class EmployeeServicesImpl implements EmployeeServices {
    @Override
    public List<Employee> getAllEmployee() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employee", Employee.class).list();
        }

    }
}
