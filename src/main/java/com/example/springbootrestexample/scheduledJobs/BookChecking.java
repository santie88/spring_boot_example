package com.example.springbootrestexample.scheduledJobs;

import com.example.springbootrestexample.logic.BookLogic;
import com.example.springbootrestexample.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BookChecking {

    @Autowired
    private BookLogic bookLogic;

    @Scheduled(fixedDelayString = "${schedule.frequency}")
    public void CheckBook(){
        Book book = bookLogic.getBookByIsbn("1");
        book.setLastCheck(LocalDateTime.now());
        bookLogic.updateBook(book);
    }
}
