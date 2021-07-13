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

@Audited
@Entity
@AuditTable(value = "categorias_audit")
@Table(name = "categorias")
public class Categorias implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigInt", name = "cat_Id")
	private Long id;

	@Column(columnDefinition = "varchar(50)", name = "cat_Descricao", nullable = false)
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categorias")
	private List<PostoGraduacoes> postoGraduacoes;
	
	
	
	
	public Categorias() {
		// TODO Auto-generated constructor stub
	}




	public Long getId() {
		return id;
	}

	public void setId(Long cat_Id) {
		this.id = cat_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String cat_Descricao) {
		this.description = cat_Descricao;
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
		Categorias other = (Categorias) obj;
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
