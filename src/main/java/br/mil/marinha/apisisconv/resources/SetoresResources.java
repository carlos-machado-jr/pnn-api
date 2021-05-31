package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Setores;
import br.mil.marinha.apisisconv.services.SetoresServices;

@RestController
@RequestMapping("/setores")
public class SetoresResources {
	
	@Autowired
	SetoresServices service;
	
	@GetMapping
	public ResponseEntity<List<Setores>> findAll(){
		List<Setores> f = service.findAll();
		return ResponseEntity.ok(f);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Setores> findById(@PathVariable Long id){
		Setores f = service.findById(id);
		return ResponseEntity.ok(f);
	}
}
