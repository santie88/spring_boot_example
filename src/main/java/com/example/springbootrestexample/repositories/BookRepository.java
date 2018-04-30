package com.example.springbootrestexample.repositories;

import com.example.springbootrestexample.models.Book;
import com.example.springbootrestexample.models.ReadObject;
import com.example.springbootrestexample.springdatamongodb.BookCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookRepository {

    private List<Book> books = new ArrayList<>();
    @Autowired
    private BookCollection bookCollection;

    public Book createBook(Book book) {
        //books.add(book);
        bookCollection.save(book);
        return book;
    }

    public List<Book> listBooks() {
        return bookCollection.findAll();
        //return books;
    }

    public Book getBookByIsbn(String isbn) {
        return bookCollection.findByIsbn(isbn);
        //return bookCollection.findOne(Query.query(Criteria.where("isbn").is(isbn)), Book.class);
        //return doGetBookByIsbn(isbn);
    }

    public boolean getExistByIsbn(String isbn){
        return bookCollection.existsByIsbn(isbn);
    }

    public void updateBook(Book book) {
        //Book updatedBook = doGetBookByIsbn(book.getIsbn());
        //updatedBook.setAuthor(book.getAuthor());
        //updatedBook.setName(book.getName());
        Book updatedBook = bookCollection.findByIsbn(book.getIsbn());
        updatedBook.setName(book.getName());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setReleaseDate(book.getReleaseDate());
        bookCollection.save(updatedBook);
    }

    public void deleteBook(String isbn) {
        //books = books.stream().filter(book -> !book.getIsbn().equals(isbn)).collect(Collectors.toList());
        bookCollection.deleteByIsbn(isbn);
    }

    private Book doGetBookByIsbn(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().get();
    }
}
