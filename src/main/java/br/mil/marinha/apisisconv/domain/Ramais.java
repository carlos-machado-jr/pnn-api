package br.mil.marinha.apisisconv.domain;

public class Ramais {
	private Long ram_Id;
	private String ram_Descricao;

	private Setores setores;
	private TiposRamais tipoRamais;
	private OrganizacoesMilitares organizacoesMilitares;

	public Ramais() {
		// TODO Auto-generated constructor stub
	}

	public Long getRam_Id() {
		return ram_Id;
	}

	public void setRam_Id(Long ram_Id) {
		this.ram_Id = ram_Id;
	}

	public String getRam_Descricao() {
		return ram_Descricao;
	}

	public void setRam_Descricao(String ram_Descricao) {
		this.ram_Descricao = ram_Descricao;
	}

	public Setores getSetores() {
		return setores;
	}

	public void setSetores(Setores setores) {
		this.setores = setores;
	}

	public TiposRamais getTipoRamais() {
		return tipoRamais;
	}

	public void setTipoRamais(TiposRamais tipoRamais) {
		this.tipoRamais = tipoRamais;
	}

	public OrganizacoesMilitares getOrganizacoesMilitares() {
		return organizacoesMilitares;
	}

	public void setOrganizacoesMilitares(OrganizacoesMilitares organizacoesMilitares) {
		this.organizacoesMilitares = organizacoesMilitares;
	}
}
