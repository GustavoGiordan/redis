package com.redis.redis.model;


import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.index.Indexed;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Objeto")
public class ObjetoRedis{
  
    @Id
    String id;

    private List<ResponseRedis> responses;
    
}
