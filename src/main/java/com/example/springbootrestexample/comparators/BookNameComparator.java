package com.example.springbootrestexample.comparators;

import com.example.springbootrestexample.models.Book;

import java.util.Comparator;

public class BookNameComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        return firstBook.getName().compareTo(secondBook.getName());
    }
}
