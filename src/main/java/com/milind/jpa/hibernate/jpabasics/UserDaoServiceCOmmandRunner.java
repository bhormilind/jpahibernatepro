package com.milind.jpa.hibernate.jpabasics;

import com.milind.jpa.hibernate.jpabasics.entities.User;
import com.milind.jpa.hibernate.jpabasics.services.UserDAOService;

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
    private UserDAOService userDAOService;

    @Override
    public void run(String... args) throws Exception {

        Long id = userDAOService.insert(new User("Milind","CEO"));
        logs.info("\n 1st Record : "+id);

    }
}
