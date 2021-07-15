package br.mil.marinha.apisisconv.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.mil.marinha.apisisconv.dto.NewProprietariosDTO;

@Entity
@Audited
@AuditTable("proprietarios_audit")
@Table(name = "proprietarios")
public class Proprietarios implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigInt", name = "pro_Id")
	private Long id;
	
	@Column(columnDefinition = "varchar(100)", name = "pro_Nome", nullable = false)
	private String name;
	
	@Column(columnDefinition = "varchar(20)", name = "pro_Nip_Cpf", nullable = false, unique = true)
	private String nipOrCpf;
	
	@Column(columnDefinition = "varchar(50)", name = "pro_Email")
	private String email;
	
	@Column(columnDefinition = "varchar(50)", name = "pro_Cnh", nullable = false, unique = true)
	private String driversLicense;
	
	@Column(columnDefinition = "datetime", name = "pro_CreatedAt", nullable = false)
	private String createdAt;
	
	@ManyToOne
	@JoinColumn(name = "pro_Posto_Id")
	private PostoGraduacoes postoGraduacoes;

	@ManyToOne
	@JoinColumn(name = "pro_Setor_Id")
	private Setores setores;
	
	@Column(columnDefinition = "tinyint", name = "pro_Status", nullable = false)
	private boolean status;
	
	@Column(columnDefinition = "varchar(255)", name = "pro_Observacao")
	private String note;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprietarios")
	private List<Telefones> telefones;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprietarios")
	private List<Veiculos> veiculos;
	
	
	
	public Proprietarios() {
		// TODO Auto-generated constructor stub
	}


	
	public Proprietarios(NewProprietariosDTO proprietariosDto) {
		super();
		this.id = null;
		this.name = proprietariosDto.getName().toLowerCase();
		this.nipOrCpf = proprietariosDto.getNipOrCpf();
		this.email = proprietariosDto.getEmail().toLowerCase();
		this.driversLicense = proprietariosDto.getDriversLicense();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		this.createdAt = date.format(now);
		this.status = true;
		this.note = proprietariosDto.getNote().toLowerCase();
	}



	public Long getId() {
		return id;
	}


	public void setId(Long pro_Id) {
		this.id = pro_Id;
	}


	public String getName() {
		return name;
	}


	public void setName(String pro_Nome) {
		this.name = pro_Nome;
	}


	public String getNipOrCpf() {
		return nipOrCpf;
	}


	public void setNipOrCpf(String pro_NipCpf) {
		this.nipOrCpf = pro_NipCpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String pro_Email) {
		this.email = pro_Email;
	}


	public String getDriversLicense() {
		return driversLicense;
	}


	public void setDriversLicense(String pro_Cnh) {
		this.driversLicense = pro_Cnh;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String pro_Createdat) {
		this.createdAt = pro_Createdat;
	}


	public PostoGraduacoes getPostoGraduacoes() {
		return postoGraduacoes;
	}


	public void setPostoGraduacoes(PostoGraduacoes postoGraduacoes) {
		this.postoGraduacoes = postoGraduacoes;
	}


	public Setores getSetores() {
		return setores;
	}


	public void setSetores(Setores setores) {
		this.setores = setores;
	}


	public boolean getisStatus() {
		return status;
	}


	public void setStatus(boolean pro_Status) {
		this.status = pro_Status;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String pro_Observacao) {
		this.note = pro_Observacao;
	}


	public List<Telefones> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<Telefones> telefones) {
		this.telefones = telefones;
	}


	public List<Veiculos> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(List<Veiculos> veiculos) {
		this.veiculos = veiculos;
	}


	
	
}
