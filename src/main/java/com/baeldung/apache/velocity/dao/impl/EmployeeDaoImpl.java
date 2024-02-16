package com.baeldung.apache.velocity.dao.impl;

import com.baeldung.apache.velocity.dao.EmployeeDao;
import com.baeldung.apache.velocity.entity.Employee;
import com.baeldung.apache.velocity.util.HibernateUtil;
import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class EmployeeDaoImpl  implements EmployeeDao {
    @Override
    public List<Employee> findAllEmployee() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employee", Employee.class).list();
        }

    }
}
