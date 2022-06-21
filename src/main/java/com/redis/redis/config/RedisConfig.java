package com.redis.redis.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConfig {

    private static final  JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost", 6379);

    public static Jedis getRedis(){
        return pool.getResource();
    }
    
}
