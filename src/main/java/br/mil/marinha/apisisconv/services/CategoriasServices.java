package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Categorias;
import br.mil.marinha.apisisconv.repositories.CategoriasRepository;

@Service
public class CategoriasServices {
	
	@Autowired
	CategoriasRepository repo;
	
	public List<Categorias> findAll(){
		return repo.findAll();
	}
	
	public Categorias findById(Long id) {
		Optional<Categorias> categorias = repo.findById(id);
		return categorias.orElse(null);
	}
	
	
	
	
	
	

}
