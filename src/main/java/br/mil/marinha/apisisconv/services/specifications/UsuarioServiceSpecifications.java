package br.mil.marinha.apisisconv.services.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;

import br.mil.marinha.apisisconv.domain.Usuarios;
import io.jsonwebtoken.lang.Strings;

public class UsuarioServiceSpecifications {
	@Transactional
	public Specification<Usuarios> searchBy(Boolean status, String permissoes) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			if(Objects.nonNull(status)) {
				Path<Boolean> campo = root.get("ativo");
				Predicate predicado1 = builder.equal(campo, status );
				predicados.add(predicado1);
			}
			
			
			if(Strings.hasText(permissoes)) {
				Path<String> campo = root.get("permissoes").get("desc_permissoes");
				Predicate predicado1 = builder.equal(campo, permissoes );
				predicados.add(predicado1);
			}
			
			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
	@Transactional
	public Specification<Usuarios> searchBy(Boolean status, String permissoes, Integer id) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			if(Objects.nonNull(status)) {
				Path<Boolean> campo = root.get("ativo");
				Predicate predicado1 = builder.equal(campo, status );
				predicados.add(predicado1);
			}
			if(Objects.nonNull(id)) {
				Path<Integer> campo = root.get("id");
				Predicate predicado1 = builder.equal(campo, id );
				predicados.add(predicado1);
			}
			
			if(Objects.isNull(permissoes)) {
				Path<String> campo = root.get("permissoes").get("desc_permissoes");
				Predicate predicado1 = builder.equal(campo, permissoes );
				predicados.add(predicado1);
			}
			
			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}
