package com.example.springbootrestexample.repository;

import com.example.springbootrestexample.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Me crea el bean en el Contexto.
public class BookRepository {

    private List<Book> books = new ArrayList<Book>();

    public Book createBook(Book book){
        books.add(book);
        return book;
    }

    public List<Book> listBooks(){
        return books;
    }

}
