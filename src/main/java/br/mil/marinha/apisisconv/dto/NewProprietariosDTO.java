package br.mil.marinha.apisisconv.dto;

import java.util.List;

public class NewProprietariosDTO {

	private String name;
	private String nipOrCpf;
	private String email;
	private String driversLicense;
	
	private String militaryPost;
	private String sector;
	private List<NewTelefoneDTO> numberPhones;
	private List<NewVeiculosDTO> cars;
	private String note;
	
	
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
	public List<NewTelefoneDTO> getNumberPhones() {
		return numberPhones;
	}
	public void setNumberPhones(List<NewTelefoneDTO> numberPhones) {
		this.numberPhones = numberPhones;
	}
	public List<NewVeiculosDTO> getCars() {
		return cars;
	}
	public void setCars(List<NewVeiculosDTO> cars) {
		this.cars = cars;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	

}
