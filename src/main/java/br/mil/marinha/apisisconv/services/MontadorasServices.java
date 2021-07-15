package br.mil.marinha.apisisconv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Montadoras;
import br.mil.marinha.apisisconv.repositories.MontadorasRepository;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;

@Service
public class MontadorasServices {
	
	@Autowired
	MontadorasRepository repo;
	
	public List<Montadoras> findAll(){
		return repo.findAll();
	}
	
	public Montadoras findById(Long id) {
		return  repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Montadora não encontrada"));
		
	}
	
	public Montadoras findByDescription(String description) {
		return repo.findByDescription(description).orElseThrow(() -> new ObjectNotFoundException("Montadora não encontrada"));
	}
	
	
}
