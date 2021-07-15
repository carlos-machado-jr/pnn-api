package br.mil.marinha.apisisconv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Setores;
import br.mil.marinha.apisisconv.repositories.SetoresRepository;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;

@Service
public class SetoresServices {
	

	@Autowired
	SetoresRepository repo;
	
	
	public List<Setores> findAll(){
		return repo.findAll();
	}
	
	public Setores findById(Long id) {
		Setores setores = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Setor não encontrado!"));
		return setores;
	}
	
	public Setores findByDescription(String description) {
		Setores setores = repo.findByDescription(description).orElseThrow(() -> new ObjectNotFoundException("Setor não encontrado!"));
		return setores;
	}
}
