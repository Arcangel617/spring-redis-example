package com.example.springredisexample.repository;

import com.example.springredisexample.domain.Person;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private static final String KEY = "Glober";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Person> hashOperations;

    public PersonRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Person> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Person findById(String globerId) {
        return hashOperations.get(KEY, globerId);
    }

    @Override
    public void save(Person person) {
        hashOperations.put(KEY, person.getId(), person);
    }

    @Override
    public void delete(String globerId) {
        hashOperations.delete(KEY, globerId);
    }

    @Override
    public boolean existById(String globerId) {
        return hashOperations.hasKey(KEY, globerId);
    }
}
