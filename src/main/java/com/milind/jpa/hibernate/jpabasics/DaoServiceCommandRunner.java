package com.milind.jpa.hibernate.jpabasics;

import com.milind.jpa.hibernate.jpabasics.entities.*;
import com.milind.jpa.hibernate.jpabasics.services.CourseDAOService;

import com.milind.jpa.hibernate.jpabasics.services.EmployeeDAOService;
import com.milind.jpa.hibernate.jpabasics.services.StudentDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;


@Component
public class DaoServiceCommandRunner implements CommandLineRunner {

    public static final Logger logs =
            LoggerFactory.getLogger(DaoServiceCommandRunner.class);

    @Autowired
    private CourseDAOService courseDAOService;

    @Autowired
    private StudentDAOService studentDAOService;

    @Autowired
    private EmployeeDAOService employeeDAOService;

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

        courseDAOService.addReviewsForCourse(1003l, Arrays.asList(new Review(4.2,"Gread Hands On")
                ,new Review(4.6,"Good Programs")));


        studentDAOService.retriveStudentAndCourse();

        logs.info("Adding student and Course");
        studentDAOService.insertStudentAndCourse();

        //insert employee

        employeeDAOService.saveEmp(new FullTimeEmployee("JACK",new BigDecimal("10000")));

        employeeDAOService.saveEmp(new PartTimeEmployee("Jill", new BigDecimal("50")));


        logs.info("All Employees : "+employeeDAOService.getEmployees());
    }
}
