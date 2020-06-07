package com.example.springredisexample.service;

import com.example.springredisexample.domain.Person;

import java.util.Map;

public interface PersonService {
    Map<String, Person> findAll();
    Person findById(String globerId);
    String save(Person person);
    void delete(String globerId);
}
