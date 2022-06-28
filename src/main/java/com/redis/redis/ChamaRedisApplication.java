package com.redis.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
public class ChamaRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChamaRedisApplication.class, args);
	}

}
