package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@AuditTable("telefones_audit")
@Table(name = "telefones")
public class Telefones implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "bigInt", name = "tel_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(25)", name = "tel_Tipo", nullable = false)
	private String type;
	
	@Column(columnDefinition = "varchar(12)", name = "tel_DDD", nullable = false)
	private String areaCode;
	
	@Column(columnDefinition = "varchar(15)", name = "tel_Numero", nullable = false)
	private String numberPhone;
	
	@Column(columnDefinition = "tinyint", name = "tel_Status", nullable = false)
	private Boolean status;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tel_Pro_Id")
	private Proprietarios proprietarios;
	
	@Column(columnDefinition = "datetime", name = "tel_CreatedAt", nullable = false)
	private String createdAt;
	
	public Telefones() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long tel_Id) {
		this.id = tel_Id;
	}

	public String getType() {
		return type;
	}

	public void setType(String tel_Tipo) {
		this.type = tel_Tipo;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String tel_DDD) {
		this.areaCode = tel_DDD;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String tel_Numero) {
		this.numberPhone = tel_Numero;
	}

	public boolean getisStatus() {
		return status;
	}

	public void setStatus(boolean tel_Status) {
		this.status = tel_Status;
	}

	public Proprietarios getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(Proprietarios proprietarios) {
		this.proprietarios = proprietarios;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String tel_CreatedAt) {
		this.createdAt = tel_CreatedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proprietarios == null) ? 0 : proprietarios.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberPhone == null) ? 0 : numberPhone.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (areaCode == null) {
			if (other.areaCode != null)
				return false;
		} else if (!areaCode.equals(other.areaCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numberPhone == null) {
			if (other.numberPhone != null)
				return false;
		} else if (!numberPhone.equals(other.numberPhone))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	
	
	
	
}
