package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public Long insert(User user){
        entityManager.persist(user);
        return user.getId();
    }
}
