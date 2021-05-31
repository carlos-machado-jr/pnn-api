package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.ForcasMilitares;
import br.mil.marinha.apisisconv.repositories.ForcasMilitaresRepository;

@Service
public class ForcasMilitaresServices {
	
	@Autowired
	ForcasMilitaresRepository repo;
	
	
	public List<ForcasMilitares> findAll(){
		return repo.findAll();
	}
	
	public ForcasMilitares findById(Long id) {
		Optional<ForcasMilitares> f = repo.findById(id);
		return f.orElse(null);
	}
}
