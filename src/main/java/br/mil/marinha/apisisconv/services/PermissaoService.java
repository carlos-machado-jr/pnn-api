package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Permissoes;
import br.mil.marinha.apisisconv.repositories.PermissaoRepository;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;

@Service
public class PermissaoService {

	@Autowired
	PermissaoRepository repo;
	
	public List<Permissoes> findAll(){
		return repo.findAll();
	}
	
	public Permissoes findByDescricao(String desc) {
		Optional<Permissoes> p = repo.findByDescricao(desc);
		return p.orElseThrow(() -> ObjectNotFound(desc));
	}
	
	

	
	private ObjectNotFoundException ObjectNotFound(String desc) {
		return new ObjectNotFoundException("Permissao do tipo: "+ desc + " não encontrada!");
	}
}
