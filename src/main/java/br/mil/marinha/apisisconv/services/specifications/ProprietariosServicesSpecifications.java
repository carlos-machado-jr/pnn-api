package br.mil.marinha.apisisconv.services.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.mil.marinha.apisisconv.domain.Proprietarios;
import io.jsonwebtoken.lang.Strings;

public class ProprietariosServicesSpecifications {
	public Specification<Proprietarios> searchBy(Boolean status, String name, String nipOrCpf, String email) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			if(Objects.nonNull(status)) {
				Path<Boolean> campo = root.get("status");
				Predicate predicado1 = builder.equal(campo, status );
				predicados.add(predicado1);
			}
			
			
			if(Strings.hasText(name)) {
				Path<String> campo = root.get("name");
				Predicate predicado1 = builder.equal(campo, name );
				predicados.add(predicado1);
			}
			
			if(Strings.hasText(nipOrCpf)) {
				Path<String> campo = root.get("nipOrCpf");
				Predicate predicado1 = builder.equal(campo, nipOrCpf );
				predicados.add(predicado1);
			}
			
			if(Strings.hasText(email)) {
				Path<String> campo = root.get("email");
				Predicate predicado1 = builder.equal(campo, email );
				predicados.add(predicado1);
			}
			
			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}
