package com.example.springredisexample.service;

import com.example.springredisexample.domain.Glober;
import com.example.springredisexample.repository.GloberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GloberServiceImpl implements GloberService {
    @Autowired
    private GloberRepository globerRepository;

    @Override
    public Map<String, Glober> findAll() {
        return globerRepository.findAll();
    }

    @Override
    public Glober findById(String globerId) {
        return globerRepository.findById(globerId);
    }

    @Override
    public String save(Glober glober) {
        return globerRepository.existById(glober.getId())
                ? updateGlober(glober)
                : saveGlober(glober);
    }

    @Override
    public void delete(String globerId) {
        globerRepository.delete(globerId);
    }

    private String saveGlober(Glober glober) {
        globerRepository.save(glober);
        return "CREATED";
    }

    private String updateGlober(Glober glober) {
        globerRepository.save(glober);
        return "UPDATED";
    }
}
