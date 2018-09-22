package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOService {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Person> findAll(){
       return jdbcTemplate.query("select * from person",new BeanPropertyRowMapper<>(Person.class));
    }
}
