package com.example.springbootrestexample.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ReadObject {

    @Id
    private String id;
    private String isbn;
    private String name;
    private Author author;
    private LocalDateTime lastCheck;
}
