package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Veiculos;
import br.mil.marinha.apisisconv.repositories.VeiculosRepository;

@Service
public class VeiculosServices {
	@Autowired
	VeiculosRepository repo;
	
	
	public List<Veiculos> findAll(){
		return repo.findAll();
	}
	
	public Veiculos findById(Long id) {
		Optional<Veiculos> v = repo.findById(id);
		
		return v.orElse(null);
	}
}
