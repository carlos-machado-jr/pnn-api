package br.mil.marinha.apisisconv.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.PostoGraduacoes;
import br.mil.marinha.apisisconv.dto.PostoGraduacoesDTO;
import br.mil.marinha.apisisconv.services.PostoGraduacoesServices;

@RestController
@RequestMapping("/posto-graduacoes")
public class PostoGraduacoesResources {

	@Autowired
	PostoGraduacoesServices service;
	
	@GetMapping
	public ResponseEntity<Page<PostoGraduacoesDTO>> findAll(Pageable pageable){
		Page<PostoGraduacoesDTO> pg = transformInDto(service.findAll(pageable).toList());
		
		return ResponseEntity.ok(pg);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostoGraduacoesDTO> findById(@PathVariable Long id){
		PostoGraduacoesDTO postoGraduacoesDto = transformInDto(service.findById(id));
		
		return ResponseEntity.ok(postoGraduacoesDto);
	}
	
	
	
	
	private Page<PostoGraduacoesDTO> transformInDto(List<PostoGraduacoes> pg) {
		return new PageImpl<>( 
					pg.stream().map( p -> new PostoGraduacoesDTO(p.getId(), p.getDescription(), p.getCategorias(), p.getForcaMilitares()))
							   .collect(Collectors.toList()));
	}
	private PostoGraduacoesDTO transformInDto(PostoGraduacoes pg) {
		return new PostoGraduacoesDTO(pg.getId(), pg.getDescription(), pg.getCategorias(), pg.getForcaMilitares());
	}
}


