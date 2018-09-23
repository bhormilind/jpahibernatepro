package com.milind.jpa.hibernate.jpabasics;

import com.milind.jpa.hibernate.jpabasics.services.CourseDAOService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class DaoServiceCommandRunner implements CommandLineRunner {

    public static final Logger logs =
            LoggerFactory.getLogger(DaoServiceCommandRunner.class);

    @Autowired
    CourseDAOService courseDAOService;

    @Override
    public void run(String... args) throws Exception {

        logs.info("===================================");
        logs.info("\n Find by id 2 : "+courseDAOService.findById(2001l));
        logs.info("===================================---");
        logs.info("\n Called playedWithEMManager ");
        courseDAOService.playWithEntityManagersOptions();
        logs.info("===================================---");
    }
}
