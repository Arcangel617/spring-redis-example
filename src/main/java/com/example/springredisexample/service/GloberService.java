package com.example.springredisexample.service;

import com.example.springredisexample.domain.Glober;

import java.util.Map;

public interface GloberService {
    Map<String, Glober> findAll();
    Glober findById(String globerId);
    String save(Glober glober);
    void delete(String globerId);
}
