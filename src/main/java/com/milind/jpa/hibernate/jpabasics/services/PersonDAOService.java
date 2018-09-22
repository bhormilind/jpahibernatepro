package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonDAOService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Way-1 ---> Create a Custom Row Mapper by Inner Class
    class MilindRowMapperPerson implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet rs, int i) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getDate("birth_Date"));
            return person;
        }
    }

    //way-2  ---> Create a Custom Row Mapper by using Lambda Expression
    private RowMapper<Person> MilindRowMapperPersonLambda = (rs,no) ->{
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setLocation(rs.getString("location"));
        person.setBirthDate(rs.getDate("birth_Date"));
        return person;
    };


    public List<Person> findAll(){
       return jdbcTemplate.query("select * from person",new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findAllByLocationNew(String location){
        return jdbcTemplate.query("select * from person where location=?",new Object[]{location},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findAllByCustMapperOne(){
        return jdbcTemplate.query("select * from person",new MilindRowMapperPerson());
    }

    public List<Person> findAllByCustMapperTwo(){
        return jdbcTemplate.query("select * from person",MilindRowMapperPersonLambda);
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
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
