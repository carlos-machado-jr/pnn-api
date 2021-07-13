package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable("cartao_estacionamento_audit")
@Table
public class CartaoEstacionamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "bigInt", name = "cae_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", name = "cae_Descricao", nullable = false)
	private String description;
	
	@OneToOne(mappedBy = "cartaoEstacionamento")
	private Veiculos veiculos;
	
	@Column(columnDefinition = "tinyint", name = "cae_Status", nullable = false)
	private boolean status;
	
	@Column(columnDefinition = "datetime", name = "cae_Createdat", nullable = false)
	private String createdAt;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long cae_Id) {
		this.id = cae_Id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String cae_Descricao) {
		this.description = cae_Descricao;
	}
	public Veiculos getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}
	public boolean getisStatus() {
		return status;
	}
	public void setStatus(boolean cae_Status) {
		this.status = cae_Status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String cae_Createdat) {
		this.createdAt = cae_Createdat;
	}
	
	
	

}
