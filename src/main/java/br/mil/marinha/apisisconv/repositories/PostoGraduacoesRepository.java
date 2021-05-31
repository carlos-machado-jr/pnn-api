package br.mil.marinha.apisisconv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.marinha.apisisconv.domain.PostoGraduacoes;

@Repository
public interface PostoGraduacoesRepository extends JpaRepository<PostoGraduacoes, Long> {

}
