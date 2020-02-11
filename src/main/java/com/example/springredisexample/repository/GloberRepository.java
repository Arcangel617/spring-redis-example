package com.example.springredisexample.repository;

import com.example.springredisexample.domain.Glober;

import java.util.Map;

public interface GloberRepository {
    Map<String, Glober> findAll();
    Glober findById(String globerId);
    void save(Glober glober);
    void delete(String globerId);
    boolean existById(String globerId);
}
