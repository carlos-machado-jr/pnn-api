package br.mil.marinha.apisisconv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.marinha.apisisconv.domain.TipoVeiculos;

@Repository
public interface TipoVeiculosRepository extends JpaRepository<TipoVeiculos, Long>{

	Optional<TipoVeiculos> findByDescription(String description);

}

