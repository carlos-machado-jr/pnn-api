package br.mil.marinha.apisisconv.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Veiculos;
import br.mil.marinha.apisisconv.dto.ViewVeiculosDTO;
import br.mil.marinha.apisisconv.services.VeiculosServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/veiculos")
@Api("veiculos")
@CrossOrigin(origins = "*")
public class VeiculosResources {
	
	@Autowired
	VeiculosServices service;
	
	@ApiOperation("lista os veiculos")
	@GetMapping
	public ResponseEntity<Page<ViewVeiculosDTO>> findAll(){
		Page<ViewVeiculosDTO> v = transformInDto(service.findAll());
		return ResponseEntity.ok(v);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ViewVeiculosDTO> findById(@PathVariable Long id){
		ViewVeiculosDTO v = transformInDto(service.findById(id));
		return ResponseEntity.ok(v);
	}
	
	
	
	
	
	
	
	private Page<ViewVeiculosDTO> transformInDto(List<Veiculos> veiculos){
		return new PageImpl<>(veiculos.stream().map(v -> new ViewVeiculosDTO(v)).collect(Collectors.toList()));
	}
	
	private ViewVeiculosDTO transformInDto(Veiculos veiculos){
		return new ViewVeiculosDTO(veiculos);
	}
}
