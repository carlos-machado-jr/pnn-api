package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.PostoGraduacoes;
import br.mil.marinha.apisisconv.repositories.PostoGraduacoesRepository;

@Service
public class PostoGraduacoesServices {
	
	@Autowired
	PostoGraduacoesRepository repo;
	
	public List<PostoGraduacoes> findAll(){
		return repo.findAll();
	}
	
	public PostoGraduacoes findById(Long id){
		Optional<PostoGraduacoes> pg = repo.findById(id);
		return pg.orElse(null);
	}
}
