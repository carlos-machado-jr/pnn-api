package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Montadoras;
import br.mil.marinha.apisisconv.services.MontadorasServices;

@RestController
@RequestMapping("/montadoras")
public class MontadorasResources {

	@Autowired
	MontadorasServices service;
	
	
	@GetMapping
	public ResponseEntity<List<Montadoras>> findAll() {
		List<Montadoras> m = service.findAll();

		return ResponseEntity.ok(m);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Montadoras> findById(@PathVariable Long id){
		Montadoras m = service.findById(id);
		return ResponseEntity.ok(m);
	}
}
