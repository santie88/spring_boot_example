package com.example.springbootrestexample.repositories;

import com.example.springbootrestexample.models.Author;
import com.example.springbootrestexample.springdatamongodb.AuthorCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorRepositoryInMongoDB implements AuthorRepository {

    //This is if I work with Mongo Java Driver - Only for example
    //@Autowired
    //private AuthorCollectionongoJavaDriver authorCollection;
    @Autowired
    private AuthorCollection authorCollection;

    public Author createAuthor(Author author){
        //authorCollection.insertAuthor(author); > Only example of Mongo Java Driver
        authorCollection.save(author);
        return author;
    }

    public List<Author> listAuthors(){
        return authorCollection.findAll();
    }

    public Author getAuthorByName(String name){
        return authorCollection.findByName(name);
    }
}
