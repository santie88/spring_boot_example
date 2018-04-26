package com.example.springbootrestexample.controllers;

import com.example.springbootrestexample.models.Author;
import com.example.springbootrestexample.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/author/")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Author> getBooks(){
        return authorRepository.listAuthors();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Author postBook(@RequestBody Author author){
        return authorRepository.createAuthor(author);
    }

}
