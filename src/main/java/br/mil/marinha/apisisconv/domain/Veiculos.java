package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Audited
@AuditTable("veiculos_audit")
public class Veiculos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vei_Id;

	private String vei_Modelo;
	private String vei_Ano;
	private String vei_Placa;
	private String vei_Cor;

	@ManyToOne
	@JoinColumn(name = "vei_Pro_Id")
	private Proprietarios proprietarios;

	@ManyToOne
	@JoinColumn(name = "vei_Montadora_Id")
	private Montadoras montadoras;

	@OneToOne
	@JoinColumn(name = "vei_Cartao_Id", referencedColumnName = "cae_Id")
	private CartaoEstacionamento cartao_estacionamento;

	@ManyToOne
	@JoinColumn(name = "vei_Tipo_Id")
	private TipoVeiculos tipo_Veiculos;

	private Boolean vei_Status;
	private Date vei_Validade;
	private Date vei_Createdat;
	private String vei_Observacao;

	public Long getVei_Id() {
		return vei_Id;
	}

	public void setVei_Id(Long vei_Id) {
		this.vei_Id = vei_Id;
	}

	public String getVei_Modelo() {
		return vei_Modelo;
	}

	public void setVei_Modelo(String vei_Modelo) {
		this.vei_Modelo = vei_Modelo;
	}

	public String getVei_Ano() {
		return vei_Ano;
	}

	public void setVei_Ano(String vei_Ano) {
		this.vei_Ano = vei_Ano;
	}

	public String getVei_Placa() {
		return vei_Placa;
	}

	public void setVei_Placa(String vei_Placa) {
		this.vei_Placa = vei_Placa;
	}

	public String getVei_Cor() {
		return vei_Cor;
	}

	public void setVei_Cor(String vei_Cor) {
		this.vei_Cor = vei_Cor;
	}

	public Proprietarios getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(Proprietarios proprietarios) {
		this.proprietarios = proprietarios;
	}

	public Montadoras getMontadoras() {
		return montadoras;
	}

	public void setMontadoras(Montadoras montadoras) {
		this.montadoras = montadoras;
	}

	public CartaoEstacionamento getCartao_estacionamento() {
		return cartao_estacionamento;
	}

	public void setCartao_estacionamento(CartaoEstacionamento cartao_estacionamento) {
		this.cartao_estacionamento = cartao_estacionamento;
	}

	public TipoVeiculos getTipo_Veiculos() {
		return tipo_Veiculos;
	}

	public void setTipo_Veiculos(TipoVeiculos tipo_Veiculos) {
		this.tipo_Veiculos = tipo_Veiculos;
	}

	public Boolean getVei_Status() {
		return vei_Status;
	}

	public void setVei_Status(Boolean vei_Status) {
		this.vei_Status = vei_Status;
	}

	public Date getVei_Validade() {
		return vei_Validade;
	}

	public void setVei_Validade(Date vei_Validade) {
		this.vei_Validade = vei_Validade;
	}

	public Date getVei_Createdat() {
		return vei_Createdat;
	}

	public void setVei_Createdat(Date vei_Createdat) {
		this.vei_Createdat = vei_Createdat;
	}

	public String getVei_Observacao() {
		return vei_Observacao;
	}

	public void setVei_Observacao(String vei_Observacao) {
		this.vei_Observacao = vei_Observacao;
	}

}
