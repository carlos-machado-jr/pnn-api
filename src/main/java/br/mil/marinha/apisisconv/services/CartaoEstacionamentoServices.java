package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.CartaoEstacionamento;
import br.mil.marinha.apisisconv.repositories.CartaoEstacionamentoRepository;

@Service
public class CartaoEstacionamentoServices {
	
	@Autowired
	CartaoEstacionamentoRepository repo;
	
	public List<CartaoEstacionamento> findAll(){
		return repo.findAll();
	}
	
	public CartaoEstacionamento findById(Long id) {
		Optional<CartaoEstacionamento> c = repo.findById(id);
		return c.orElse(null);
	}
	
	
	
	
}
