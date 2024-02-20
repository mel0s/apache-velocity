package com.baeldung.apache.velocity.dao.impl;

import com.baeldung.apache.velocity.dao.EmployeeDao;
import com.baeldung.apache.velocity.entity.Employee;
import com.baeldung.apache.velocity.entity.Pet;
import com.baeldung.apache.velocity.util.HibernateUtil;
import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class EmployeeDaoImpl  implements EmployeeDao {

//    @PersistenceContext(name = "jpa-hibernate-mysql")
//    private EntityManager entityManager;

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public EmployeeDaoImpl(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        entityManager = entityManagerFactory.createEntityManager();
    }
    @Override
    public List<Employee> findAllEmployee() {


        return entityManager.createNativeQuery("select * from employee ", Employee.class).getResultList();

//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("from Employee", Employee.class).list();
//        }

    }

    @Override
    public List<Pet> findAllPet() {

        return entityManager.createQuery("select P from Pet P", Pet.class).getResultList();
    }
}
