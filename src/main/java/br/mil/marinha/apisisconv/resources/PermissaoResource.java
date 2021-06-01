package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Permissoes;
import br.mil.marinha.apisisconv.services.PermissaoService;

@RestController
@RequestMapping("/permissoes")
public class PermissaoResource {
	
	@Autowired
	PermissaoService service;
	
	@PreAuthorize("hasAnyRole('Administrador')")
	@GetMapping
	public ResponseEntity<List<Permissoes>> findAll(){
		List<Permissoes> listPermissoes = service.findAll();
		return ResponseEntity.ok(listPermissoes);
	}
}
