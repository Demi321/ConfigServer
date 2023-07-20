package com.example.carro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carro.entities.Carro;

@Repository
public interface ICarroRepository extends JpaRepository<Carro,Integer>{
	
	List<Carro> findByUserId(Integer id);

}
