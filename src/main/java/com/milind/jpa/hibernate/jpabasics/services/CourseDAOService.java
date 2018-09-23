package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDAOService {

    @Autowired
    EntityManager em;

    public List findAllByJQPL_Basic(){
        Query q = em.createQuery("select c from Course c");
        return q.getResultList();
    }

    public List<Course> findAllByJQPL_typed_Query(){
        TypedQuery<Course> tq = em.createQuery("select c from Course c",Course.class);
        return tq.getResultList();
    }

    public List<Course> findByName_JQPL_namedQuery_with_Param(){
        TypedQuery<Course> tq = em.createNamedQuery("find_by_Name_JS",Course.class);
        //tq.setParameter(1,"JS");
        return  tq.getResultList();
    }

    public List<Course> findByName_Native_namedQuery_with_Param(){
        Query q = em.createNativeQuery("select * from Course where name like ?",Course.class);
        q.setParameter(1,"%JS%");
        return  q.getResultList();
    }



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
