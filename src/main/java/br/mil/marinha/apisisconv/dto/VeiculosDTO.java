package br.mil.marinha.apisisconv.dto;

import java.util.Date;

import br.mil.marinha.apisisconv.domain.Montadoras;
import br.mil.marinha.apisisconv.domain.TipoVeiculos;

public class VeiculosDTO {
	
	private Long id;
	private String modelo;
	private String ano;
	private String placa;
	private String cor;
	
	private String tipoVeiculo;
	private String montadora;
	private String status;
	private Date criacao;
	private String observacao;
	
	public VeiculosDTO(Long id, String modelo, String ano, String placa, String cor, TipoVeiculos tipoVeiculo,
			Montadoras montadora, Boolean status, Date criacao, String observacao) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.cor = cor;
		this.tipoVeiculo = tipoVeiculo.getTiv_Descricao();
		this.montadora = montadora.getMon_Descricao();
		this.status = status ? "Ativo": "Inativo";
		this.criacao = criacao;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
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
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((criacao == null) ? 0 : criacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((montadora == null) ? 0 : montadora.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoVeiculo == null) ? 0 : tipoVeiculo.hashCode());
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
		VeiculosDTO other = (VeiculosDTO) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (criacao == null) {
			if (other.criacao != null)
				return false;
		} else if (!criacao.equals(other.criacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (montadora == null) {
			if (other.montadora != null)
				return false;
		} else if (!montadora.equals(other.montadora))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoVeiculo == null) {
			if (other.tipoVeiculo != null)
				return false;
		} else if (!tipoVeiculo.equals(other.tipoVeiculo))
			return false;
		return true;
	}
	
	
	

}
