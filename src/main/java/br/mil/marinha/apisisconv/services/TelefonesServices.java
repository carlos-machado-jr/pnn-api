package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Telefones;
import br.mil.marinha.apisisconv.repositories.TelefonesRepository;

@Service
public class TelefonesServices {

	@Autowired
	TelefonesRepository repo;
	
	
	public List<Telefones> findAll(){
		return repo.findAll();
	}
	
	public Telefones findById(Long id) {
		Optional<Telefones> f = repo.findById(id);
		
		return f.orElse(null);
	}
}
