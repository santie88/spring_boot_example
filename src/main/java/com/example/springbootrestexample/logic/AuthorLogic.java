package com.example.springbootrestexample.logic;

import com.example.springbootrestexample.exceptions.AuthorNameDoesNotExistException;
import com.example.springbootrestexample.models.Author;
import com.example.springbootrestexample.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AuthorLogic extends ExceptionMessageLogic {

    private final AuthorRepository authorRepository;

    public boolean getAuthorExistByName(String name){
        return authorRepository.listAuthors().stream().anyMatch(author -> author.getName().equals(name));
    }

    public List<Author> getAllAuthors(){
        return authorRepository.listAuthors();
    }

    public Author getAuthorByName(String name){
        try {
            return authorRepository.getAuthorByName(name);
        } catch (NoSuchElementException e) {
            throw new AuthorNameDoesNotExistException(name);
        }
    }

    public Author createAuthor(Author author){
        try {
            return authorRepository.createAuthor(author);
        } catch (Exception e) {
            throw new RuntimeException(customExceptionMessage);
        }
    }
}
