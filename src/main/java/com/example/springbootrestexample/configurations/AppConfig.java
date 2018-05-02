package com.example.springbootrestexample.configurations;

import com.example.springbootrestexample.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="bookRepository")
    @Conditional(MongoDBCondition.class)
    public BookRepository bookRepositoryInMongoDB() {
        return new BookRepositoryInMongoDB();
    }

    @Bean(name="bookRepository")
    @Conditional(MemoryConfiguration.class)
    public BookRepository bookRepositoryInMemory() {
        return new BookRepositoryInMemory();
    }

    @Bean(name="magazineRepository")
    @Conditional(MongoDBCondition.class)
    public MagazineRepository magazineRepositoryInMongoDB() {
        return new MagazineRepositoryInMongoDB();
    }

    @Bean(name="magazineRepository")
    @Conditional(MemoryConfiguration.class)
    public MagazineRepository magazineRepositoryInMemory() {
        return new MagazineRepositoryInMemory();
    }

    @Bean(name="authorRepository")
    @Conditional(MongoDBCondition.class)
    public AuthorRepository authorRepositoryInMongoDB() {
        return new AuthorRepositoryInMongoDB();
    }

    @Bean(name="authorRepository")
    @Conditional(MemoryConfiguration.class)
    public AuthorRepository authorRepositoryInMemory() {
        return new AuthorRepositoryInMemory();
    }
}
