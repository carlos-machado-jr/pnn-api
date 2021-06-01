package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Proprietarios;
import br.mil.marinha.apisisconv.repositories.ProprietariosRepository;

@Service
public class ProprietariosServices {
	
	@Autowired
	ProprietariosRepository repo;
	
	
	public List<Proprietarios> findAll(){
		return repo.findAll();
	}
	
	public Proprietarios findById(Long id) {
		Optional<Proprietarios> f = repo.findById(id);
		
		return f.orElse(null);
	}
	
	
	
}
