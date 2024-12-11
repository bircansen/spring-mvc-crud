package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Footballer;
import com.example.demo.repository.FootballerRepository;

@Service
public class FootballerServiceImpl implements FootballerService {

    @Autowired
    private FootballerRepository footballerRepository;

    @Override
    public List<Footballer> getAllFootballers() {
        return footballerRepository.findAll();
    }

    @Override
    public void saveFootballer(Footballer footballer) {
        this.footballerRepository.save(footballer);
    }

    @Override
    public Footballer getFootballerById(long id) {
        Optional<Footballer> optional = footballerRepository.findById(id);
        Footballer footballer = null;
        if (optional.isPresent()) {
            footballer = optional.get();
        } else {
            throw new RuntimeException(id + " id numarasına sahip futbolcu bulunamadı ");
        }
        return footballer;
    }

    @Override
    public void deleteFootballerById(long id) {
        this.footballerRepository.deleteById(id);
    }
}