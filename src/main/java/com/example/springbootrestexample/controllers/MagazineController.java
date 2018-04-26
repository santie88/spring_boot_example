package com.example.springbootrestexample.controllers;

import com.example.springbootrestexample.models.Magazine;
import com.example.springbootrestexample.repository.MagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magazine/")
public class MagazineController {

    @Autowired
    private MagazineRepository magazineRepository;

    @RequestMapping(value = "{isbn}", method = RequestMethod.GET)
    public Magazine getMagazine(@PathVariable("isbn") String isbn){
        return magazineRepository.getMagazineByIsbn(isbn);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Magazine postBook(@RequestBody Magazine magazine){
        return magazineRepository.createMagazine(magazine);
    }

}
