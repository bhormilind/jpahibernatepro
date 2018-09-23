package com.milind.jpa.hibernate.jpabasics;

import com.milind.jpa.hibernate.jpabasics.entities.Person;
import com.milind.jpa.hibernate.jpabasics.entities.User;
import com.milind.jpa.hibernate.jpabasics.services.PersonDAOService;
import com.milind.jpa.hibernate.jpabasics.services.UserDAOService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class UserDaoServiceCOmmandRunner implements CommandLineRunner {

    public static final Logger logs =
            LoggerFactory.getLogger(UserDaoServiceCOmmandRunner.class);


    @Autowired
    private UserDAOService userDAOService;

    @Autowired
    PersonDAOService personDAOService;


    @Override
    public void run(String... args) throws Exception {

        Long id = userDAOService.insert(new User("Milind","CEO"));
        logs.info("\n 1st Record : "+id);

        logs.info("\n============================================");
        logs.info("\n Find By ID : "+personDAOService.findById(1001l));
        logs.info("\n============================================");
        logs.info("\n Insert New Record of ID: "+personDAOService.insertOrUpdate(new Person("Suresh","Amsterdam",new Date())));
        logs.info("\n============================================");

        Person p = personDAOService.findById(1004l);
        if(p!=null){
            p.setName("Shanti");
            logs.info("\n Update Record of ID 1004: "+personDAOService.insertOrUpdate(p));
            logs.info("\n============================================");
        }

        personDAOService.deleteById(1005l);

        logs.info("\n============================================");
        logs.info("\n Find All : "+personDAOService.findAll());
        logs.info("\n============================================");

    }
}
