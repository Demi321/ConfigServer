package com.example.carro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.carro.entities.Carro;
import com.example.carro.repository.ICarroRepository;
 

@Service
public class CarroService {

	
	
	@Autowired
	private ICarroRepository carroRepository;
	
	
	
	public List<Carro>getALl(){
		return carroRepository.findAll();
	}
	
	public Carro getCarroById(Integer id) {
		return carroRepository.findById(id).orElse(null);
	}
	
	public Carro save(Carro user) {
		return carroRepository.save(user);
	}
	public List<Carro>getCarroByUserId(Integer id){
		return carroRepository.findByUserId(id);
	}
	
}
