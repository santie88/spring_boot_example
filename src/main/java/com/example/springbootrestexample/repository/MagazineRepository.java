package com.example.springbootrestexample.repository;

import com.example.springbootrestexample.models.Magazine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MagazineRepository {

    private List<Magazine> magazines = new ArrayList<>();

    public Magazine createMagazine(Magazine magazine){
        magazines.add(magazine);
        return magazine;
    }

    public Magazine getMagazineByIsbn(String isbn){
        Magazine magazine = null;

        for (Magazine magazineList : magazines) {
            if(magazineList.getIsbn().equals(isbn)) {
                magazine = magazineList;
                break;
            }
        }

        return magazine;
    }

}
