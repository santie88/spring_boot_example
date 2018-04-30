package com.example.springbootrestexample.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Magazine extends ReadObject {

    private String description;

    public Magazine() {}

    public Magazine(String isbn, String name, Author author, String description){
        super(isbn, name, author);
        this.description = description;
    }

}
