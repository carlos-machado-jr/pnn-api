package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable("ramais_audit")
@Table(name = "ramais")
public class Ramais implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "bigInt", name = "ram_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", name = "ram_Descricao", nullable = false)
	private String description;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long ram_Id) {
		this.id = ram_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String ram_Descricao) {
		this.description = ram_Descricao;
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
