package com.example.carro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carro.entities.Carro;
import com.example.carro.service.CarroService; 

@RestController
@RequestMapping("/carros")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	@GetMapping("/")
	public ResponseEntity <List<Carro>> carroList(){
		List<Carro> carros=carroService.getALl();
		
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
		
	}
	
	@GetMapping("/getCarro/{id}")
	public ResponseEntity <Carro> getCarro(@PathVariable("id") Integer id){
		Carro carro =carroService.getCarroById(id);
		
		if(carro==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carro);
		
	}
	@GetMapping("/getUserCarros/{id}")
	public ResponseEntity <List<Carro>> getUserCarros(@PathVariable("id") Integer id){
		
		List<Carro> carros=carroService.getCarroByUserId(id);
		
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	 
	@PostMapping("/")
	public ResponseEntity <Carro> saveCarro(@RequestBody Carro carro){
		Carro carroSaved =carroService.save(carro);
		return ResponseEntity.ok(carroSaved);
		 
	}
	
	

}
