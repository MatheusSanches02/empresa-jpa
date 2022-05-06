package br.com.fiap.checkpoint1.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {
	
	@Id
	@Column(name="cd_pessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;

	@Column(name="vl_cpf", length=20, nullable=false)
	private String cpf;
	
	@Column(name="nm_funcionario", length=20, nullable=false)
	private String nome;
	
	@Column(name="vl_idade")
	private Integer idade;
	
	public Pessoa() {}

	public Pessoa(String cpf, String nome, Integer idade) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	
	

}
