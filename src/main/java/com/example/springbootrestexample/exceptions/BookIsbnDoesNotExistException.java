package com.example.springbootrestexample.exceptions;

public class BookIsbnDoesNotExistException extends RuntimeException {
    public BookIsbnDoesNotExistException(String isbn, Exception e){
        super("Does not exist a book with this isbn: " + isbn, e);
    }
}
