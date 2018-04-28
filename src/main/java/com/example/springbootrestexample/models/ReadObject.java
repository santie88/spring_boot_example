package com.example.springbootrestexample.models;

public abstract class ReadObject {

    private String isbn;
    private String name;
    private Author author;

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
