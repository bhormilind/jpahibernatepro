package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDAOService {

    @Autowired
    EntityManager em;

    public List<Student> findAll(){
        TypedQuery<Student> tq = em.createQuery("Select s from Student s",Student.class);
        return tq.getResultList();
    }



    public void saveStudent(Student s){
        //Save Passport Record First in passport table
        em.persist(s.getPassport());
        em.flush();

        //Now Save Student Record in Student table
        em.persist(s);
        em.flush();
    }
}
