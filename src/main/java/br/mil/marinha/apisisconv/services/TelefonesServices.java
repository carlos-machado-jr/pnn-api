package br.mil.marinha.apisisconv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.Proprietarios;
import br.mil.marinha.apisisconv.domain.Telefones;
import br.mil.marinha.apisisconv.dto.NewTelefoneDTO;
import br.mil.marinha.apisisconv.repositories.TelefonesRepository;
import br.mil.marinha.apisisconv.services.exceptions.ObjectNotFoundException;

@Service
public class TelefonesServices {

	@Autowired
	TelefonesRepository telefonesRepository;
	
	
	public List<Telefones> findAll(){
		return telefonesRepository.findAll();
	}
	
	public Telefones findById(Long id) {
		Telefones telefone = telefonesRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Telefone não encontrado"));
		
		return telefone;
	}
	
	public Telefones save(NewTelefoneDTO newTelefoneDto, Proprietarios proprietarios) {
		Telefones phone = new Telefones(newTelefoneDto);
		phone.setProprietarios(proprietarios);
		return telefonesRepository.save(phone);
	}
}
