package br.mil.marinha.apisisconv.domain;

import java.util.Date;

public class Setores {
	

	private Long set_Id;
	private String set_Descricao;
	private Boolean set_Status;
	private Date set_CreatedAt;
	
	
	public Setores() {
		// TODO Auto-generated constructor stub
	}


	public Long getSet_Id() {
		return set_Id;
	}


	public void setSet_Id(Long set_Id) {
		this.set_Id = set_Id;
	}


	public String getSet_Descricao() {
		return set_Descricao;
	}


	public void setSet_Descricao(String set_Descricao) {
		this.set_Descricao = set_Descricao;
	}


	public Boolean getSet_Status() {
		return set_Status;
	}


	public void setSet_Status(Boolean set_Status) {
		this.set_Status = set_Status;
	}


	public Date getSet_CreatedAt() {
		return set_CreatedAt;
	}


	public void setSet_CreatedAt(Date set_CreatedAt) {
		this.set_CreatedAt = set_CreatedAt;
	}
	
	
	
}
