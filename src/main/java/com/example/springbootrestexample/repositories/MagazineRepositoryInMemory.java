package com.example.springbootrestexample.repositories;

import com.example.springbootrestexample.models.Magazine;

import java.util.ArrayList;
import java.util.List;

public class MagazineRepositoryInMemory implements MagazineRepository {

    private List<Magazine> magazines = new ArrayList<>();

    public Magazine createMagazine(Magazine magazine){
        magazines.add(magazine);
        return magazine;
    }

    public Magazine getMagazineByIsbn(String isbn){
        return doGetMagazineByIsbn(isbn);
    }

    private Magazine doGetMagazineByIsbn(String isbn){
        return magazines.stream().filter(magazine -> magazine.getIsbn().equals(isbn)).findAny().get();
    }

}
