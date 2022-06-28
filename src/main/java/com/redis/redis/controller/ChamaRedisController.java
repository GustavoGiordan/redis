package com.redis.redis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.redis.redis.model.ObjetoRedis;
import com.redis.redis.model.ResponseRedis;
import com.redis.redis.repository.ObjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@RestController
@RequestMapping(value="/redis")
public class ChamaRedisController {

	@Autowired
	private final ObjetoRepository objetoRepository;

	public ChamaRedisController(ObjetoRepository objetoRepository) {
		this.objetoRepository = objetoRepository;
	}

	@GetMapping("/buscaChaves/{chave}")
	public List<List<ResponseRedis>> listarClientes(@PathVariable("chave") String chave){


		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher(chave, contains());

		ObjetoRedis objetoRedis = new ObjetoRedis();

		Example<ObjetoRedis> example = Example.of(objetoRedis, matcher);
		objetoRepository.findAll(example);

		Iterable<ObjetoRedis> it = objetoRepository.findAll(example);
		List<List<ResponseRedis>> response = new ArrayList<>();

		it.forEach(item -> {
			response.add(item.getResponses());
		});

		return response;
	
	}

	@GetMapping("/salvaChaves/{chave}")
	public ObjetoRedis listarClientesPorChave(@PathVariable("chave") String chave){
		ResponseRedis response = new ResponseRedis();
		response.setId(chave);
		response.setNome(chave + "nome");
		response.setIdade(10);

		List<ResponseRedis> responses = new ArrayList<>();
		responses.add(response);

		ObjetoRedis objRedis =  new ObjetoRedis(UUID.randomUUID().toString(),responses);

		return objetoRepository.save(objRedis);
	}
}
