package com.example.springbootrestexample.logic;

import com.example.springbootrestexample.comparators.BookIsbnComparator;
import com.example.springbootrestexample.comparators.BookNameComparator;
import com.example.springbootrestexample.exceptions.BookIsbnDoesNotExistException;
import com.example.springbootrestexample.models.Book;
import com.example.springbootrestexample.repositories.AuthorRepository;
import com.example.springbootrestexample.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookLogic extends ExceptionMessageLogic {

    @Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;
    @Autowired
    @Qualifier("authorRepository")
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks(){
        return getAllBooks("");
    }

    public List<Book> getAllBooks(String columnOrder){
        List<Book> books = bookRepository.listBooks();

        switch (columnOrder){
            case "isbn":
                books.sort(new BookIsbnComparator());
                break;

            case "name":
                books.sort(new BookNameComparator());
                break;

            default:
                break;
        }

        return books;
    }

    public Book getBookByIsbn(String isbn){
        try {
            return bookRepository.getBookByIsbn(isbn);
        } catch (NoSuchElementException e) {
            throw new BookIsbnDoesNotExistException(isbn, e);
        }
    }

    public boolean getBookExistByIsbn(String isbn){
        return (bookRepository.getBookByIsbn(isbn)!= null);
    }

    public Book createBook(Book book){
        try {
            return bookRepository.createBook(book);
        } catch (Exception e) {
            throw new RuntimeException(customExceptionMessage);
        }
    }

    public void updateBook(Book book){
        try {
            bookRepository.updateBook(book);
        } catch (Exception e) {
            throw new RuntimeException(customExceptionMessage);
        }
    }

    public void deleteBook(String isbn){
        try {
            bookRepository.deleteBook(isbn);
        } catch (Exception e) {
            throw new RuntimeException(customExceptionMessage);
        }
    }
}
