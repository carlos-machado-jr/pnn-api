package br.mil.marinha.apisisconv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.CartaoEstacionamento;
import br.mil.marinha.apisisconv.repositories.CartaoEstacionamentoRepository;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;

@Service
public class CartaoEstacionamentoServices {
	
	@Autowired
	CartaoEstacionamentoRepository cartaoEstacionamentoRepository;
	
	public List<CartaoEstacionamento> findAll(){
		return cartaoEstacionamentoRepository.findAll();
	}
	
	public CartaoEstacionamento findById(Long id) {
		return cartaoEstacionamentoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cartão de estacionamento não encontrado"));
	}
	
	public CartaoEstacionamento findByDescription(String description) {
		return cartaoEstacionamentoRepository.findByDescription(description).orElseThrow(() -> new ObjectNotFoundException("Cartão de estacionamento não encontrado"));
	}
	
	
}
