package com.example.springbootrestexample.exceptions;

public class BookIsbnExistException extends RuntimeException {
    public BookIsbnExistException(String isbn) {
        super("There is already a book with the same isbn: " + isbn);
    }
}
