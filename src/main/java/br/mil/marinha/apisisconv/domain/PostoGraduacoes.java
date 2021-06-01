package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	private Long pog_Id;
	
	
	private String pog_Descricao;
	
	@ManyToOne
	@JoinColumn(name = "pog_Categoria_Id")
	private Categorias categorias;
	
	@ManyToOne
	@JoinColumn(name = "pog_Forca_Id")
	private ForcasMilitares forcaMilitares;
	
	
	private Date pog_CreatedAt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "postoGraduacoes")
	private List<Proprietarios> proprietarios;
	
	public PostoGraduacoes() {
		// TODO Auto-generated constructor stub
	}

	public PostoGraduacoes(Long pog_Id, String pog_Descricao, Categorias categorias, ForcasMilitares forcaMilitares,
			Date pog_CreatedAt) {
		super();
		this.pog_Id = pog_Id;
		this.pog_Descricao = pog_Descricao;
		this.categorias = categorias;
		this.forcaMilitares = forcaMilitares;
		this.pog_CreatedAt = pog_CreatedAt;
	}

	public Long getPog_Id() {
		return pog_Id;
	}

	public void setPog_Id(Long pog_Id) {
		this.pog_Id = pog_Id;
	}

	public String getPog_Descricao() {
		return pog_Descricao;
	}

	public void setPog_Descricao(String pog_Descricao) {
		this.pog_Descricao = pog_Descricao;
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

	public Date getPog_CreatedAt() {
		return pog_CreatedAt;
	}

	public void setPog_CreatedAt(Date pog_CreatedAt) {
		this.pog_CreatedAt = pog_CreatedAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + ((pog_CreatedAt == null) ? 0 : pog_CreatedAt.hashCode());
		result = prime * result + ((pog_Descricao == null) ? 0 : pog_Descricao.hashCode());
		result = prime * result + ((pog_Id == null) ? 0 : pog_Id.hashCode());
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
		if (pog_CreatedAt == null) {
			if (other.pog_CreatedAt != null)
				return false;
		} else if (!pog_CreatedAt.equals(other.pog_CreatedAt))
			return false;
		if (pog_Descricao == null) {
			if (other.pog_Descricao != null)
				return false;
		} else if (!pog_Descricao.equals(other.pog_Descricao))
			return false;
		if (pog_Id == null) {
			if (other.pog_Id != null)
				return false;
		} else if (!pog_Id.equals(other.pog_Id))
			return false;
		return true;
	}
	
	
	

	
	
	
}
