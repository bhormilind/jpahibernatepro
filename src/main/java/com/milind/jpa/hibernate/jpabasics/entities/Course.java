package com.milind.jpa.hibernate.jpabasics.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries( value = {
        @NamedQuery(name = "find_by_Name_JS",query = "select c from Course c where name like '%JS%'"),
        @NamedQuery(name = "find_All",query = "select c from Course c")
})

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public List<Student> getStudents(Student s) {
        return students;
    }

    public void addStudent(Student s){
        this.students.add(s);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReviews(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review){
        this.reviews.remove(review);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
