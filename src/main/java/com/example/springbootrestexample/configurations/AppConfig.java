package com.example.springbootrestexample.configurations;

import com.example.springbootrestexample.logic.AuthorLogic;
import com.example.springbootrestexample.logic.BookLogic;
import com.example.springbootrestexample.repositories.AuthorRepository;
import com.example.springbootrestexample.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AppConfig {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Bean
    public BookLogic bookLogic(BookRepository bookRepository) { return new BookLogic(bookRepository); }

    @Bean
    public AuthorLogic authorLogic(AuthorRepository authorRepository) { return new AuthorLogic(authorRepository); }

}