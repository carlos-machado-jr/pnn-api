package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.OrganizacoesMilitares;
import br.mil.marinha.apisisconv.repositories.OrganizacoesMilitaresRepository;

@Service
public class OrganizacoesMilitaresServices {

	@Autowired
	OrganizacoesMilitaresRepository repo;
	
	
	public List<OrganizacoesMilitares> findAll(){
		return repo.findAll();
	}
	
	public OrganizacoesMilitares findById(Long id) {
		Optional<OrganizacoesMilitares> f = repo.findById(id);
		return f.orElse(null);
	}
}
