package com.redis.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.redis.redis.model.ObjetoRedis;

import java.util.List;


@Repository
public interface ObjetoRepository extends CrudRepository<ObjetoRedis, String>, QueryByExampleExecutor<ObjetoRedis> {

    List<ObjetoRedis> findByIdContainingIgnoreCase(String s);

}