package com.example.springbootrestexample.springdatamongodb;

import com.example.springbootrestexample.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookCollection extends MongoRepository<Book, String> {

    Book findByIsbn(String isbn);
    void deleteByIsbn(String isbn);
    boolean existsByIsbn(String isbn);

}
