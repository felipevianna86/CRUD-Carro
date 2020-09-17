package com.exemplo.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.carro.model.Carro;

@Repository //Define a classe como um bean do Spring
public interface CarroRepository extends JpaRepository<Carro, Long> { 

} 
