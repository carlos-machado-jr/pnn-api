package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.mil.marinha.apisisconv.dto.NewVeiculosDTO;

@Entity
@Audited
@AuditTable("veiculos_audit")
@Table(name = "veiculos")
public class Veiculos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "bigInt", name = "vei_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "varchar(50)", name = "vei_Modelo")
	private String model;
	
	@Column(columnDefinition = "varchar(6)", name = "vei_Ano")
	private String year;
	
	@Column(columnDefinition = "varchar(20)", name = "vei_Placa")
	private String licensePlate;
	
	@Column(columnDefinition = "varchar(30)", name = "vei_cor")
	private String color;

	@ManyToOne
	@JoinColumn(name = "vei_Pro_Id")
	private Proprietarios proprietarios;

	@ManyToOne
	@JoinColumn(name = "vei_Montadora_Id")
	private Montadoras montadoras;

	@OneToOne
	@JoinColumn(name = "vei_Cartao_Id", referencedColumnName = "cae_Id")
	private CartaoEstacionamento cartaoEstacionamento;

	@ManyToOne
	@JoinColumn(name = "vei_Tipo_Id")
	private TipoVeiculos tipoVeiculos;

	@Column(columnDefinition = "TINYINT", name = "vei_status", nullable = false)
	private boolean status;
	
	@Column(columnDefinition = "datetime", name = "vei_Validade", nullable = false)
	private String validity;
	
	@Column(columnDefinition = "datetime", name = "vei_CreatedAt", nullable = false)
	private String createdAt;
	
	@Column(columnDefinition = "varchar(255)", name = "vei_Observacao")
	private String note;

	
	
	
	public Veiculos() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Veiculos(NewVeiculosDTO veiculosDto) {
		super();
		this.id = null;
		this.model = veiculosDto.getModel();
		this.year = veiculosDto.getYear();
		this.licensePlate = veiculosDto.getLicensePlate();
		this.color = veiculosDto.getColor();
		this.status = true;
		this.createdAt = getNowDate();
		
		this.validity = plusYears(this.createdAt, 1);
		this.note = veiculosDto.getNote();
	}

	
	private String plusYears(String date, int years) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime newValidity = LocalDateTime.parse(date.replace(" ", "T")).plusYears(years);
		return newValidity.format(formatter);
	}
	private String getNowDate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		return date.format(now);
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long vei_Id) {
		this.id = vei_Id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String vei_Modelo) {
		this.model = vei_Modelo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String vei_Ano) {
		this.year = vei_Ano;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String vei_Placa) {
		this.licensePlate = vei_Placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String vei_Cor) {
		this.color = vei_Cor;
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
		return cartaoEstacionamento;
	}

	public void setCartao_estacionamento(CartaoEstacionamento cartao_estacionamento) {
		this.cartaoEstacionamento = cartao_estacionamento;
	}

	public TipoVeiculos getTipo_Veiculos() {
		return tipoVeiculos;
	}

	public void setTipo_Veiculos(TipoVeiculos tipo_Veiculos) {
		this.tipoVeiculos = tipo_Veiculos;
	}

	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean vei_Status) {
		this.status = vei_Status;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String vei_Validade) {
		this.validity = vei_Validade;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String vei_Createdat) {
		this.createdAt = vei_Createdat;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String vei_Observacao) {
		this.note = vei_Observacao;
	}

}
