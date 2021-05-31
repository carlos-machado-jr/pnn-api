package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.TiposRamais;
import br.mil.marinha.apisisconv.services.TiposRamaisServices;

@RestController
@RequestMapping("/tipos-ramais")
public class TiposRamaisResources {
	
	@Autowired
	TiposRamaisServices service;
	
	@GetMapping
	public ResponseEntity<List<TiposRamais>> findAll(){
		List<TiposRamais> f = service.findAll();
		return ResponseEntity.ok(f);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TiposRamais> findById(@PathVariable Long id){
		TiposRamais f = service.findById(id);
		return ResponseEntity.ok(f);
	}
}
