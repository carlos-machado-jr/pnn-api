package br.mil.marinha.apisisconv.dto;

import java.util.Date;
import java.util.List;

import br.mil.marinha.apisisconv.domain.PostoGraduacoes;
import br.mil.marinha.apisisconv.domain.Setores;
import br.mil.marinha.apisisconv.domain.Telefones;

public class ProprietariosDTO {
	
	private Long id;
	private String nome;
	private String nipCpf;
	private String email;
	private String cnh;
	private Date dataCriacao;
	
	private String posto;
	private String setor;
	private List<Telefones> telefones;
	
	private String status;
	private String observacao;
	
	public ProprietariosDTO(Long id, String nome, String nipCpf, String email, String cnh, Date dataCriacao,
			PostoGraduacoes posto, Setores setor, List<Telefones> telefones, Boolean status, String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.nipCpf = nipCpf;
		this.email = email;
		this.cnh = cnh;
		this.dataCriacao = dataCriacao;
		this.posto = posto.getPog_Descricao();
		this.setor = setor.getSet_Descricao();
		this.telefones = telefones;
		this.status = status ? "Ativado" : "Desativado";
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNipCpf() {
		return nipCpf;
	}

	public void setNipCpf(String nipCpf) {
		this.nipCpf = nipCpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}



	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public List<Telefones> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefones> telefones) {
		this.telefones = telefones;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnh == null) ? 0 : cnh.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nipCpf == null) ? 0 : nipCpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((posto == null) ? 0 : posto.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
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
		ProprietariosDTO other = (ProprietariosDTO) obj;
		if (cnh == null) {
			if (other.cnh != null)
				return false;
		} else if (!cnh.equals(other.cnh))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nipCpf == null) {
			if (other.nipCpf != null)
				return false;
		} else if (!nipCpf.equals(other.nipCpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (posto == null) {
			if (other.posto != null)
				return false;
		} else if (!posto.equals(other.posto))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (telefones == null) {
			if (other.telefones != null)
				return false;
		} else if (!telefones.equals(other.telefones))
			return false;
		return true;
	}
	
	
	

}
