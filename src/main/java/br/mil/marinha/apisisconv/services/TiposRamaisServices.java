package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.TiposRamais;
import br.mil.marinha.apisisconv.repositories.TiposRamaisRepository;

@Service
public class TiposRamaisServices {

	@Autowired
	TiposRamaisRepository repo;
	
	
	public List<TiposRamais> findAll(){
		return repo.findAll();
	}
	
	public TiposRamais findById(Long id) {
		Optional<TiposRamais> f = repo.findById(id);
		return f.orElse(null);
	}
}
