package com.example.springredisexample.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@RedisHash("Glober")
public class Glober implements Serializable {
    @Id
    private String id;
    private String fullName;
    private String project;
    private String studio;
}
