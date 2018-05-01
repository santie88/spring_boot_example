package com.example.springbootrestexample.comparators;

import com.example.springbootrestexample.models.Book;

import java.util.Comparator;

public class BookIsbnComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        return firstBook.getIsbn().compareTo(secondBook.getIsbn());
    }
}
