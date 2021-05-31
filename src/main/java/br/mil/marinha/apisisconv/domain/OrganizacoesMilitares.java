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
@AuditTable("organizacoes_militares_audit")
@Table(name = "organizacoes_militares")
public class OrganizacoesMilitares implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long om_Id;
	
	private String om_Descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "organizacoesMilitares")
	private List<Ramais> ramais;

	
	
	public Long getOm_Id() {
		return om_Id;
	}

	public void setOm_Id(Long om_Id) {
		this.om_Id = om_Id;
	}

	public String getOm_Descricao() {
		return om_Descricao;
	}

	public void setOm_Descricao(String om_Descricao) {
		this.om_Descricao = om_Descricao;
	}

	public List<Ramais> getRamais() {
		return ramais;
	}

	public void setRamais(List<Ramais> ramais) {
		this.ramais = ramais;
	}

	


	
	
	
	
}
