package br.mil.marinha.apisisconv.services.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.mil.marinha.apisisconv.domain.PostoGraduacoes;
import io.jsonwebtoken.lang.Strings;

public class PostoGraduacoesServicesSpecifications {
	public Specification<PostoGraduacoes> searchBy(String forcaMilitares, String categorias) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			if(Objects.nonNull(forcaMilitares)) {
				Path<String> campo = root.get("forcaMilitares").get("description");
				Predicate predicado1 = builder.equal(campo, forcaMilitares );
				predicados.add(predicado1);
			}
			
			
			if(Strings.hasText(categorias)) {
				Path<String> campo = root.get("categorias").get("description");
				Predicate predicado1 = builder.equal(campo, categorias );
				predicados.add(predicado1);
			}
			
			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}
