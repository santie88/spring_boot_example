package com.example.springbootrestexample.configurations;

import com.example.springbootrestexample.logic.AuthorLogic;
import com.example.springbootrestexample.logic.BookLogic;
import com.example.springbootrestexample.repositories.AuthorRepository;
import com.example.springbootrestexample.repositories.BookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public AppConfig(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Bean
    public BookLogic bookLogic(BookRepository bookRepository) { return new BookLogic(bookRepository); }

    @Bean
    public AuthorLogic authorLogic(AuthorRepository authorRepository) { return new AuthorLogic(authorRepository); }

}