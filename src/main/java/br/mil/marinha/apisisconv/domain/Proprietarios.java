package br.mil.marinha.apisisconv.domain;

import java.util.Date;

public class Proprietarios {
	
	
	private Long pro_Id;
	private String pro_Nome;
	private String pro_NipCpf;
	private String pro_Email;
	private String pro_Cnh;
	private Date pro_CreatedAt;
	
	
	private PostoGraduacoes postoGraduacoes;
	private Setores setores;
	private Boolean pro_Status;
	private String pro_Observacao;
	
	public Proprietarios() {
		// TODO Auto-generated constructor stub
	}

	public Long getPro_Id() {
		return pro_Id;
	}

	public void setPro_Id(Long pro_Id) {
		this.pro_Id = pro_Id;
	}

	public String getPro_Nome() {
		return pro_Nome;
	}

	public void setPro_Nome(String pro_Nome) {
		this.pro_Nome = pro_Nome;
	}

	public String getPro_NipCpf() {
		return pro_NipCpf;
	}

	public void setPro_NipCpf(String pro_NipCpf) {
		this.pro_NipCpf = pro_NipCpf;
	}

	public String getPro_Email() {
		return pro_Email;
	}

	public void setPro_Email(String pro_Email) {
		this.pro_Email = pro_Email;
	}

	public String getPro_Cnh() {
		return pro_Cnh;
	}

	public void setPro_Cnh(String pro_Cnh) {
		this.pro_Cnh = pro_Cnh;
	}

	public Date getPro_CreatedAt() {
		return pro_CreatedAt;
	}

	public void setPro_CreatedAt(Date pro_CreatedAt) {
		this.pro_CreatedAt = pro_CreatedAt;
	}

	public PostoGraduacoes getPostoGraduacoes() {
		return postoGraduacoes;
	}

	public void setPostoGraduacoes(PostoGraduacoes postoGraduacoes) {
		this.postoGraduacoes = postoGraduacoes;
	}

	public Setores getSetores() {
		return setores;
	}

	public void setSetores(Setores setores) {
		this.setores = setores;
	}

	public Boolean getPro_Status() {
		return pro_Status;
	}

	public void setPro_Status(Boolean pro_Status) {
		this.pro_Status = pro_Status;
	}

	public String getPro_Observacao() {
		return pro_Observacao;
	}

	public void setPro_Observacao(String pro_Observacao) {
		this.pro_Observacao = pro_Observacao;
	}
	
	
}
