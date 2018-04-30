package com.example.springbootrestexample.springdatamongodb;

import com.example.springbootrestexample.models.Magazine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MagazineCollection extends MongoRepository<Magazine, String> {

    Magazine findByIsbn(String isbn);
    void deleteByIsbn(String isbn);

}
