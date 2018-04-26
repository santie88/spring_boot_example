package com.example.springbootrestexample.repository;

import com.example.springbootrestexample.models.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public Book createBook(Book book){
        books.add(book);
        return book;
    }

    public List<Book> listBooks(){
        return books;
    }

    public Book getBookByIsbn(String isbn){
        Book book = null;

        for (Book bookList : books) {
            if(bookList.getIsbn().equals(isbn)) {
                book = bookList;
                break;
            }
        }

        return book;
    }

    public void updateBook(Book book){
        for (Book bookList : books) {
            if(bookList.getIsbn().equals(book.getIsbn())) {
                bookList.setName(book.getName());
                break;
            }
        }
    }

    public void deleteBook(String isbn){
        for (Book bookList : books) {
            if(bookList.getIsbn().equals(isbn)) {
                books.remove(bookList);
                break;
            }
        }
    }
}
