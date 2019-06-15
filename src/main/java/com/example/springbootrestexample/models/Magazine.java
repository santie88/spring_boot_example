package com.example.springbootrestexample.models;

public class Magazine extends ReadObject {

    private String description;

    public Magazine() {
    }

    public Magazine(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
