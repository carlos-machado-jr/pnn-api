package br.mil.marinha.apisisconv.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.ForcasMilitares;
import br.mil.marinha.apisisconv.domain.PostoGraduacoes;
import br.mil.marinha.apisisconv.domain.Proprietarios;
import br.mil.marinha.apisisconv.domain.Setores;
import br.mil.marinha.apisisconv.dto.NewProprietariosDTO;
import br.mil.marinha.apisisconv.dto.NewTelefoneDTO;
import br.mil.marinha.apisisconv.dto.NewVeiculosDTO;
import br.mil.marinha.apisisconv.repositories.ProprietariosRepository;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;
import br.mil.marinha.apisisconv.services.specifications.ProprietariosServicesSpecifications;

@Service
public class ProprietariosServices extends ProprietariosServicesSpecifications{
	
	@Autowired
	ProprietariosRepository proprietariosRepository;
	
	@Autowired
	PostoGraduacoesServices postoGraduacoesServices;
	
	@Autowired 
	SetoresServices setorServices;
	
	@Autowired
	VeiculosServices veiculosServices;
	
	@Autowired
	TelefonesServices telefonesServices;
	
	public Page<Proprietarios> findAll(Pageable pageable){
		return proprietariosRepository.findAll(pageable);
	}
	
	
	public Page<Proprietarios> search(Boolean status, String name, String nipOrCpf, String email, Pageable pageable){
		return proprietariosRepository.findAll(searchBy(status, name, nipOrCpf, email) ,pageable);
	}
	
	
	public Proprietarios findById(Long id) {
		return proprietariosRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Proprietario não encontrado!!"));
		
	}
	
	public Proprietarios save(NewProprietariosDTO newProprietarios) {
		Proprietarios proprietarios = new Proprietarios(newProprietarios);
		PostoGraduacoes postoGraduacoes = getPosto(newProprietarios.getMilitaryPost());
		Setores setores = getSetor(newProprietarios.getSector());
		
		proprietarios.setPostoGraduacoes(postoGraduacoes);
		proprietarios.setSetores(setores);
		proprietarios = proprietariosRepository.save(proprietarios);
		
		
		saveAllVehicles(newProprietarios.getCars(), proprietarios);
		saveAllPhones(newProprietarios.getNumberPhones(), proprietarios);

		
		return proprietarios;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private PostoGraduacoes getPosto(String militaryPost) {
		return postoGraduacoesServices.findByDescriptionAndForcaMilitares(militaryPost, new ForcasMilitares(1L, "Marinha do Brasil"));
	}
	
	private Setores getSetor(String description) {
		return setorServices.findByDescription(description);
	}
	private void saveAllVehicles(List<NewVeiculosDTO> newVeiculosDto, Proprietarios proprietarios) {
		for(Iterator<NewVeiculosDTO> i = newVeiculosDto.iterator(); i.hasNext();) 
			veiculosServices.save((NewVeiculosDTO) i.next(), proprietarios);
	}
	
	private void saveAllPhones(List<NewTelefoneDTO> newTelefoneDto, Proprietarios proprietarios) {
		for(Iterator<NewTelefoneDTO> i = newTelefoneDto.iterator(); i.hasNext();) 
			telefonesServices.save((NewTelefoneDTO) i.next(), proprietarios);
	}
	
}
