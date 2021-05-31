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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fom_Id;
	
	@Column(unique = true)
	private String fom_Descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "forcaMilitares")
	private List<PostoGraduacoes> postoGraduacoes;
	
	
	public ForcasMilitares() {
		// TODO Auto-generated constructor stub
	}
	
	public ForcasMilitares(Long fom_Id, String fom_Descricao, List<PostoGraduacoes> postoGraduacoes) {
		super();
		this.fom_Id = fom_Id;
		this.fom_Descricao = fom_Descricao;
		this.postoGraduacoes = postoGraduacoes;
	}
	

	public Long getFom_Id() {
		return fom_Id;
	}

	public void setFom_Id(Long fom_Id) {
		this.fom_Id = fom_Id;
	}

	public String getFom_Descricao() {
		return fom_Descricao;
	}

	public void setFom_Descricao(String fom_Descricao) {
		this.fom_Descricao = fom_Descricao;
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
		result = prime * result + ((fom_Descricao == null) ? 0 : fom_Descricao.hashCode());
		result = prime * result + ((fom_Id == null) ? 0 : fom_Id.hashCode());
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
		if (fom_Descricao == null) {
			if (other.fom_Descricao != null)
				return false;
		} else if (!fom_Descricao.equals(other.fom_Descricao))
			return false;
		if (fom_Id == null) {
			if (other.fom_Id != null)
				return false;
		} else if (!fom_Id.equals(other.fom_Id))
			return false;
		if (postoGraduacoes == null) {
			if (other.postoGraduacoes != null)
				return false;
		} else if (!postoGraduacoes.equals(other.postoGraduacoes))
			return false;
		return true;
	}

	
	
	
	
	
	
}
