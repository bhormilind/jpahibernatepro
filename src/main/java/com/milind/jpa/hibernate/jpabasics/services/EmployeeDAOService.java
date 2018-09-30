package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Employee;
import com.milind.jpa.hibernate.jpabasics.entities.FullTimeEmployee;
import com.milind.jpa.hibernate.jpabasics.entities.PartTimeEmployee;
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

    /*public List<Employee> getEmployees(){
        return em.createQuery("Select e from Employee e",Employee.class).getResultList();
    }*/

    public List<PartTimeEmployee> getPatTimeEmployees(){
        return em.createQuery("Select e from PartTimeEmployee e",PartTimeEmployee.class).getResultList();
    }


    public List<FullTimeEmployee> getFullTimeEmployees(){
        return em.createQuery("Select e from FullTimeEmployee e",FullTimeEmployee.class).getResultList();
    }


}
