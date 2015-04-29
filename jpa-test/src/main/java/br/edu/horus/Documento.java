package br.edu.horus;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Documento {
	@Id
	@GeneratedValue
	private Integer id;

	private String valor;

	@ManyToOne(cascade=CascadeType.ALL)
	private Pessoa pessoa;
	
	public Documento() {}

	public Documento(String valor, Pessoa pessoa) {
		this.valor = valor;
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public Integer getId() {
		return id;
	}

	public String getValor() {
		return valor;
	}
}
