package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.TipoVeiculos;
import br.mil.marinha.apisisconv.services.TipoVeiculosServices;

@RestController
@RequestMapping("/tipo-veiculos")
public class TipoVeiculosResources {
	
	@Autowired
	TipoVeiculosServices service;
	
	
	@GetMapping
	public ResponseEntity<List<TipoVeiculos>> findAll() {
		List<TipoVeiculos> t = service.findAll();

		return ResponseEntity.ok(t);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoVeiculos> findById(@PathVariable Long id){
		TipoVeiculos t = service.findById(id);
		return ResponseEntity.ok(t);
	}
}
