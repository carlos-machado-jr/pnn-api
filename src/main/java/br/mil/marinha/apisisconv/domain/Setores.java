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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proprietarios == null) ? 0 : proprietarios.hashCode());
		result = prime * result + ((ramais == null) ? 0 : ramais.hashCode());
		result = prime * result + ((set_Createdat == null) ? 0 : set_Createdat.hashCode());
		result = prime * result + ((set_Descricao == null) ? 0 : set_Descricao.hashCode());
		result = prime * result + ((set_Id == null) ? 0 : set_Id.hashCode());
		result = prime * result + ((set_Status == null) ? 0 : set_Status.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setores other = (Setores) obj;
		if (proprietarios == null) {
			if (other.proprietarios != null)
				return false;
		} else if (!proprietarios.equals(other.proprietarios))
			return false;
		if (ramais == null) {
			if (other.ramais != null)
				return false;
		} else if (!ramais.equals(other.ramais))
			return false;
		if (set_Createdat == null) {
			if (other.set_Createdat != null)
				return false;
		} else if (!set_Createdat.equals(other.set_Createdat))
			return false;
		if (set_Descricao == null) {
			if (other.set_Descricao != null)
				return false;
		} else if (!set_Descricao.equals(other.set_Descricao))
			return false;
		if (set_Id == null) {
			if (other.set_Id != null)
				return false;
		} else if (!set_Id.equals(other.set_Id))
			return false;
		if (set_Status == null) {
			if (other.set_Status != null)
				return false;
		} else if (!set_Status.equals(other.set_Status))
			return false;
		return true;
	}

	
		
	
	
}
