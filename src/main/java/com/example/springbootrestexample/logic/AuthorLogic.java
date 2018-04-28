package com.example.springbootrestexample.logic;

import com.example.springbootrestexample.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorLogic {

    @Autowired
    AuthorRepository authorRepository;

    public boolean getAuthorExistByName(String name){
        return authorRepository.listAuthors().stream().anyMatch(author -> author.getName().equals(name));
    }
}
