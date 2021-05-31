package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Setores;
import br.mil.marinha.apisisconv.repositories.SetoresRepository;

@Service
public class SetoresServices {
	

	@Autowired
	SetoresRepository repo;
	
	
	public List<Setores> findAll(){
		return repo.findAll();
	}
	
	public Setores findById(Long id) {
		Optional<Setores> f = repo.findById(id);
		return f.orElse(null);
	}
}
