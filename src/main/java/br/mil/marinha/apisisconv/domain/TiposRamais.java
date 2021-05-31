package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.List;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tir_Id;
	
	private String tir_Descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoRamais")
	private List<Ramais> ramais;
	
	public TiposRamais() {
		// TODO Auto-generated constructor stub
	}

	public Long getTir_Id() {
		return tir_Id;
	}

	public void setTir_Id(Long tir_Id) {
		this.tir_Id = tir_Id;
	}

	public String getTir_Descricao() {
		return tir_Descricao;
	}

	public void setTir_Descricao(String tir_Descricao) {
		this.tir_Descricao = tir_Descricao;
	}

	public List<Ramais> getRamais() {
		return ramais;
	}

	public void setRamais(List<Ramais> ramais) {
		this.ramais = ramais;
	}



	
	
	
}
