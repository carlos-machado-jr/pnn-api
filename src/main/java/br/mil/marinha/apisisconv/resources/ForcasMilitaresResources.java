package br.mil.marinha.apisisconv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.marinha.apisisconv.domain.ForcasMilitares;
import br.mil.marinha.apisisconv.services.ForcasMilitaresServices;

@RestController
@RequestMapping("/forcas-militares")
public class ForcasMilitaresResources {

	@Autowired
	ForcasMilitaresServices service;
	
	@GetMapping
	public ResponseEntity<List<ForcasMilitares>> findAll(){
		List<ForcasMilitares> f = service.findAll();
		return ResponseEntity.ok(f);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ForcasMilitares> findById(@PathVariable Long id){
		ForcasMilitares f = service.findById(id);
		return ResponseEntity.ok(f);
	}
}
