package br.com.fiap.checkpoint1.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="funcionario", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize =1)
public class Funcionario extends Pessoa{


	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="funcionario")
	private Integer codigo;
	
	@Column(name="vl_salario", precision=10,scale=2)
	private BigDecimal salario ;
	
	@Column(name="ds_ativo", length=60, nullable=false)
	private Boolean isActive;
	
	@Column(name="dt_admissao")
	@Temporal(TemporalType.DATE)
	private Calendar admissao;

	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_produtividade", length = 20, nullable = false)
	private Produtividade produtividade;
	
	public Funcionario() {}

	public Funcionario(String nome, String cpf, Integer idade, BigDecimal salario, Boolean isActive, Calendar admissao, byte[] foto,
			Produtividade produtividade) {
		super(nome, cpf, idade);
		this.salario = salario;
		this.isActive = isActive;
		this.admissao = admissao;
		this.foto = foto;
		this.produtividade = produtividade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Calendar getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Calendar admissao) {
		this.admissao = admissao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Produtividade getProdutividade() {
		return produtividade;
	}

	public void setProdutividade(Produtividade produtividade) {
		this.produtividade = produtividade;
	}
	
	

}
