package com.example.springbootrestexample.repositories;

import com.example.springbootrestexample.models.Author;

import java.util.List;

public interface AuthorRepository {
    Author createAuthor(Author author);
    List<Author> listAuthors();
    Author getAuthorByName(String name);
}
