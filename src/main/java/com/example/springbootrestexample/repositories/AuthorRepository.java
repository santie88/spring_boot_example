package com.example.springbootrestexample.repositories;

import com.example.springbootrestexample.models.Author;
import com.example.springbootrestexample.springdatamongodb.AuthorCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();
    //@Autowired
    //private AuthorCollectionongoJavaDriver authorCollection;
    @Autowired
    private AuthorCollection authorCollectionStringData;

    public Author createAuthor(Author author){
        //authors.add(author);
        //authorCollection.insertAuthor(author);
        authorCollectionStringData.save(author);
        return author;
    }

    public List<Author> listAuthors(){
        return authorCollectionStringData.findAll();
        //return authorCollection.findAll();
        //return authors;
    }

    public Author getAuthorByName(String name){
        return authorCollectionStringData.findByName(name);
        //return authorCollection.findOneByName(name);
        //return authors.stream().filter(author -> author.getName().equals(name)).findAny().get();
    }
}
