package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
@AuditTable("forcas_militares_audit")
@Table(name = "forcas_militares")
public class ForcasMilitares implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "bigInt", name = "fom_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", name = "fom_Descricao", nullable = false)
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "forcaMilitares")
	private List<PostoGraduacoes> postoGraduacoes;
	
	
	public ForcasMilitares() {
		// TODO Auto-generated constructor stub
	}
	

	

	public ForcasMilitares(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long fom_Id) {
		this.id = fom_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String fom_Descricao) {
		this.description = fom_Descricao;
	}

	public List<PostoGraduacoes> getPostoGraduacoes() {
		return postoGraduacoes;
	}

	public void setPostoGraduacoes(List<PostoGraduacoes> postoGraduacoes) {
		this.postoGraduacoes = postoGraduacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((postoGraduacoes == null) ? 0 : postoGraduacoes.hashCode());
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
		ForcasMilitares other = (ForcasMilitares) obj;
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
		if (postoGraduacoes == null) {
			if (other.postoGraduacoes != null)
				return false;
		} else if (!postoGraduacoes.equals(other.postoGraduacoes))
			return false;
		return true;
	}

	
	
	
	
	
	
}
