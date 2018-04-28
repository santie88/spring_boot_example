package com.example.springbootrestexample.models;

import java.util.Date;

public class Book extends ReadObject{

    private Date releaseDate;

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
