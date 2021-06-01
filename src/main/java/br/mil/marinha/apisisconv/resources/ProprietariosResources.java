package br.mil.marinha.apisisconv.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Proprietarios;
import br.mil.marinha.apisisconv.dto.ProprietariosDTO;
import br.mil.marinha.apisisconv.services.ProprietariosServices;

@RestController
@RequestMapping("/proprietarios")
public class ProprietariosResources {
	
	@Autowired
	ProprietariosServices service;
	
	@Autowired
	VeiculosResources veiculoResource;
	
	@GetMapping
	public ResponseEntity<List<ProprietariosDTO>> findAll(){
		List<Proprietarios> p = service.findAll();
		return ResponseEntity.ok(createDtoList(p));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProprietariosDTO> findById(@PathVariable Long id){
		Proprietarios p = service.findById(id);
		return ResponseEntity.ok(createDto(p));
	}
	
	
	
	
	
	private List<ProprietariosDTO> createDtoList(List<Proprietarios> proprietarios){
		return proprietarios.stream().map(p -> createDto(p)).collect(Collectors.toList());	
	}
	
	private ProprietariosDTO createDto(Proprietarios p) {
		return new ProprietariosDTO(p.getPro_Id(), 
									p.getPro_Nome(), 
									p.getPro_NipCpf(), 
									p.getPro_Email(), 
									p.getPro_Cnh(), 
									p.getPro_Createdat(), 
									p.getPostoGraduacoes(), 
									p.getSetores(), 
									p.getTelefones(),
									veiculoResource.createDtoList(p.getVeiculos()), 
									p.getPro_Status(), 
									p.getPro_Observacao());
	}
}
