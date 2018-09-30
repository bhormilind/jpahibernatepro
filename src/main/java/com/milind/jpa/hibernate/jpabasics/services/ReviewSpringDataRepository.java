package com.milind.jpa.hibernate.jpabasics.services;

import com.milind.jpa.hibernate.jpabasics.entities.Passport;
import com.milind.jpa.hibernate.jpabasics.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewSpringDataRepository extends JpaRepository<Review, Long> {


}
