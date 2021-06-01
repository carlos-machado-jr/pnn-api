package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tiv_Id;
	
	private String tiv_Descricao;
	
	private Boolean tiv_Status;
	private Date tiv_Createdat;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "tipo_Veiculos")
	private List<Montadoras> montadoras;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipo_Veiculos")
	private List<Veiculos> veiculos;

	public Long getTiv_Id() {
		return tiv_Id;
	}

	public void setTiv_Id(Long tiv_Id) {
		this.tiv_Id = tiv_Id;
	}

	public String getTiv_Descricao() {
		return tiv_Descricao;
	}

	public void setTiv_Descricao(String tiv_Descricao) {
		this.tiv_Descricao = tiv_Descricao;
	}

	public Boolean getTiv_Status() {
		return tiv_Status;
	}

	public void setTiv_Status(Boolean tiv_Status) {
		this.tiv_Status = tiv_Status;
	}

	public Date getTiv_Createdat() {
		return tiv_Createdat;
	}

	public void setTiv_Createdat(Date tiv_Createdat) {
		this.tiv_Createdat = tiv_Createdat;
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
