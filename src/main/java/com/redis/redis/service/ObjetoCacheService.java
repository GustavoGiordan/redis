package com.redis.redis.service;

import java.util.List;

import com.redis.redis.model.ResponseRedis;


public interface ObjetoCacheService{


    List<ResponseRedis> findByIdContainingIgnoreCase(String s);
}