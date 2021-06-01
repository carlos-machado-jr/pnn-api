package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable("cartao_estacionamento_audit")
public class CartaoEstacionamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cae_Id;
	
	private String cae_Descricao;
	
	@OneToOne(mappedBy = "cartao_estacionamento")
	private Veiculos veiculos;
	
	private Boolean cae_Status;
	private Date cae_Createdat;
	
	
	public Long getCae_Id() {
		return cae_Id;
	}
	public void setCae_Id(Long cae_Id) {
		this.cae_Id = cae_Id;
	}
	public String getCae_Descricao() {
		return cae_Descricao;
	}
	public void setCae_Descricao(String cae_Descricao) {
		this.cae_Descricao = cae_Descricao;
	}
	public Veiculos getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}
	public Boolean getCae_Status() {
		return cae_Status;
	}
	public void setCae_Status(Boolean cae_Status) {
		this.cae_Status = cae_Status;
	}
	public Date getCae_Createdat() {
		return cae_Createdat;
	}
	public void setCae_Createdat(Date cae_Createdat) {
		this.cae_Createdat = cae_Createdat;
	}
	
	
	

}
