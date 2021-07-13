package br.mil.marinha.apisisconv.dto;

import br.mil.marinha.apisisconv.domain.Telefones;

public class ViewTelefoneDTO {
	private Long id;
	private String type;
	private String areaCode;
	private String numberPhone;
	private String status;
	private String createdAt;
	
	public ViewTelefoneDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ViewTelefoneDTO(Telefones t) {
		super();
		this.id = t.getId();
		this.type = t.getType();
		this.areaCode = t.getAreaCode();
		this.numberPhone = t.getNumberPhone();
		this.status = t.getisStatus() ? "Ativado": "Desativado";
		this.createdAt = t.getCreatedAt();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
