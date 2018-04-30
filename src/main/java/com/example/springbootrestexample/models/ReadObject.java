package com.example.springbootrestexample.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ReadObject {

    private String isbn;
    private String name;
    private Author author;
}
