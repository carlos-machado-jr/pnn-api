package br.mil.marinha.apisisconv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.marinha.apisisconv.domain.Setores;

@Repository
public interface SetoresRepository extends JpaRepository<Setores, Long>{

	Optional<Setores> findByDescription(String description);
}
