package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Ramais;
import br.mil.marinha.apisisconv.repositories.RamaisRepository;

@Service
public class RamaisServices {
	

	@Autowired
	RamaisRepository repo;
	
	
	public List<Ramais> findAll(){
		return repo.findAll();
	}
	
	public Ramais findById(Long id) {
		Optional<Ramais> f = repo.findById(id);
		
		return f.orElse(null);
	}
	
	
	
	
	
}
