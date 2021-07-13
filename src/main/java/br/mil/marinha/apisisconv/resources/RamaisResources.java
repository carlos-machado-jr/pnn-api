package br.mil.marinha.apisisconv.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Ramais;
import br.mil.marinha.apisisconv.dto.RamaisDTO;
import br.mil.marinha.apisisconv.services.RamaisServices;

@RestController
@RequestMapping("/ramais")
public class RamaisResources {

	@Autowired
	RamaisServices service;
	
	@GetMapping
	public ResponseEntity<List<RamaisDTO>> findAll(){
		List<Ramais> r = service.findAll();
		return ResponseEntity.ok(createDtoList(r));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RamaisDTO> findById(@PathVariable Long id){
		Ramais r = service.findById(id);
		return ResponseEntity.ok(createDto(r));
	}
	
	
	
	
	
	private List<RamaisDTO> createDtoList(List<Ramais> ramais){
		return ramais.stream().map(r -> new RamaisDTO(r.getId(), r.getDescription(), r.getSetores(), r.getTipoRamais(), r.getOrganizacoesMilitares()))
					 .collect(Collectors.toList());	
	}
	
	private RamaisDTO createDto(Ramais r) {
		return new RamaisDTO(r.getId(), r.getDescription(), r.getSetores(), r.getTipoRamais(), r.getOrganizacoesMilitares());
	}
}
