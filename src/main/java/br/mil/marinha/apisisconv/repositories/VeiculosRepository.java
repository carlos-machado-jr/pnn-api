package br.mil.marinha.apisisconv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.marinha.apisisconv.domain.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long>{

}
