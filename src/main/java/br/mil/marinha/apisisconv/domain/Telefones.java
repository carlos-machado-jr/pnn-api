package br.mil.marinha.apisisconv.domain;

import java.util.Date;

public class Telefones {

	
/*
 *   `tel_Id` int(4) primary key AUTO_INCREMENT NOT NULL,
  `tel_Tipo` varchar(6) NOT NULL,
  `tel_DDD` varchar(12) NOT NULL,
  `tel_Numero` varchar(12) NOT NULL,
  `tel_Status` TINYINT(1) not null,
  `tel_Pro_Id` varchar(250),
  `tel_CreatedAt` date NOT NULL
  */
	
	
	private Long tel_Id;
	private String tel_Tipo;
	private String tel_DDD;
	private String tel_Numero;
	private Boolean tel_Status;
	
	private Proprietarios proprietarios;
	private Date tel_CreatedAt;
	
	public Telefones() {
		// TODO Auto-generated constructor stub
	}

	public Long getTel_Id() {
		return tel_Id;
	}

	public void setTel_Id(Long tel_Id) {
		this.tel_Id = tel_Id;
	}

	public String getTel_Tipo() {
		return tel_Tipo;
	}

	public void setTel_Tipo(String tel_Tipo) {
		this.tel_Tipo = tel_Tipo;
	}

	public String getTel_DDD() {
		return tel_DDD;
	}

	public void setTel_DDD(String tel_DDD) {
		this.tel_DDD = tel_DDD;
	}

	public String getTel_Numero() {
		return tel_Numero;
	}

	public void setTel_Numero(String tel_Numero) {
		this.tel_Numero = tel_Numero;
	}

	public Boolean getTel_Status() {
		return tel_Status;
	}

	public void setTel_Status(Boolean tel_Status) {
		this.tel_Status = tel_Status;
	}

	public Proprietarios getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(Proprietarios proprietarios) {
		this.proprietarios = proprietarios;
	}

	public Date getTel_CreatedAt() {
		return tel_CreatedAt;
	}

	public void setTel_CreatedAt(Date tel_CreatedAt) {
		this.tel_CreatedAt = tel_CreatedAt;
	}
	
	
	
	
}
