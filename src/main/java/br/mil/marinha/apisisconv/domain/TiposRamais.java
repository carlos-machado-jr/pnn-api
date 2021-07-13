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
@AuditTable("tipos_ramais_audit")
@Table(name="tipos_ramais")
public class TiposRamais implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "bigInt", name = "tir_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", name = "tir_Descricao", nullable = false)
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoRamais")
	private List<Ramais> ramais;
	
	public TiposRamais() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long tir_Id) {
		this.id = tir_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String tir_Descricao) {
		this.description = tir_Descricao;
	}

	public List<Ramais> getRamais() {
		return ramais;
	}

	public void setRamais(List<Ramais> ramais) {
		this.ramais = ramais;
	}



	
	
	
}
