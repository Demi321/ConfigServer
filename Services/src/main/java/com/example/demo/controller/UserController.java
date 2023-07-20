package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.User;
import com.example.demo.model.Carro;
import com.example.demo.service.UserService;
 

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public ResponseEntity <List<User>> userList(){
		List<User> users=userService.getALl();
		
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
		
	}
	@GetMapping("/getUserCars/{userId}")
	public ResponseEntity <List<Carro>> getCarrosByUser(@PathVariable("userId") Integer userId){
		System.out.print("ID RECIBIDO "+userId);
		List<Carro> carros=userService.getCarrosByUser(userId);
		
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
		
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity <User> getUser(@PathVariable("id") Integer id){
		User user =userService.getUserById(id);
		
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
		
	}
	
	@PostMapping("/")
	public ResponseEntity <User> saveUser(@RequestBody User user){
		User userSaved =userService.save(user);
		return ResponseEntity.ok(user);
		 
	}
	
	@PostMapping("/saveCarroFeign/{userId}")
	public ResponseEntity <Carro> saveCarroFeign(
			@PathVariable("userId")Integer userId, 
			@RequestBody Carro carro){
		
		Carro newCarro =userService.saveCarro(userId,carro);
		return ResponseEntity.ok(newCarro);
		 
	}
}









