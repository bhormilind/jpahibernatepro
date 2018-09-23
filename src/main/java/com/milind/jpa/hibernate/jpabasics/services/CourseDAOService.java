package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseDAOService {

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class,id);
    }

    public Long saveCourse(Course c){
         em.persist(c);
         return c.getId();
    }

    public void deleteCourse(Long id){
        Course c = findById(id);
        if(c != null){
            em.remove(c);
        }
    }


    public void playWithEntityManagersOptions(){
        Course c = new Course("Angular JS : ");
        em.persist(c);
        Course c2 = new Course("Node JS");
        em.persist(c2);

        em.flush();

        //em.detach(c2);   ---> Object will removed from current session

        c.setName("Angular JS : --Updated");
        c2.setName("Node JS ---- Updated");

        em.refresh(c); /// Data reloaded from DB to Object 'c' back.  so it will overwrite current Data of Object 'c'

        em.flush();





    }

}
