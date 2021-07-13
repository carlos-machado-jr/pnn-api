package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@AuditTable("tipo_veiculos_audit")
@Table(name = "tipo_veiculos")
public class TipoVeiculos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "bigInt", name = "tiv_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", name = "tiv_Descricao", nullable = false)
	private String description;
	
	@Column(columnDefinition = "tinyint", name = "tiv_Status", nullable = false)
	private boolean status;
	
	@Column(columnDefinition = "datetime", name = "tiv_CreatedAt", nullable = false)
	private String createdAt;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "tipoVeiculos")
	private List<Montadoras> montadoras;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoVeiculos")
	private List<Veiculos> veiculos;

	public Long getId() {
		return id;
	}

	public void setId(Long tiv_Id) {
		this.id = tiv_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String tiv_Descricao) {
		this.description = tiv_Descricao;
	}

	public boolean getisStatus() {
		return status;
	}

	public void setStatus(boolean tiv_Status) {
		this.status = tiv_Status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String tiv_Createdat) {
		this.createdAt = tiv_Createdat;
	}



	

	

	public List<Montadoras> getMontadoras() {
		return montadoras;
	}

	public void setMontadoras(List<Montadoras> montadoras) {
		this.montadoras = montadoras;
	}

	public List<Veiculos> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}
	
	
	
	

}
