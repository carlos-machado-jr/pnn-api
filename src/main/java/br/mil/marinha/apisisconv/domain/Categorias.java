package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Audited
@Entity
@AuditTable(value = "categorias_audit")
public class Categorias implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cat_Id;

	@Column(unique = true)
	private String cat_Descricao;


	public Categorias() {
		// TODO Auto-generated constructor stub
	}
	
	public Categorias(Long cat_Id, String cat_Descricao) {
		super();
		this.cat_Id = cat_Id;
		this.cat_Descricao = cat_Descricao;
	}





	public Long getCat_Id() {
		return cat_Id;
	}

	public void setCat_Id(Long cat_Id) {
		this.cat_Id = cat_Id;
	}

	public String getCat_Descricao() {
		return cat_Descricao;
	}

	public void setCat_Descricao(String cat_Descricao) {
		this.cat_Descricao = cat_Descricao;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_Descricao == null) ? 0 : cat_Descricao.hashCode());
		result = prime * result + ((cat_Id == null) ? 0 : cat_Id.hashCode());
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
		if (cat_Descricao == null) {
			if (other.cat_Descricao != null)
				return false;
		} else if (!cat_Descricao.equals(other.cat_Descricao))
			return false;
		if (cat_Id == null) {
			if (other.cat_Id != null)
				return false;
		} else if (!cat_Id.equals(other.cat_Id))
			return false;
		return true;
	}
}
