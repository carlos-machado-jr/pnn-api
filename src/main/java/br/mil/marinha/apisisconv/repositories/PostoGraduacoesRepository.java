package br.mil.marinha.apisisconv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.mil.marinha.apisisconv.domain.ForcasMilitares;
import br.mil.marinha.apisisconv.domain.PostoGraduacoes;

@Repository
public interface PostoGraduacoesRepository extends JpaRepository<PostoGraduacoes, Long>, JpaSpecificationExecutor<PostoGraduacoes> {
	Optional<PostoGraduacoes> findByDescriptionAndForcaMilitares(String description, ForcasMilitares forcasMilitares);
}
