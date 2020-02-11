package com.example.springredisexample.controller;

import com.example.springredisexample.domain.Glober;
import com.example.springredisexample.service.GloberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "example", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class GloberController {

    @Autowired
    private GloberService globerService;

    @GetMapping(path = "/globers")
    public ResponseEntity<Map<String, Glober>> findAll() {
        return ResponseEntity.ok(globerService.findAll());
    }

    @GetMapping(path = "/globers/{glober-id}")
    public ResponseEntity<Glober> findById(
            @PathVariable("glober-id") String globerId
    ) {
        return ResponseEntity.ok(globerService.findById(globerId));
    }

    @PutMapping(path = "/globers")
    public ResponseEntity<String> save(@RequestBody Glober glober) {
        String response = globerService.save(glober);
        return response.equals("CREATED")
                ? ResponseEntity.created(URI.create(String.format("/globers/%s", glober.getId()))).build()
                : ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/globers/{glober-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("glober-id") String globerId
    ) {
        globerService.delete(globerId);
        return ResponseEntity.noContent().build();
    }
}
