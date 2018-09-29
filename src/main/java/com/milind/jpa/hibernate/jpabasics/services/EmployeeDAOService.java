package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeDAOService {

    @Autowired
    private EntityManager em;

    public void saveEmp(Employee emp){
        em.persist(emp);
        em.flush();
    }

    public List<Employee> getEmployees(){
        return em.createQuery("Select e from Employee e",Employee.class).getResultList();
    }

}
