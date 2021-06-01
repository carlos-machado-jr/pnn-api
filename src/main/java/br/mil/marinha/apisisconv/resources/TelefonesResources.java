package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Telefones;
import br.mil.marinha.apisisconv.services.TelefonesServices;

@RestController
@RequestMapping("/telefones")
public class TelefonesResources {
	
	@Autowired
	TelefonesServices service;
	
	@GetMapping
	public ResponseEntity<List<Telefones>> findAll(){
		List<Telefones> t = service.findAll();
		return ResponseEntity.ok(t);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Telefones> findById(@PathVariable Long id){
		Telefones t = service.findById(id);
		return ResponseEntity.ok(t);
	}
}
