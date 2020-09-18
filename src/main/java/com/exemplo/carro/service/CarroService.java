package com.exemplo.carro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.carro.model.Carro;
import com.exemplo.carro.repository.CarroRepository;
import java.util.Optional;

@Service 
public class CarroService {
	
	@Autowired
	private CarroRepository repository; 
	
	public List<Carro> findAll() {
		return repository.findAll(); 
	}
	
	public Carro findOne(Long id) {
                Optional<Carro> carro = repository.findById(id);
		return carro.isPresent()? carro.get() : null;
	}
	
	public Carro save(Carro carro) {
		return repository.saveAndFlush(carro);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
