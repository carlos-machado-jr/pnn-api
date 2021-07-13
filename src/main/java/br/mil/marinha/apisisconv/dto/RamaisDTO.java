package br.mil.marinha.apisisconv.dto;

import br.mil.marinha.apisisconv.domain.OrganizacoesMilitares;
import br.mil.marinha.apisisconv.domain.Setores;
import br.mil.marinha.apisisconv.domain.TiposRamais;

public class RamaisDTO {
	
	private Long id;
	private String ramal;
	private String setor;
	private String tipo;
	private String organizacaoMilitar;
	
	
	public RamaisDTO(Long id, String ramal, Setores setor, TiposRamais tipo, OrganizacoesMilitares organizacaoMilitar) {
		super();
		this.id = id;
		this.ramal = ramal;
		this.setor = setor.getDescription();
		this.tipo = tipo.getDescription();
		this.organizacaoMilitar = organizacaoMilitar.getDescription();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRamal() {
		return ramal;
	}


	public void setRamal(String ramal) {
		this.ramal = ramal;
	}


	public String getSetor() {
		return setor;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getOrganizacaoMilitar() {
		return organizacaoMilitar;
	}


	public void setOrganizacaoMilitar(String organizacaoMilitar) {
		this.organizacaoMilitar = organizacaoMilitar;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((organizacaoMilitar == null) ? 0 : organizacaoMilitar.hashCode());
		result = prime * result + ((ramal == null) ? 0 : ramal.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		RamaisDTO other = (RamaisDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (organizacaoMilitar == null) {
			if (other.organizacaoMilitar != null)
				return false;
		} else if (!organizacaoMilitar.equals(other.organizacaoMilitar))
			return false;
		if (ramal == null) {
			if (other.ramal != null)
				return false;
		} else if (!ramal.equals(other.ramal))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
