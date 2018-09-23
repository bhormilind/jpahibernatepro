package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDAOService {

    @Autowired
    EntityManager entityManager;

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery =  entityManager.createNamedQuery("find_all_person",Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(Long id){
        return entityManager.find(Person.class,id);
    }

    public Person insertOrUpdate(Person p){
        return entityManager.merge(p);
    }

    public void deleteById(Long id){
        entityManager.remove(findById(id));
    }



}
