package com.milind.jpa.hibernate.jpabasics.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String reviewComment;

    private Double ratings;

    @ManyToOne
    private Course course;

    public Review() {
    }

    public Review(String reviewComment, Double ratings) {
        this.reviewComment = reviewComment;
        this.ratings = ratings;
    }

    public Long getId() {
        return id;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public Double getRatings() {
        return ratings;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
