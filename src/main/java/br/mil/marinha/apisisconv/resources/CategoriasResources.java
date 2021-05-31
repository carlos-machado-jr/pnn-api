package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Categorias;
import br.mil.marinha.apisisconv.services.CategoriasServices;

@RestController
@RequestMapping("/categorias")
public class CategoriasResources {
	
	@Autowired
	CategoriasServices service;
	
	
	@GetMapping
	public ResponseEntity<List<Categorias>> findAll() {
		List<Categorias> categorias = service.findAll();

		return ResponseEntity.ok(categorias);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> findById(@PathVariable Long id){
		Categorias c = service.findById(id);
		return ResponseEntity.ok(c);
	}
}
