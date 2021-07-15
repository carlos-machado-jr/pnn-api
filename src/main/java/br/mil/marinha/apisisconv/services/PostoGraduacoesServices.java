package br.mil.marinha.apisisconv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.ForcasMilitares;
import br.mil.marinha.apisisconv.domain.PostoGraduacoes;
import br.mil.marinha.apisisconv.repositories.PostoGraduacoesRepository;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;
import br.mil.marinha.apisisconv.services.specifications.PostoGraduacoesServicesSpecifications;

@Service
public class PostoGraduacoesServices extends PostoGraduacoesServicesSpecifications {
	
	@Autowired
	PostoGraduacoesRepository postoGraduacoesRepository;
	
	public Page<PostoGraduacoes> findAll(Pageable pageable){
		return postoGraduacoesRepository.findAll(pageable);
	}
	
	public Page<PostoGraduacoes> search(String forcaMilitares, String categorias, Pageable pageable){
		return postoGraduacoesRepository.findAll(searchBy(forcaMilitares, categorias), pageable);
	}
	
	public PostoGraduacoes findById(Long id){
		PostoGraduacoes pg = postoGraduacoesRepository.findById(id)
				                 .orElseThrow(() -> new ObjectNotFoundException("Posto não encontrado"));
		return pg;
	}
	
	public PostoGraduacoes findByDescriptionAndForcaMilitares(String description, ForcasMilitares forcasMilitares){
		PostoGraduacoes pg = postoGraduacoesRepository.findByDescriptionAndForcaMilitares(description, forcasMilitares)
				                 .orElseThrow(() -> new ObjectNotFoundException("Posto não encontrado"));
		return pg;
	}
	
	
	
}
