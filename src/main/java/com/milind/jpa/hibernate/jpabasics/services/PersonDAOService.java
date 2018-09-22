package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonDAOService {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Person> findAll(){
       return jdbcTemplate.query("select * from person",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    //Not working code... Find out how to get multiple objects
    public List<Person> findByLocation(String location){
        return jdbcTemplate.queryForList("select * from person where location=?",Person.class,location);
    }

    public int deleteByID(int id){
        return jdbcTemplate.update("delete from person where id=?",new Object[]{id});
    }

    public int insertPersonData(Person person){
        return jdbcTemplate.update("insert into person values(?,?,?,?)",
                new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});
    }

    public int updatePersonData(Person person){
        return jdbcTemplate.update("update person set name=?,location=?,birth_Date=? where id=?",
                new Object[]{person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()),person.getId()});
    }
}
