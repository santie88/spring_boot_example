package com.example.springbootrestexample.configurations;

import com.example.springbootrestexample.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class AppConfigMemory {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepositoryInMemory();
    }

    @Bean
    public MagazineRepository magazineRepository() {
        return new MagazineRepositoryInMemory();
    }

    @Bean
    public AuthorRepository authorRepository() {
        return new AuthorRepositoryInMemory();
    }

}
