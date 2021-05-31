package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

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
	
	private String fom_Descricao;

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
	
	
	
}
