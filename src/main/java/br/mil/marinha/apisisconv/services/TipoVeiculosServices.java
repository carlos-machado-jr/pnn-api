package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.TipoVeiculos;
import br.mil.marinha.apisisconv.repositories.TipoVeiculosRepository;

@Service
public class TipoVeiculosServices {
	
	@Autowired
	TipoVeiculosRepository repo;
	
	public List<TipoVeiculos> findAll(){
		return repo.findAll();
	}
	
	public TipoVeiculos findById(Long id) {
		Optional<TipoVeiculos> t = repo.findById(id);
		return t.orElse(null);
	}
	
}
