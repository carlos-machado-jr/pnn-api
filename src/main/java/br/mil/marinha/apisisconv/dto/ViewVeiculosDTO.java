package br.mil.marinha.apisisconv.dto;

import br.mil.marinha.apisisconv.domain.Veiculos;

public class ViewVeiculosDTO {
	private Long id;
	private String model;
	private String year;
	private String licensePlate;
	private String color;
	
	private String typeVehicles;
	private String automaker;
	private String status;
	private String createdAt;
	private String validity;
	private String note;
	
	public ViewVeiculosDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ViewVeiculosDTO(Veiculos v) {
		super();
		this.id = v.getId();
		this.model = v.getModel();
		this.year = v.getYear();
		this.licensePlate = v.getLicensePlate();
		this.color = v.getColor();
		this.typeVehicles = v.getTipo_Veiculos().getDescription();
		this.automaker = v.getMontadoras().getDescription();
		this.status = v.isStatus() ? "Ativado" : "Desativado";
		this.validity = v.getValidity();
		this.createdAt = v.getCreatedAt();
		this.note = v.getNote();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTypeVehicles() {
		return typeVehicles;
	}
	public void setTypeVehicles(String typeVehicles) {
		this.typeVehicles = typeVehicles;
	}
	public String getAutomaker() {
		return automaker;
	}
	public void setAutomaker(String automaker) {
		this.automaker = automaker;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getValidity() {
		return validity;
	}



	public void setValidity(String validity) {
		this.validity = validity;
	}



	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
