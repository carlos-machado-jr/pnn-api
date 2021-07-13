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
@AuditTable("organizacoes_militares_audit")
@Table(name = "organizacoes_militares")
public class OrganizacoesMilitares implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "bigInt", name = "om_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", name = "om_Descricao", nullable = false)
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "organizacoesMilitares")
	private List<Ramais> ramais;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long om_Id) {
		this.id = om_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String om_Descricao) {
		this.description = om_Descricao;
	}

	public List<Ramais> getRamais() {
		return ramais;
	}

	public void setRamais(List<Ramais> ramais) {
		this.ramais = ramais;
	}

	


	
	
	
	
}
