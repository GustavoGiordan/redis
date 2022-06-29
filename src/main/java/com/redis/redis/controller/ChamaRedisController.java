package com.redis.redis.controller;

import java.util.*;
import java.util.stream.Stream;

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

@RestController
@RequestMapping(value="/redis")
public class ChamaRedisController {

	@Autowired
	private final ObjetoRepository objetoRepository;

	public ChamaRedisController(ObjetoRepository objetoRepository) {
		this.objetoRepository = objetoRepository;
	}

	@GetMapping("/buscaChaves/{chave}")
	public List<ObjetoRedis> listarClientes(@PathVariable("chave") String chave){


		ObjetoRedis objetoRedis = montaResponse(chave);

		Example<ObjetoRedis> customExampleMatcher = Example.of(objetoRedis,
				ExampleMatcher.matchingAll());

		List<ObjetoRedis> response = new ArrayList<>();
		objetoRepository.findAll().forEach(item -> {
			if(item.getId().contains(chave)){
				response.add(item);
			}
		});

		List<ObjetoRedis> response2 = new ArrayList<>();
		response
				.stream()
				.sorted((object1, object2) -> object1.getId().compareTo(object2.getId())).forEach(response2::add);

		return response2;

	}

	@GetMapping("/salvaChaves/{chave}")
	public ObjetoRedis listarClientesPorChave(@PathVariable("chave") String chave){

		return objetoRepository.save(montaResponse(chave));
	}

	private ObjetoRedis montaResponse(String chave){
		ResponseRedis response = new ResponseRedis();
		response.setId(chave);
		response.setNome(chave + "nome");
		response.setIdade(10);

		List<ResponseRedis> responses = new ArrayList<>();
		responses.add(response);

		ObjetoRedis objRedis =  new ObjetoRedis(chave, responses);

		return objRedis;
	}
}
