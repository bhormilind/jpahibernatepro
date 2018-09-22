package com.milind.jpa.hibernate.jpabasics.controllers;

import com.milind.jpa.hibernate.jpabasics.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return Arrays.asList(new Book(10001l,"Mastering Spring 1.5....","Milind Bhor"));
    }
}
