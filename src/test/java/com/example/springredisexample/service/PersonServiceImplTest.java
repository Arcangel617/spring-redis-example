package com.example.springredisexample.service;

import com.example.springredisexample.domain.Person;
import com.example.springredisexample.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl globerService;

    @Test
    void shouldFindfindAll() {
        when(personRepository.findAll()).thenReturn(globers());
        Map<String, Person> result = globerService.findAll();
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    private Map<String, Person> globers() {
        HashMap<String, Person> globers = new HashMap<>(0);
        globers.put("p56", Person.builder().id("p56").fullName("Arcangel Andres Artigue").build());
        return globers;
    }
}