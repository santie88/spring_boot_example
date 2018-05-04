package com.example.springbootrestexample.configurations;

import com.example.springbootrestexample.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class AppConfigMongoDB {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepositoryInMongoDB();
    }

    @Bean
    public MagazineRepository magazineRepository() {
        return new MagazineRepositoryInMongoDB();
    }

    @Bean
    public AuthorRepository authorRepository() {
        return new AuthorRepositoryInMongoDB();
    }

}
