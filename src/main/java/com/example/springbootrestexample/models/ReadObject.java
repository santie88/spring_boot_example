package com.example.springbootrestexample.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ReadObject {

    private String isbn;
    private String name;
    private Author author;

    public ReadObject() {}

    public ReadObject(String isbn, String name, Author author){
        this.isbn = isbn;
        this.name = name;
        this.author = author;
    }
}
