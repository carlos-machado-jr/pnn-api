package br.mil.marinha.apisisconv.domain;

public class PostoGraduacoes {

	
	private Long pog_Id;
	
	private String pog_Descricao;
	
	private Categorias categorias;
	
	private ForcasMilitares forcaMilitares;
	
	
	public PostoGraduacoes() {
		// TODO Auto-generated constructor stub
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
	
	
	
}
