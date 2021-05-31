package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@AuditTable("setores_audit")
public class Setores implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long set_Id;
	
	private String set_Descricao;
	private Boolean set_Status;
	
	
	private Date set_Createdat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "setores")
	private List<Ramais> ramais;
	
	@JsonIgnore
	@OneToMany(mappedBy = "setores")
	private List<Proprietarios> proprietarios;
	
	
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
		return set_Createdat;
	}


	public void setSet_CreatedAt(Date set_CreatedAt) {
		this.set_Createdat = set_CreatedAt;
	}


	public List<Ramais> getRamais() {
		return ramais;
	}


	public void setRamais(List<Ramais> ramais) {
		this.ramais = ramais;
	}


	public List<Proprietarios> getProprietarios() {
		return proprietarios;
	}


	public void setProprietarios(List<Proprietarios> proprietarios) {
		this.proprietarios = proprietarios;
	}

	
		
	
	
}
