package com.example.springbootrestexample.springdatamongodb;

import com.example.springbootrestexample.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorCollection extends MongoRepository<Author, String> {

    public Author findByName(String name);

}
