package com.example.springbootrestexample.exceptions;

public class AuthorNameDoesNotExistException extends RuntimeException {
    public AuthorNameDoesNotExistException(String name){
        super("Does not exist an author with the name: " + name);
    }
}
