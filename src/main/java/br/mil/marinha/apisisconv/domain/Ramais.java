package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable("ramais_audit")
public class Ramais implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ram_Id;
	
	private String ram_Descricao;
	
	@ManyToOne
	@JoinColumn(name = "ram_Setor_Id")
	private Setores setores;
	
	@ManyToOne
	@JoinColumn(name = "ram_Tipo_Id")
	private TiposRamais tipoRamais;
	
	@ManyToOne
	@JoinColumn(name = "ram_Om_Id")
	private OrganizacoesMilitares organizacoesMilitares;

	public Ramais() {
		// TODO Auto-generated constructor stub
	}

	public Long getRam_Id() {
		return ram_Id;
	}

	public void setRam_Id(Long ram_Id) {
		this.ram_Id = ram_Id;
	}

	public String getRam_Descricao() {
		return ram_Descricao;
	}

	public void setRam_Descricao(String ram_Descricao) {
		this.ram_Descricao = ram_Descricao;
	}

	public Setores getSetores() {
		return setores;
	}

	public void setSetores(Setores setores) {
		this.setores = setores;
	}

	public TiposRamais getTipoRamais() {
		return tipoRamais;
	}

	public void setTipoRamais(TiposRamais tipoRamais) {
		this.tipoRamais = tipoRamais;
	}

	public OrganizacoesMilitares getOrganizacoesMilitares() {
		return organizacoesMilitares;
	}

	public void setOrganizacoesMilitares(OrganizacoesMilitares organizacoesMilitares) {
		this.organizacoesMilitares = organizacoesMilitares;
	}
}
