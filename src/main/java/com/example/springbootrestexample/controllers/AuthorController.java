package com.example.springbootrestexample.controllers;

import com.example.springbootrestexample.exceptions.AuthorNameDoesNotExistException;
import com.example.springbootrestexample.models.Author;
import com.example.springbootrestexample.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/author/")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Author> findAll(){
        return authorRepository.listAuthors();
    }

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public Author findAuthorByName(@PathVariable("name") String name){
        try {
            return authorRepository.getAuthorByName(name);
        }
        catch (NoSuchElementException e){
            throw new AuthorNameDoesNotExistException(name);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Author createAuthor(@RequestBody Author author){
        return authorRepository.createAuthor(author);
    }

}
