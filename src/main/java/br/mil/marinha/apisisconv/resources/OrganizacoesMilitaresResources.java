package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.OrganizacoesMilitares;
import br.mil.marinha.apisisconv.services.OrganizacoesMilitaresServices;

@RestController
@RequestMapping("/organizacoes-militares")
public class OrganizacoesMilitaresResources {
	
	@Autowired
	OrganizacoesMilitaresServices service;
	
	@GetMapping
	public ResponseEntity<List<OrganizacoesMilitares>> findAll(){
		List<OrganizacoesMilitares> f = service.findAll();
		return ResponseEntity.ok(f);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrganizacoesMilitares> findById(@PathVariable Long id){
		OrganizacoesMilitares f = service.findById(id);
		return ResponseEntity.ok(f);
	}
}
