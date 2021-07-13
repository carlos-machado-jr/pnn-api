package br.mil.marinha.apisisconv.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.mil.marinha.apisisconv.domain.Usuarios;
import br.mil.marinha.apisisconv.dto.UsuarioNewDTO;
import br.mil.marinha.apisisconv.dto.UsuariosDTO;
import br.mil.marinha.apisisconv.services.UsuarioService;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api("API Rest usuario")
@CrossOrigin(origins = "*")
public class UsuarioResource {

	@Autowired
	UsuarioService usuarioService;
	
//	@PreAuthorize("hasAnyRole('Administrador')")
	@ApiOperation("Cria um usuario")
	@GetMapping
	public ResponseEntity<Page<UsuariosDTO>> findAll(Pageable pageable){
		Page<Usuarios> usuariosList = usuarioService.findAll(pageable);
		Page<UsuariosDTO> dtoList = createUsuariosDTO(usuariosList.toList());
		return ResponseEntity.ok(dtoList);
	}
	
//	@PreAuthorize("hasAnyRole('Administrador') || hasAnyRole('Supervisor')")
	@GetMapping("/search")
	public ResponseEntity<Page<UsuariosDTO>> search(@RequestParam(required = false) String permissoes,
													@RequestParam(required = false) Boolean status,
													Pageable pageable){
		Page<Usuarios> usuarios = usuarioService.search(status, permissoes, pageable);
		Page<UsuariosDTO> dtoList = createUsuariosDTO(usuarios.toList());
		return ResponseEntity.ok(dtoList);
	}
	
	



	
	@PreAuthorize("hasAnyRole('Administrador')")
	@GetMapping("/{id}")
	public ResponseEntity<UsuariosDTO> findById(
												@PathVariable Integer id) {

		Usuarios usuario = usuarioService.findById(id);

		UsuariosDTO dto = new UsuariosDTO(usuario);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{id}/ativado")
	public ResponseEntity<UsuariosDTO> findByIdActived(@PathVariable Integer id) {

		Usuarios usuario = usuarioService.findByIdActived(id);

		UsuariosDTO dto = new UsuariosDTO(usuario);
		return ResponseEntity.ok(dto);
	}
	
	@PreAuthorize("hasAnyRole('Administrador')")
	@GetMapping("/{id}/desativado")
	public ResponseEntity<UsuariosDTO> findByIdDisabled(@PathVariable Integer id) {
		
		Usuarios usuario = usuarioService.findByIdDisabled(id);
		
		UsuariosDTO dto = new UsuariosDTO(usuario);
		return ResponseEntity.ok(dto);
	}

	
	
	
//	@PreAuthorize("hasAnyRole('Administrador') || hasAnyRole('Supervisor')")
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody UsuarioNewDTO newDTO){
		
		Usuarios u = usuarioService.create(newDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('Administrador') || hasAnyRole('Supervisor')")
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody UsuarioNewDTO newDTO, @PathVariable Integer id){
		
		newDTO.setId(id);
		usuarioService.update(newDTO);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/perfil")
	public ResponseEntity<UsuariosDTO> findByUsuario(){
		Usuarios usuario = usuarioService.findByUsuario();

		UsuariosDTO dto = new UsuariosDTO(usuario);
		return ResponseEntity.ok(dto);
	}
	
	
	@PreAuthorize("hasAnyRole('Administrador')")
	@DeleteMapping("/desativar/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		usuarioService.deactivate(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('Administrador')")
	@PutMapping("/ativar/{id}")
	public ResponseEntity<Void> active(@PathVariable Integer id, @RequestBody UsuarioNewDTO dto) {
		Usuarios usuario = usuarioService.activate(id);

		if (!usuario.isAtivo()) {
			dto.setId(id);
			usuarioService.update(dto);
			return ResponseEntity.noContent().build();
		}
		throw new ObjectNotFoundException("Usuario ja esta ativado!");

	}
	
	
	private Page<UsuariosDTO> createUsuariosDTO(List<Usuarios> usuariosList) {
		return new PageImpl<>(usuariosList.stream().map(u -> new UsuariosDTO(u)).collect(Collectors.toList()));
	}
}
