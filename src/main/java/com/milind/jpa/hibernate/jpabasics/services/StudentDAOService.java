package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Course;
import com.milind.jpa.hibernate.jpabasics.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public List<Course> jpql_courses_without_student(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
        return query.getResultList();
    }

    public List<Course> jpql_courses_more_than_student(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
        return query.getResultList();
    }

    ///// Some more jpql criterias-------------

    //like
    //BETWEEN x and y
    //IS NULL
    //upper, lower, trim, length
    public List<Student> jpqlPassportNoLikeSomePattern(){
        TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.passportNo like '%200%'",Student.class);
        return query.getResultList();
    }


    ///------- Join Demo
    //1) JOIN       ---->>  Select c,s from Course c JOIN c.students s  ( will not return Courses without students too)
    //2) LEFT JOIN  ---->>  Select c, s from Course c LEFT JOIN c.students s  ( will return Courses without students too)
    //3) CROSS JOIN ---->> Select c, s from Course c, Student s

    public List simpleJoin(){
        Query q=em.createQuery("Select c, s from Course c JOIN c.students s");
        return q.getResultList();

    }

    public List<Object[]> leftJoin(){
        Query q = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
        return q.getResultList();
    }

    public List<Object[]> crossJoin(){
        Query q = em.createQuery("Select c, s from Course c, Student s");
        return q.getResultList();
    }
}
