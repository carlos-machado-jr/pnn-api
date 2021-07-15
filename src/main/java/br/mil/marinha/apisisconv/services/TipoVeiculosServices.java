package br.mil.marinha.apisisconv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.TipoVeiculos;
import br.mil.marinha.apisisconv.repositories.TipoVeiculosRepository;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;

@Service
public class TipoVeiculosServices {
	
	@Autowired
	TipoVeiculosRepository repo;
	
	public List<TipoVeiculos> findAll(){
		return repo.findAll();
	}
	
	public TipoVeiculos findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Tipo de veículo não encontrado"));
		
	}
	
	public TipoVeiculos findByDescription(String description) {
		return repo.findByDescription(description).orElseThrow(() -> new ObjectNotFoundException("Tipo de veículo não encontrado"));
	}
}
