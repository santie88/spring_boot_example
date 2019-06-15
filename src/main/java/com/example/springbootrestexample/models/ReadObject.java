package com.example.springbootrestexample.models;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public abstract class ReadObject {

    @Id
    private String id;
    private String isbn;
    private String name;
    private Author author;
    private LocalDateTime lastCheck;

    ReadObject() {
    }

    ReadObject(String id, String isbn, String name, Author author, LocalDateTime lastCheck) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.lastCheck = lastCheck;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public LocalDateTime getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(LocalDateTime lastCheck) {
        this.lastCheck = lastCheck;
    }
}
