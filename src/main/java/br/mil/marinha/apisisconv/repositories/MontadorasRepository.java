package br.mil.marinha.apisisconv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.marinha.apisisconv.domain.Montadoras;

@Repository
public interface MontadorasRepository extends JpaRepository<Montadoras, Long>{
	
	Optional<Montadoras> findByDescription(String description);
}
