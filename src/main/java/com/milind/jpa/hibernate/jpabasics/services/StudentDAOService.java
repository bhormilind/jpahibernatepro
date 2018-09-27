package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Course;
import com.milind.jpa.hibernate.jpabasics.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDAOService {

    private Logger logs = LoggerFactory.getLogger(this.getClass());

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

    // Methods to write and read data from Student and courses

    public void retriveStudentAndCourse(){
        Student st = em.find(Student.class,2000l);
        logs.info("\n Student Name : "+st.getStudName());
        logs.info("\n Student enrolled courses : "+st.getCourses());
    }

    public void insertStudentAndCourse(){
        Student s = new Student("Ganesha");
        Course c = new Course(("React Programming"));

        s.addCourse(c);
        c.addStudent(s);


        em.persist(s);
        em.persist(c);

        em.flush();
    }
}
