package br.mil.marinha.apisisconv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mil.marinha.apisisconv.domain.CartaoEstacionamento;
import br.mil.marinha.apisisconv.domain.Montadoras;
import br.mil.marinha.apisisconv.domain.Proprietarios;
import br.mil.marinha.apisisconv.domain.TipoVeiculos;
import br.mil.marinha.apisisconv.domain.Veiculos;
import br.mil.marinha.apisisconv.dto.NewVeiculosDTO;
import br.mil.marinha.apisisconv.repositories.VeiculosRepository;

@Service
public class VeiculosServices {
	@Autowired
	VeiculosRepository repo;
	
	@Autowired
	MontadorasServices montadorasService;
	
	@Autowired
	TipoVeiculosServices tipoVeiculosServices;
	
	@Autowired
	CartaoEstacionamentoServices cartaoEstacionamentoServices; 
	
	public List<Veiculos> findAll(){
		return repo.findAll();
	}
	
	public Veiculos findById(Long id) {
		Optional<Veiculos> v = repo.findById(id);
		
		return v.orElse(null);
	}
	
	public Veiculos save(NewVeiculosDTO newVeiculos, Proprietarios proprietarios) {
		if(newVeiculos.getTypeVehicles().equals("Moto") && !newVeiculos.getParkingCard().equals("MOTO")) {
			
		}
		Veiculos vehicles = new Veiculos(newVeiculos);
		Montadoras montadora = getMontadoras(newVeiculos.getAutomaker());
		TipoVeiculos tipoVeiculos = getTipoVeiculos(newVeiculos.getTypeVehicles());
		CartaoEstacionamento cartaoEstacionamento = getCartaoEstacionamento(newVeiculos.getParkingCard());
		
		vehicles.setProprietarios(proprietarios);
		vehicles.setCartao_estacionamento(cartaoEstacionamento);
		vehicles.setMontadoras(montadora);
		vehicles.setTipo_Veiculos(tipoVeiculos);
		
		

		return repo.save(vehicles);
		
	}
	
	private Montadoras getMontadoras(String description) {
		return montadorasService.findByDescription(description.toUpperCase());
	}
	
	private TipoVeiculos getTipoVeiculos(String description) {
		return tipoVeiculosServices.findByDescription(description);
	}
	
	private CartaoEstacionamento getCartaoEstacionamento(String description) {
		return cartaoEstacionamentoServices.findByDescription(description);
	}
}
