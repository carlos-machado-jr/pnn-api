package br.mil.marinha.apisisconv.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.Veiculos;
import br.mil.marinha.apisisconv.dto.VeiculosDTO;
import br.mil.marinha.apisisconv.services.VeiculosServices;

@RestController
@RequestMapping("/veiculos")
public class VeiculosResources {
	
	@Autowired
	VeiculosServices service;
	
	@GetMapping
	public ResponseEntity<List<VeiculosDTO>> findAll(){
		List<Veiculos> v = service.findAll();
		return ResponseEntity.ok(createDtoList(v));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VeiculosDTO> findById(@PathVariable Long id){
		Veiculos v = service.findById(id);
		return ResponseEntity.ok(createDto(v));
	}
	
	
	
	
	
	protected List<VeiculosDTO> createDtoList(List<Veiculos> veiculos){
		return veiculos.stream().map(v -> createDto(v))
					 .collect(Collectors.toList());	
	}
	
	protected VeiculosDTO createDto(Veiculos v) {
		return new VeiculosDTO(v.getVei_Id(), 
							   v.getVei_Modelo(), 
							   v.getVei_Ano(), 
							   v.getVei_Placa(), 
							   v.getVei_Cor(),
							   v.getTipo_Veiculos(), 
							   v.getMontadoras(), 
							   v.getVei_Status(), 
							   v.getVei_Createdat(), 
							   v.getVei_Observacao());
	}
}
