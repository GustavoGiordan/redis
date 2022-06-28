package com.redis.redis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.redis.redis.model.ObjetoRedis;
import com.redis.redis.model.ResponseRedis;
import com.redis.redis.repository.ObjetoRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ObjetoCacheServiceImpl implements ObjetoCacheService{

    private final ObjetoRepository objetoRepository;

    @Override
    public List<ResponseRedis> findByIdContainingIgnoreCase(String s) {
        
        return objetoRepository.findById(s)
        .map(ObjetoRedis::getResponses)
        .orElse(new ArrayList<>());

    }
    
}
