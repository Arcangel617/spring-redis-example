package com.example.springredisexample.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@RedisHash("Person")
public class Person implements Serializable {
    @Id
    private String id;
    private String fullName;
    private String address;
}
