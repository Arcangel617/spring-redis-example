package com.example.springredisexample.controller;

import com.example.springredisexample.domain.Person;
import com.example.springredisexample.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @Test
    void shouldfindAllGlobers() {
        when(personService.findAll()).thenReturn(new HashMap<>());
        ResponseEntity<Map<String, Person>> result = personController.findAll();
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void findById() {
        when(personService.findById("p10")).thenReturn(Person.builder().build());
        ResponseEntity<Person> result = personController.findById("p10");
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void shouldSaveGlober() {
        when(personService.save(Person.builder().build())).thenReturn("CREATED");
        ResponseEntity<String> result = personController.save(Person.builder().build());
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void shouldUpdateGlober() {
        when(personService.save(Person.builder().build())).thenReturn("UPDATED");
        ResponseEntity<String> result = personController.save(Person.builder().build());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void shouldDeleteGlober() {
        ResponseEntity<Void> result = personController.delete("p10");
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }

}