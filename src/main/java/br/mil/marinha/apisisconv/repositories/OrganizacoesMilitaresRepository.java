package br.mil.marinha.apisisconv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.marinha.apisisconv.domain.OrganizacoesMilitares;

@Repository
public interface OrganizacoesMilitaresRepository extends JpaRepository<OrganizacoesMilitares, Long> {

}
