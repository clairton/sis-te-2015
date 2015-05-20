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
}
