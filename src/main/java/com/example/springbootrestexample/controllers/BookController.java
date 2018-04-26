package com.example.springbootrestexample.controllers;

import com.example.springbootrestexample.models.Book;
import com.example.springbootrestexample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks(){
        return bookRepository.listBooks();
    }

    @RequestMapping(value = "{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("isbn") String isbn){
        return bookRepository.getBookByIsbn(isbn);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book postBook(@RequestBody Book book){
        return bookRepository.createBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putBook(@RequestBody Book book){
        bookRepository.updateBook(book);
    }

    @RequestMapping(value = "{isbn}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("isbn") String isbn){
        bookRepository.deleteBook(isbn);
    }

}
