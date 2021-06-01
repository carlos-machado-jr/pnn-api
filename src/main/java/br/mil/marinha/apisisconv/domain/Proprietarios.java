package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@AuditTable("proprietarios_audit")
public class Proprietarios implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pro_Id;
	
	private String pro_Nome;
	private String pro_NipCpf;
	private String pro_Email;
	private String pro_Cnh;
	
	private Date pro_Createdat;
	
	@ManyToOne
	@JoinColumn(name = "pro_Posto_Id")
	private PostoGraduacoes postoGraduacoes;

	@ManyToOne
	@JoinColumn(name = "pro_Setor_Id")
	private Setores setores;
	
	private Boolean pro_Status;
	private String pro_Observacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprietarios")
	private List<Telefones> telefones;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprietarios")
	private List<Veiculos> veiculos;
	
	
	
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


	public Date getPro_Createdat() {
		return pro_Createdat;
	}


	public void setPro_Createdat(Date pro_Createdat) {
		this.pro_Createdat = pro_Createdat;
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


	public List<Telefones> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<Telefones> telefones) {
		this.telefones = telefones;
	}


	public List<Veiculos> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}


	
	
}
