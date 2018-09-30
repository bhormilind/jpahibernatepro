package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PassportSpringDataRepo extends JpaRepository<Passport,Long> {

    List<Passport> findByPassportNo(String passportNo);

    List<Passport> deleteByPassportNo(String passportNo);

 @Query("select p from Passport p where passportNo like '%123%'")
    List<Passport> passportNoFromJPQL();

    @Query(value = "Select * from passport where passport_no like '%123%'",nativeQuery = true)
    List<Passport> passportfromNativeQuery();

    @Query(name = "firstTwoRecords")
    List<Passport> firstTwoPassports();
}
