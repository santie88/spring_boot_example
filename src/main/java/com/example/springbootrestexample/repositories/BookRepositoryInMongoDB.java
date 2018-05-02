package com.example.springbootrestexample.repositories;

import com.example.springbootrestexample.models.Book;
import com.example.springbootrestexample.springdatamongodb.BookCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookRepositoryInMongoDB implements BookRepository {

    @Autowired
    private BookCollection bookCollection;

    public Book createBook(Book book) {
        bookCollection.save(book);
        return book;
    }

    public List<Book> listBooks() {
        return bookCollection.findAll();
    }

    public Book getBookByIsbn(String isbn) {
        return bookCollection.findByIsbn(isbn);
    }

    public void updateBook(Book book) {
        Book updatedBook = bookCollection.findByIsbn(book.getIsbn());
        updatedBook.setName(book.getName());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setReleaseDate(book.getReleaseDate());
        bookCollection.save(updatedBook);
    }

    public void deleteBook(String isbn) {
        bookCollection.deleteByIsbn(isbn);
    }
}
