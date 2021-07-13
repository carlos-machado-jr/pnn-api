package br.mil.marinha.apisisconv.dto;

public class NewVeiculosDTO {
	
	private String model;
	private String year;
	private String LicensePlate;
	private String color;
	
	private String typeVehicles;
	private String automaker;
	private String note;
	
	public NewVeiculosDTO() {
		// TODO Auto-generated constructor stub
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
		return LicensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		LicensePlate = licensePlate;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	

}
