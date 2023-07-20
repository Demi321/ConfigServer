package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Carro;
import com.example.demo.entidades.User;
import com.example.demo.feign.ICarroFeign;
import com.example.demo.repository.IUserRepository;

@Service
public class UserService {
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ICarroFeign carroFeign;
	
public List<Carro>getCarrosByUser(Integer userId){
 
	List<Carro> carros=restTemplate.getForObject("http://localhost:8081/carros/getUserCarros/"+userId, List.class);
	return carros;
	}
	
	public Carro saveCarro(Integer userId,Carro carro) {
		carro.setUserId(userId);
		Carro carroRes=this.carroFeign.save(carro);
		return carroRes;
		
	}
	public List<User>getALl(){
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
}
