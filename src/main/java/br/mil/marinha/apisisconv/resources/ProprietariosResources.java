package br.mil.marinha.apisisconv.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.mil.marinha.apisisconv.domain.Proprietarios;
import br.mil.marinha.apisisconv.dto.NewProprietariosDTO;
import br.mil.marinha.apisisconv.dto.ViewProprietariosDTO;
import br.mil.marinha.apisisconv.services.ProprietariosServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/proprietarios")
@Api("proprietarios")
@CrossOrigin(origins = "*")
public class ProprietariosResources {
	
	@Autowired
	ProprietariosServices proprietariosService;
	
	@ApiOperation("lista os proprietarios")
	@GetMapping
	public ResponseEntity<Page<ViewProprietariosDTO>> findAll(Pageable pageable){
		Page<ViewProprietariosDTO> proprietarioDto = transformInDto(proprietariosService.findAll(pageable).toList());
		return ResponseEntity.ok(proprietarioDto);
	}
	
	
	@ApiOperation("pesquisa dinamica pelo proprietario")
	@GetMapping("/search")
	public ResponseEntity<Page<ViewProprietariosDTO>> findAll(@RequestParam(required = false) boolean status,
															  @RequestParam(required = false) String name,
															  @RequestParam(required = false) String nipOrCpf,
															  @RequestParam(required = false) String email,
															  Pageable pageable){
		Page<ViewProprietariosDTO> proprietarioDto = transformInDto(proprietariosService.search(status, name, nipOrCpf, email, pageable).toList());
		return ResponseEntity.ok(proprietarioDto);
	}
	
	
	@ApiOperation("busca o proprietario pelo id")
	@GetMapping("/{id}")
	public ResponseEntity<ViewProprietariosDTO> findById(@PathVariable Long id){
		ViewProprietariosDTO proprietarioDto = transformInDto(proprietariosService.findById(id));
		return ResponseEntity.ok(proprietarioDto);
	}
	
	@ApiOperation("salva o proprietario")
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody NewProprietariosDTO newProprietariosDto){
		
		Proprietarios proprietarios = proprietariosService.save(newProprietariosDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proprietarios.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	
	
	

	
	private Page<ViewProprietariosDTO> transformInDto(List<Proprietarios> proprietarios){
		return new PageImpl<>(proprietarios.stream().map(p -> new ViewProprietariosDTO(p)).collect(Collectors.toList()));
	}
	
	private ViewProprietariosDTO transformInDto(Proprietarios proprietarios){
		return new ViewProprietariosDTO(proprietarios);
	}
}
