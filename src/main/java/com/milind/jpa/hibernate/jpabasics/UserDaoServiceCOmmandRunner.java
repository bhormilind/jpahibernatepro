package com.milind.jpa.hibernate.jpabasics;

import com.milind.jpa.hibernate.jpabasics.entities.Person;
import com.milind.jpa.hibernate.jpabasics.services.PersonDAOService;

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
    private PersonDAOService personDAOService;

    @Override
    public void run(String... args) throws Exception {

        logs.info("\n ==========================================");
        logs.info("\n All users \n :{}",personDAOService.findAll());
        logs.info("\n ==========================================");
        logs.info("\n Find By id  \n :{}",personDAOService.findById(10001));
        //logs.info("\n ==========================================");
        //logs.info("\n Find By id  \n :{}",personDAOService.findByLocation("Canada"));
        logs.info("\n ==========================================");
        logs.info("\n Delete By id  \n :{}",personDAOService.deleteByID(10003));
        logs.info("\n All users \n :{}",personDAOService.findAll());
        logs.info("\n ==========================================");
        logs.info("\n Update record of user Id 10002");
        logs.info("\n Update By Id \n :{}",personDAOService.updatePersonData(new Person(10002,"Ganesha","US",new Date())));
        logs.info("\n All users \n :{}",personDAOService.findAll());
        logs.info("\n ==========================================");
        logs.info("\n Insert new record 10004");
        logs.info("\n Update By Id \n :{}",personDAOService.insertPersonData(new Person(10004,"Ganesha","US",new Date())));
        logs.info("\n All users \n :{}",personDAOService.findAll());
        logs.info("\n ==========================================");
        logs.info("\n Find All by location \n :{}",personDAOService.findAllByLocationNew("US"));

        logs.info("\n ==========================================");
        logs.info("\n Find All by Custome Mapper One \n :{}",personDAOService.findAllByCustMapperOne());

        logs.info("\n ==========================================");
        logs.info("\n Find All by Custome Mapper Two \n :{}",personDAOService.findAllByCustMapperTwo());







    }
}
