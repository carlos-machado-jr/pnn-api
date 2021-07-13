package br.mil.marinha.apisisconv.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.mil.marinha.apisisconv.domain.Proprietarios;
import br.mil.marinha.apisisconv.domain.Telefones;
import br.mil.marinha.apisisconv.domain.Veiculos;

public class ViewProprietariosDTO {
	private Long id;
	private String name;
	private String nipOrCpf;
	private String email;
	private String driversLicense;
	private String createdAt;
	
	private String militaryPost;
	private String sector;
	private List<Telefones> numberPhones;
	private List<ViewVeiculosDTO> vehicules;
	
	private String status;
	private String note;
	
	public ViewProprietariosDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ViewProprietariosDTO(Proprietarios p) {
		super();
		this.id = p.getId();
		this.name = p.getName();
		this.nipOrCpf = p.getNipOrCpf();
		this.email = p.getEmail();
		this.driversLicense = p.getDriversLicense();
		this.createdAt = p.getCreatedAt();
		this.militaryPost = p.getPostoGraduacoes().getDescription();
		this.sector = p.getSetores().getDescription();
		this.numberPhones = p.getTelefones();
		this.vehicules = transformInDTO(p.getVeiculos());
		this.status = p.getisStatus() ? "Ativado" : "Desativado";
		this.note = p.getNote();
	}
	
	private List<ViewVeiculosDTO> transformInDTO(List<Veiculos> vehicules){
		return vehicules.stream().map(v -> new ViewVeiculosDTO(v)).collect(Collectors.toList());
	}
	


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNipOrCpf() {
		return nipOrCpf;
	}
	public void setNipOrCpf(String nipOrCpf) {
		this.nipOrCpf = nipOrCpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDriversLicense() {
		return driversLicense;
	}
	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getMilitaryPost() {
		return militaryPost;
	}
	public void setMilitaryPost(String militaryPost) {
		this.militaryPost = militaryPost;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public List<Telefones> getNumberPhones() {
		return numberPhones;
	}
	public void setNumberPhones(List<Telefones> numberPhones) {
		this.numberPhones = numberPhones;
	}
	public List<ViewVeiculosDTO> getVehicules() {
		return vehicules;
	}
	public void setVehicules(List<ViewVeiculosDTO> cars) {
		this.vehicules = cars;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
