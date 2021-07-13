package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@AuditTable("posto_graduacoes_audit")
@Table(name = "posto_graduacoes")
public class PostoGraduacoes implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigInt", name = "pog_Id")
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", name = "pog_Descricao", nullable = false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "pog_Categoria_Id")
	private Categorias categorias;
	
	@ManyToOne
	@JoinColumn(name = "pog_Forca_Id")
	private ForcasMilitares forcaMilitares;
	
	
	@Column(columnDefinition = "datetime", name = "pog_CreatedAt", nullable = false)
	private String createdAt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "postoGraduacoes")
	private List<Proprietarios> proprietarios;
	
	public PostoGraduacoes() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pog_Id) {
		this.id = pog_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pog_Descricao) {
		this.description = pog_Descricao;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public ForcasMilitares getForcaMilitares() {
		return forcaMilitares;
	}

	public void setForcaMilitares(ForcasMilitares forcaMilitares) {
		this.forcaMilitares = forcaMilitares;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String pog_CreatedAt) {
		this.createdAt = pog_CreatedAt;
	}


	
	
	

	public List<Proprietarios> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(List<Proprietarios> proprietarios) {
		this.proprietarios = proprietarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorias == null) ? 0 : categorias.hashCode());
		result = prime * result + ((forcaMilitares == null) ? 0 : forcaMilitares.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostoGraduacoes other = (PostoGraduacoes) obj;
		if (categorias == null) {
			if (other.categorias != null)
				return false;
		} else if (!categorias.equals(other.categorias))
			return false;
		if (forcaMilitares == null) {
			if (other.forcaMilitares != null)
				return false;
		} else if (!forcaMilitares.equals(other.forcaMilitares))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

	
	
	
}
