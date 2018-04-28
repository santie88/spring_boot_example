package com.example.springbootrestexample.repositories;

import com.example.springbootrestexample.models.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public Author createAuthor(Author author){
        authors.add(author);
        return author;
    }

    public List<Author> listAuthors(){
        return authors;
    }

    public Author getAuthorByName(String name){
        return authors.stream().filter(author -> author.getName().equals(name)).findAny().get();
    }
}
