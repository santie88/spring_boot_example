package com.example.springbootrestexample.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Book extends ReadObject{

    private Date releaseDate;

    public Book() {}

    public Book(String isbn, String name, Author author, Date releaseDate){
        super(isbn, name, author);
        this.releaseDate = releaseDate;
    }
}
