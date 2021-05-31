package br.mil.marinha.apisisconv.dto;

import br.mil.marinha.apisisconv.domain.Categorias;
import br.mil.marinha.apisisconv.domain.ForcasMilitares;

public class PostoGraduacoesDTO {
	
	private Long id;
	private String posto;
	private String categoria;
	private String forca;
	
	
	
	public PostoGraduacoesDTO() {
		// TODO Auto-generated constructor stub
	}

	
	

	public PostoGraduacoesDTO(Long id, String posto, Categorias categoria, ForcasMilitares forca) {
		super();
		this.id = id;
		this.posto = posto;
		this.categoria = categoria.getCat_Descricao();
		this.forca = forca.getFom_Descricao();
	}




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPosto() {
		return posto;
	}



	public void setPosto(String posto) {
		this.posto = posto;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getForca() {
		return forca;
	}



	public void setForca(String forca) {
		this.forca = forca;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((forca == null) ? 0 : forca.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((posto == null) ? 0 : posto.hashCode());
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
		PostoGraduacoesDTO other = (PostoGraduacoesDTO) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (forca == null) {
			if (other.forca != null)
				return false;
		} else if (!forca.equals(other.forca))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (posto == null) {
			if (other.posto != null)
				return false;
		} else if (!posto.equals(other.posto))
			return false;
		return true;
	}
	
	
	
}
