package com.example.springredisexample.controller;

import com.example.springredisexample.domain.Glober;
import com.example.springredisexample.service.GloberService;
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
class GloberControllerTest {

    @Mock
    private GloberService globerService;

    @InjectMocks
    private GloberController globerController;

    @Test
    void shouldfindAllGlobers() {
        when(globerService.findAll()).thenReturn(new HashMap<>());
        ResponseEntity<Map<String, Glober>> result = globerController.findAll();
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void findById() {
        when(globerService.findById("p10")).thenReturn(Glober.builder().build());
        ResponseEntity<Glober> result = globerController.findById("p10");
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void shouldSaveGlober() {
        when(globerService.save(Glober.builder().build())).thenReturn("CREATED");
        ResponseEntity<String> result = globerController.save(Glober.builder().build());
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void shouldUpdateGlober() {
        when(globerService.save(Glober.builder().build())).thenReturn("UPDATED");
        ResponseEntity<String> result = globerController.save(Glober.builder().build());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void shouldDeleteGlober() {
        ResponseEntity<Void> result = globerController.delete("p10");
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }

}