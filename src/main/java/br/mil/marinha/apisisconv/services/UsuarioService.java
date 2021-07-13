package br.mil.marinha.apisisconv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Usuarios;
import br.mil.marinha.apisisconv.dto.UsuarioNewDTO;
import br.mil.marinha.apisisconv.repositories.UsuarioRepository;
import br.mil.marinha.apisisconv.security.UserSS;
import br.mil.marinha.apisisconv.services.exceptions.AuthorizationException;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;
import br.mil.marinha.apisisconv.services.specifications.UsuarioServiceSpecifications;

@Service
public class UsuarioService extends UsuarioServiceSpecifications implements UserDetailsService  {

	@Autowired
	UsuarioRepository usuarioRepository;


	@Autowired
	PermissaoService permissaoService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	 

	// administrador
	public Page<Usuarios> findAll(Pageable pageable) {
		return usuarioRepository.findAll(pageable);
	}
	
	public Page<Usuarios> search(Boolean status, String permissoes, Pageable pageable) {
		return usuarioRepository.findAll(searchBy(status, permissoes) , pageable);
	}


	public Usuarios findByUsuario() {
		UserSS userAuthenticated = UserService.authenticated();
		Usuarios usuario = findById(userAuthenticated.getId());
		return usuario;
	}
	
	
	// administrador
	public Usuarios findById(Integer id) {
		Optional<Usuarios> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> objectNotFoundException(id, "Usuario não encontrado!"));
	}

	// todos
	public Usuarios findByIdActived(Integer id) {
		UserSS userAuthenticated = UserService.authenticated();
		// usuario só pode acessar dados dele mesmo.
		if (userAuthenticated == null
				|| userAuthenticated.hasRole("Usuario") && !id.equals(userAuthenticated.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Usuarios> c = usuarioRepository.findByIdAndAtivo(id, true);
		String permissao = c.get().getPermissoes().getDesc_permissoes();

		// Somente administrador pode acessar dados de administrador
		if (permissao.equals("Administrador") && !userAuthenticated.hasRole("Administrador")) {
			throw new AuthorizationException("Acesso negado");
		}
		return c.orElseThrow(() -> objectNotFoundException(id, "Usuario desativado!"));

	}

	// administrador
	public Usuarios findByIdDisabled(Integer id) {
		Optional<Usuarios> c = usuarioRepository.findByIdAndAtivo(id, false);
		
		return c.orElseThrow(() -> objectNotFoundException(id, "Usuario ativado ou não existe!"));

	}

	// login
	@Override
	public UserDetails loadUserByUsername(String nome_usuario) throws UsernameNotFoundException {
		Usuarios p = usuarioRepository.findByNomeUsuario(nome_usuario);
		if (p == null) {
			throw new UsernameNotFoundException(nome_usuario);
		}
		List<GrantedAuthority> listGrantAuthority = new ArrayList<GrantedAuthority>();
		checkGrantAuthorities(p, listGrantAuthority);
		return new UserSS(p.getId(), p.getNome_usuario(), p.getSenha(), listGrantAuthority);
	}

	// administrador e supervisor
	public Usuarios create(UsuarioNewDTO newDTO) {
		
		newDTO.setId(null);
		Usuarios usuario = transformDTO(newDTO);
		return usuarioRepository.save(usuario);

	}
	
	
	

	
	// administrador e supervisor
	public void update(UsuarioNewDTO newDTO) {
		Usuarios usuario = transformDTO(newDTO);

		usuarioRepository.save(usuario);
	}
	
	public Usuarios activate(Integer id) {
		Usuarios usuario = usuarioRepository.findById(id).orElseThrow(() -> objectNotFoundException(id, "Usuario não encontrado!"));
		usuario.setAtivo(false);
		return usuarioRepository.save(usuario);
	}
	
	//administrador
	public void deactivate(Integer id) {
		Usuarios usuario = usuarioRepository.findById(id).orElseThrow(() -> objectNotFoundException(id, "Usuario não encontrado!"));
		usuario.setAtivo(false);
		usuarioRepository.save(usuario);
	}
	
	// metodos privados
	
	
	private ObjectNotFoundException objectNotFoundException(Integer id, String message) {
		return new ObjectNotFoundException(
				message + " id: " + id + ", Tipo: " + Usuarios.class.getName());
	}

	private Usuarios transformDTO(UsuarioNewDTO newDTO) {
		UserSS userAuthenticated = UserService.authenticated();
		// se o usuario autenticado nao for administrador, ele nao poderá cadastrar usuarios administradores!
		if (userAuthenticated.hasRole("Usuario") && newDTO.getPermissao().equals("Administrador")) {
			 throw new AuthorizationException("Acesso negado!");
		}
		
		Usuarios usuario = new Usuarios(newDTO.getId(), newDTO.getNome_usuario(), newDTO.getEmail(),
				newDTO.getNip_responsavel(), encoder.encode(newDTO.getSenha()), true);

		usuario.setPermissoes(permissaoService.findByDescricao(newDTO.getPermissao()));
		return usuario;
	}

	private void checkGrantAuthorities(Usuarios user, List<GrantedAuthority> listGrantAuthority) {
		if (user != null && user.getPermissoes() != null) {

			final String PREFIX = "ROLE_";
			String role = PREFIX + user.getPermissoes().getDesc_permissoes();
			listGrantAuthority.add(new SimpleGrantedAuthority(role));
		}
	}

}
