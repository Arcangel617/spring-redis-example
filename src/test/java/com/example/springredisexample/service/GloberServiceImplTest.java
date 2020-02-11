package com.example.springredisexample.service;

import com.example.springredisexample.domain.Glober;
import com.example.springredisexample.repository.GloberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GloberServiceImplTest {

    @Mock
    private GloberRepository globerRepository;

    @InjectMocks
    private GloberServiceImpl globerService;

    @Test
    void shouldFindfindAll() {
        when(globerRepository.findAll()).thenReturn(globers());
        Map<String, Glober> result = globerService.findAll();
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

    private Map<String, Glober> globers() {
        HashMap<String, Glober> globers = new HashMap<>(0);
        globers.put("p56", Glober.builder().id("p56").fullName("Arcangel Andres Artigue").build());
        return globers;
    }
}