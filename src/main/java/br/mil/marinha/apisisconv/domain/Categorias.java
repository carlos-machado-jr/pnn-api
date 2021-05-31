package br.mil.marinha.apisisconv.domain;

import javax.persistence.Entity;

@Entity
public class Categorias {

	private Long cat_Id;

	private String cat_Descricao;

	
	
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

}
