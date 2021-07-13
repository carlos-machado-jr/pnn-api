package br.mil.marinha.apisisconv.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Proprietarios;
import br.mil.marinha.apisisconv.dto.ViewProprietariosDTO;
import br.mil.marinha.apisisconv.services.ProprietariosServices;

@RestController
@RequestMapping("/proprietarios")
public class ProprietariosResources {
	
	@Autowired
	ProprietariosServices service;
	
	@Autowired
	VeiculosResources veiculoResource;
	
	@GetMapping
	public ResponseEntity<Page<ViewProprietariosDTO>> findAll(){
		Page<ViewProprietariosDTO> p = transformInDto(service.findAll());
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ViewProprietariosDTO> findById(@PathVariable Long id){
		ViewProprietariosDTO p = transformInDto(service.findById(id));
		return ResponseEntity.ok(p);
	}
	
	
	
	

	
	private Page<ViewProprietariosDTO> transformInDto(List<Proprietarios> proprietarios){
		return new PageImpl<>(proprietarios.stream().map(p -> new ViewProprietariosDTO(p)).collect(Collectors.toList()));
	}
	
	private ViewProprietariosDTO transformInDto(Proprietarios proprietarios){
		return new ViewProprietariosDTO(proprietarios);
	}
}
