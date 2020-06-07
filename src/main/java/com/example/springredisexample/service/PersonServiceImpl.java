package com.example.springredisexample.service;

import com.example.springredisexample.domain.Person;
import com.example.springredisexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Map<String, Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(String globerId) {
        return personRepository.findById(globerId);
    }

    @Override
    public String save(Person person) {
        return personRepository.existById(person.getId())
                ? updateGlober(person)
                : saveGlober(person);
    }

    @Override
    public void delete(String globerId) {
        personRepository.delete(globerId);
    }

    private String saveGlober(Person person) {
        personRepository.save(person);
        return "CREATED";
    }

    private String updateGlober(Person person) {
        personRepository.save(person);
        return "UPDATED";
    }
}
