package br.mil.marinha.apisisconv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.marinha.apisisconv.domain.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

}
