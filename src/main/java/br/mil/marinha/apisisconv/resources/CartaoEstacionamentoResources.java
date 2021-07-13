package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.CartaoEstacionamento;
import br.mil.marinha.apisisconv.services.CartaoEstacionamentoServices;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/cartao-estacionamento")
@Api("Cartão de estacionamento")
@CrossOrigin(origins = "*")
public class CartaoEstacionamentoResources {
	
	@Autowired
	CartaoEstacionamentoServices service;
	
	
	@GetMapping
	public ResponseEntity<List<CartaoEstacionamento>> findAll() {
		List<CartaoEstacionamento> c = service.findAll();

		return ResponseEntity.ok(c);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CartaoEstacionamento> findById(@PathVariable Long id){
		CartaoEstacionamento c = service.findById(id);
		return ResponseEntity.ok(c);
	}
}
