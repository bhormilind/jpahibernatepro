package com.milind.jpa.hibernate.jpabasics;

import com.milind.jpa.hibernate.jpabasics.entities.Passport;
import com.milind.jpa.hibernate.jpabasics.entities.Student;
import com.milind.jpa.hibernate.jpabasics.services.CourseDAOService;

import com.milind.jpa.hibernate.jpabasics.services.StudentDAOService;
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

    @Autowired
    StudentDAOService studentDAOService;

    @Override
    public void run(String... args) throws Exception {

        logs.info("===================================");
        logs.info("\n Find by id 2 : "+courseDAOService.findById(2001l));
        logs.info("===================================---");
        logs.info("\n Called playedWithEMManager ");
        courseDAOService.playWithEntityManagersOptions();
        logs.info("===================================---");

        logs.info("===================================");
        logs.info("\n Find all by basic jpql : "+courseDAOService.findAllByJQPL_Basic());
        logs.info("===================================---");
        logs.info("===================================");
        logs.info("\n Find all by Typed jpql : "+courseDAOService.findAllByJQPL_typed_Query());
        logs.info("===================================---");
        logs.info("===================================");
        logs.info("\n Find all by Named Typed  jpql : "+courseDAOService.findByName_JQPL_namedQuery_with_Param());
        logs.info("===================================---");

        logs.info("===================================");
        logs.info("\n Find all by Native   with Param: "+courseDAOService.findByName_Native_namedQuery_with_Param());
        logs.info("===================================---");

        logs.info("===================================---");
        logs.info(" Enter student record ");
        Student s = new Student("Ganesha");
        s.setPassport(new Passport("G2002"));
        studentDAOService.saveStudent(s);

        logs.info("===================================---");
        logs.info(" Displaying All Students : "+studentDAOService.findAll());
        logs.info("===================================---");


    }
}
