package com.example.springbootrestexample.controllers;

import com.example.springbootrestexample.exceptions.AuthorNameDoesNotExistException;
import com.example.springbootrestexample.exceptions.BookIsbnExistException;
import com.example.springbootrestexample.logic.AuthorLogic;
import com.example.springbootrestexample.logic.BookLogic;
import com.example.springbootrestexample.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    @Autowired
    private BookLogic bookLogic;
    @Autowired
    private AuthorLogic authorLogic;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> findAll() {
        return bookLogic.getAllBooks();
    }

    @RequestMapping(value = "/orderBy={columnName}", method = RequestMethod.GET)
    public List<Book> findAll(@PathVariable("columnName") String columnName) {
        return bookLogic.getAllBooks(columnName);
    }

    @RequestMapping(value = "{isbn}", method = RequestMethod.GET)
    public Book findBook(@PathVariable("isbn") String isbn) {
        return bookLogic.getBookByIsbn(isbn);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    public Book createBook(@RequestBody Book book){
        if(bookLogic.getBookExistByIsbn(book.getIsbn())) {
            throw new BookIsbnExistException(book.getIsbn());
        }

        if(!authorLogic.getAuthorExistByName(book.getAuthor().getName())) {
            throw new AuthorNameDoesNotExistException(book.getAuthor().getName());
        }

        return bookLogic.createBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus( HttpStatus.OK )
    public Book updateBook(@RequestBody Book book){
        bookLogic.updateBook(book);
        return book;
    }

    @RequestMapping(value = "{isbn}", method = RequestMethod.DELETE)
    @ResponseStatus( HttpStatus.OK )
    public void deleteBook(@PathVariable("isbn") String isbn){
        bookLogic.deleteBook(isbn);
    }

    @ExceptionHandler(value = { BookIsbnExistException.class, AuthorNameDoesNotExistException.class })
    @ResponseStatus( HttpStatus.PRECONDITION_FAILED )
    public String handlePreconditionFailedException(RuntimeException ex){
        return ex.getMessage();
    }
}
