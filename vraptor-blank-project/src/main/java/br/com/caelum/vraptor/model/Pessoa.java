package br.com.caelum.vraptor.model;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Pessoa {	
	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	private Integer id;

	private String nome;

	private Date nascidoEm;	
	
	public Pessoa() {}

	public Pessoa(String nome, Date nascidoEm) {
		this.nome = nome;
		this.nascidoEm = nascidoEm;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getNascidoEm() {
		return nascidoEm;
	}
	
	public Integer getId() {
		return id;
	}	
	
	public void setNascidoEm(Date nascidoEm) {
		this.nascidoEm = nascidoEm;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
