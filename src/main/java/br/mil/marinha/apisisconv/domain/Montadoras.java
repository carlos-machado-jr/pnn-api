package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@AuditTable("montadoras_audit")
public class Montadoras implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mon_Id;
	
	private String mon_Descricao;
	
	private Boolean mon_Status;
	private Date mon_Createdat;
	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="rel_tipo_montadoras", joinColumns = {@JoinColumn(name="mon_Id")}, inverseJoinColumns = {@JoinColumn(name="tiv_Id")})
	private List<TipoVeiculos> tipo_Veiculos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "montadoras")
	private List<Veiculos> veiculos;

	public Long getMon_Id() {
		return mon_Id;
	}

	public void setMon_Id(Long mon_Id) {
		this.mon_Id = mon_Id;
	}

	public String getMon_Descricao() {
		return mon_Descricao;
	}

	public void setMon_Descricao(String mon_Descricao) {
		this.mon_Descricao = mon_Descricao;
	}

	public Boolean getMon_Status() {
		return mon_Status;
	}

	public void setMon_Status(Boolean mon_Status) {
		this.mon_Status = mon_Status;
	}

	public Date getMon_Createdat() {
		return mon_Createdat;
	}

	public void setMon_Createdat(Date mon_Createdat) {
		this.mon_Createdat = mon_Createdat;
	}

	


	public List<TipoVeiculos> getTipo_Veiculos() {
		return tipo_Veiculos;
	}

	public void setTipo_Veiculos(List<TipoVeiculos> tipo_Veiculos) {
		this.tipo_Veiculos = tipo_Veiculos;
	}

	public List<Veiculos> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}
	
	
	
}
