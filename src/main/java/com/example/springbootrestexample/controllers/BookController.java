package com.example.springbootrestexample.controllers;

import com.example.springbootrestexample.models.Book;
import com.example.springbootrestexample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //Me crea el bean en el Contexto y ademas me lo crea como Controller para REST
@RequestMapping("/api/book/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks(){
        return bookRepository.listBooks();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book postBook(@RequestBody Book book){
        return bookRepository.createBook(book);
    }

}
