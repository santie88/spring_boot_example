package com.example.springbootrestexample.repositories;

import com.example.springbootrestexample.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepositoryInMemory implements BookRepository {

    private List<Book> books = new ArrayList<>();

    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    public List<Book> listBooks() {
        return books;
    }

    public Book getBookByIsbn(String isbn) {
        return doGetBookByIsbn(isbn);
    }

    public void updateBook(Book book) {
        Book updatedBook = doGetBookByIsbn(book.getIsbn());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setName(book.getName());
    }

    public void deleteBook(String isbn) {
        books = books.stream().filter(book -> !book.getIsbn().equals(isbn)).collect(Collectors.toList());
    }

    private Book doGetBookByIsbn(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().get();
    }
}
