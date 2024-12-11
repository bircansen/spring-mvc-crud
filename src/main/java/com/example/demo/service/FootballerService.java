package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Footballer;

public interface FootballerService {
    List<Footballer> getAllFootballers();
    void saveFootballer(Footballer footballer);
    Footballer getFootballerById(long id);
    void deleteFootballerById(long id);
}