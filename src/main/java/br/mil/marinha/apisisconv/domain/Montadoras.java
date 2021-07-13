package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@AuditTable("montadoras_audit")
@Table(name = "montadoras")
public class Montadoras implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "bigInt", name = "mon_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", name = "mon_Descricao", nullable = false)
	private String description;
	
	@Column(columnDefinition = "tinyint", name = "mon_status", nullable = false)
	private boolean status;
	
	@Column(columnDefinition = "datetime", name = "mon_CreatedAt", nullable = false)
	private String createdAt;
	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="rel_tipo_montadoras", joinColumns = {@JoinColumn(name="mon_Id")}, inverseJoinColumns = {@JoinColumn(name="tiv_Id")})
	private List<TipoVeiculos> tipoVeiculos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "montadoras")
	private List<Veiculos> veiculos;

	public Long getId() {
		return id;
	}

	public void setId(Long mon_Id) {
		this.id = mon_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String mon_Descricao) {
		this.description = mon_Descricao;
	}

	public boolean getisStatus() {
		return status;
	}

	public void setStatus(boolean mon_Status) {
		this.status = mon_Status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String mon_Createdat) {
		this.createdAt = mon_Createdat;
	}

	


	public List<TipoVeiculos> getTipo_Veiculos() {
		return tipoVeiculos;
	}

	public void setTipo_Veiculos(List<TipoVeiculos> tipo_Veiculos) {
		this.tipoVeiculos = tipo_Veiculos;
	}

	public List<Veiculos> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}
	
	
	
}
