package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@AuditTable("telefones_audit")
public class Telefones implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tel_Id;
	
	private String tel_Tipo;
	private String tel_DDD;
	private String tel_Numero;
	private Boolean tel_Status;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tel_Pro_Id")
	private Proprietarios proprietarios;
	
	
	private Date tel_Createdat;
	
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
		return tel_Createdat;
	}

	public void setTel_CreatedAt(Date tel_CreatedAt) {
		this.tel_Createdat = tel_CreatedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proprietarios == null) ? 0 : proprietarios.hashCode());
		result = prime * result + ((tel_Createdat == null) ? 0 : tel_Createdat.hashCode());
		result = prime * result + ((tel_DDD == null) ? 0 : tel_DDD.hashCode());
		result = prime * result + ((tel_Id == null) ? 0 : tel_Id.hashCode());
		result = prime * result + ((tel_Numero == null) ? 0 : tel_Numero.hashCode());
		result = prime * result + ((tel_Status == null) ? 0 : tel_Status.hashCode());
		result = prime * result + ((tel_Tipo == null) ? 0 : tel_Tipo.hashCode());
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
		Telefones other = (Telefones) obj;
		if (proprietarios == null) {
			if (other.proprietarios != null)
				return false;
		} else if (!proprietarios.equals(other.proprietarios))
			return false;
		if (tel_Createdat == null) {
			if (other.tel_Createdat != null)
				return false;
		} else if (!tel_Createdat.equals(other.tel_Createdat))
			return false;
		if (tel_DDD == null) {
			if (other.tel_DDD != null)
				return false;
		} else if (!tel_DDD.equals(other.tel_DDD))
			return false;
		if (tel_Id == null) {
			if (other.tel_Id != null)
				return false;
		} else if (!tel_Id.equals(other.tel_Id))
			return false;
		if (tel_Numero == null) {
			if (other.tel_Numero != null)
				return false;
		} else if (!tel_Numero.equals(other.tel_Numero))
			return false;
		if (tel_Status == null) {
			if (other.tel_Status != null)
				return false;
		} else if (!tel_Status.equals(other.tel_Status))
			return false;
		if (tel_Tipo == null) {
			if (other.tel_Tipo != null)
				return false;
		} else if (!tel_Tipo.equals(other.tel_Tipo))
			return false;
		return true;
	}

	
	
	
	
}
