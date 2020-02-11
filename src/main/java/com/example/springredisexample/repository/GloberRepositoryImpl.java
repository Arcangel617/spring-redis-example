package com.example.springredisexample.repository;

import com.example.springredisexample.domain.Glober;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class GloberRepositoryImpl implements GloberRepository {

    private static final String KEY = "Glober";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Glober> hashOperations;

    public GloberRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Glober> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Glober findById(String globerId) {
        return hashOperations.get(KEY, globerId);
    }

    @Override
    public void save(Glober glober) {
        hashOperations.put(KEY, glober.getId(), glober);
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
