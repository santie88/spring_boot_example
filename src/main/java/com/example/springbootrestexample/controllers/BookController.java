package com.example.springbootrestexample.controllers;

import com.example.springbootrestexample.exceptions.BookIsbnAlreadyExistentException;
import com.example.springbootrestexample.exceptions.BookIsbnDoesNotExistException;
import com.example.springbootrestexample.models.Book;
import com.example.springbootrestexample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> findAll(){
        return bookRepository.listBooks();
    }

    @RequestMapping(value = "{isbn}", method = RequestMethod.GET)
    public Book findBook(@PathVariable("isbn") String isbn) {
        try {
            return bookRepository.getBookByIsbn(isbn);
        } catch (NoSuchElementException e) {
            throw new BookIsbnDoesNotExistException(isbn, e);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){
        try {
            bookRepository.getBookByIsbn(book.getIsbn());
            throw new BookIsbnAlreadyExistentException(book.getIsbn());
        } catch (NoSuchElementException e) {
            return bookRepository.createBook(book);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book){
        bookRepository.updateBook(book);
        return book;
    }

    @RequestMapping(value = "{isbn}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("isbn") String isbn){
        bookRepository.deleteBook(isbn);
    }

}
