package com.example.springbootrestexample.repositories;

import com.example.springbootrestexample.models.Book;

import java.util.List;

public interface BookRepository {
    Book createBook(Book book);
    List<Book> listBooks();
    Book getBookByIsbn(String isbn);
    void updateBook(Book book);
    void deleteBook(String isbn);
}
