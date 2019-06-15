package com.example.springbootrestexample.controllers;

import com.example.springbootrestexample.logic.AuthorLogic;
import com.example.springbootrestexample.models.Author;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author/")
public class AuthorController {

    private final AuthorLogic authorLogic;

    public AuthorController(AuthorLogic authorLogic) {
        this.authorLogic = authorLogic;
    }

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
