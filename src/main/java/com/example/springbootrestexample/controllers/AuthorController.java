package com.example.springbootrestexample.controllers;

import com.example.springbootrestexample.exceptions.AuthorNameDoesNotExistException;
import com.example.springbootrestexample.logic.AuthorLogic;
import com.example.springbootrestexample.models.Author;
import com.example.springbootrestexample.repositories.AuthorRepository;
import com.example.springbootrestexample.repositories.AuthorRepositoryInMongoDB;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/author/")
@AllArgsConstructor
public class AuthorController {

    private final AuthorLogic authorLogic;

    @RequestMapping(method = RequestMethod.GET)
    public List<Author> findAll(){
        return authorLogic.getAllAuthors();
    }

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public Author findAuthorByName(@PathVariable("name") String name){
        return authorLogic.getAuthorByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Author createAuthor(@RequestBody Author author){
        return authorLogic.createAuthor(author);
    }

}
