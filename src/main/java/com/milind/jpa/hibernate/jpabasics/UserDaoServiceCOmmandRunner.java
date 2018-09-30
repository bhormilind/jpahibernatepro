package com.milind.jpa.hibernate.jpabasics;

import com.milind.jpa.hibernate.jpabasics.entities.Passport;
import com.milind.jpa.hibernate.jpabasics.entities.User;
import com.milind.jpa.hibernate.jpabasics.services.PassportSpringDataRepo;
import com.milind.jpa.hibernate.jpabasics.services.UserDAOService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.Optional;


@Component
public class UserDaoServiceCOmmandRunner implements CommandLineRunner {

    public static final Logger logs =
            LoggerFactory.getLogger(UserDaoServiceCOmmandRunner.class);
    @Autowired
    private UserDAOService userDAOService;

    @Autowired
    private PassportSpringDataRepo passportRepo;

    @Override
    public void run(String... args) throws Exception {

        Long id = userDAOService.insert(new User("Milind","CEO"));
        logs.info("\n 1st Record : "+id);


        // 1) Read and Display All passports
        logs.info("\n All Passports : "+passportRepo.findAll());

        // 2) Find passport By IDs:
        logs.info("\n All passport for matching ID : "+passportRepo.findAllById(Arrays.asList(2l,3l)));

        // 3) Find Passport by ID:3 Returns Optional<Passport>
        Optional<Passport> passport = passportRepo.findById(3l);
        if(passport.isPresent()) {
            logs.info("\n Get Passport of id:{} --> {}", 3l, passport.get());
        }

        // 4) Count the records of passport table
        logs.info("\n Preset Records in passport Table : "+passportRepo.count());

        // 5) Sorting on the basis of passportNo
        Sort sort = new Sort(Sort.Direction.DESC,"passportNo");
        logs.info("\n Sorted Passport on the basis of passportNo : {} ", passportRepo.findAll(sort));

        // 6) Find passport by passportNo
        logs.info("\n Passport by passportNo: {} -> {}","P123468",passportRepo.findByPassportNo("P123468"));

        // 7) Retrive passport by Native query
        logs.info("\n Native Query : {} ", passportRepo.passportfromNativeQuery());

        // 8) Retive passports by JPQL
        logs.info("\n JPQL : {} ",passportRepo.passportNoFromJPQL());

        // 9) Named Query
        logs.info("\n Named Query Demo :- {}",passportRepo.firstTwoPassports());


        // 10) Paginate the read of passport table

        PageRequest pageRequest = PageRequest.of(0,2);
        Page<Passport> firstPage = passportRepo.findAll(pageRequest);
        logs.info("\n Total Number of pages : {} ",firstPage.getTotalPages());
        logs.info("\n First Page :- {} ", firstPage.getContent());

        Pageable secondPagable = firstPage.nextPageable();
        Page<Passport> secondPage = passportRepo.findAll(secondPagable);
        logs.info("\n Second Page :- {} ", secondPage.getContent());

        Pageable thirdPagable = secondPage.nextPageable();
        Page<Passport> thirdPage = passportRepo.findAll(thirdPagable);
        if(!thirdPage.isEmpty()){
            logs.info("\n Third Page :- {} ", thirdPage.getContent());
        }


    }
}
