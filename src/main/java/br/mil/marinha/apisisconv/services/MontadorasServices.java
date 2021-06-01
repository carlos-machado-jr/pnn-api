package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Montadoras;
import br.mil.marinha.apisisconv.repositories.MontadorasRepository;

@Service
public class MontadorasServices {
	
	@Autowired
	MontadorasRepository repo;
	
	public List<Montadoras> findAll(){
		return repo.findAll();
	}
	
	public Montadoras findById(Long id) {
		Optional<Montadoras> m = repo.findById(id);
		return m.orElse(null);
	}
	
}
