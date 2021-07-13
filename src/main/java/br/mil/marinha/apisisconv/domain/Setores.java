package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@AuditTable("setores_audit")
@Table(name = "setores")
public class Setores implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "bigInt", name = "set_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", name = "set_Descricao", nullable = false)
	private String description;
	
	@Column(columnDefinition = "tinyint", name = "set_Status", nullable = false)
	private boolean status;
	
	@Column(columnDefinition = "datetime", name = "set_CreatedAt", nullable = false)
	private String createdAt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "setores")
	private List<Ramais> ramais;
	
	@JsonIgnore
	@OneToMany(mappedBy = "setores")
	private List<Proprietarios> proprietarios;
	
	
	public Setores() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long set_Id) {
		this.id = set_Id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String set_Descricao) {
		this.description = set_Descricao;
	}


	public boolean getisStatus() {
		return status;
	}


	public void setStatus(boolean set_Status) {
		this.status = set_Status;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String set_CreatedAt) {
		this.createdAt = set_CreatedAt;
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
