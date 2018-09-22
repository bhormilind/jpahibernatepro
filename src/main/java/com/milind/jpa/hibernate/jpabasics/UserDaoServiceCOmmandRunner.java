package com.milind.jpa.hibernate.jpabasics;

import com.milind.jpa.hibernate.jpabasics.services.PersonDAOService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



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

    }
}
