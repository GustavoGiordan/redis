package com.redis.redis.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import com.redis.redis.config.RedisConfig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;

@RestController
@RequestMapping(value="/redis")
public class ChamaRedisController {

	private Jedis jedis = RedisConfig.getRedis();

    @GetMapping("/buscaChaves")
	public ArrayList<String> listarClientes(){

		ArrayList<String> keysList = new ArrayList<>();
		try{
			Set<String> keys = jedis.keys("*");

			Iterator<String> it = keys.iterator();

			while (it.hasNext()) {
				String chave = it.next();
				String valor = jedis.get(chave);
				System.out.println("Chave: " + chave + " Valor: " + valor);
				keysList.add(chave +":"+ valor);
			}
		} finally{
			jedis.close();
		}

		return keysList;
	}
    
}
