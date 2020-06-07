package com.example.springredisexample.repository;

import com.example.springredisexample.domain.Person;

import java.util.Map;

public interface PersonRepository {
    Map<String, Person> findAll();
    Person findById(String globerId);
    void save(Person person);
    void delete(String globerId);
    boolean existById(String globerId);
}
