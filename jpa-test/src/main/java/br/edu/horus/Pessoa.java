package br.edu.horus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;

	private Date nascidoEm;
	
	@OneToMany(mappedBy="pessoa")
	private List<Documento> documentos = new ArrayList<Documento>();
	
	public Pessoa() {}

	public Pessoa(String nome, Date nascidoEm) {
		this.nome = nome;
		this.nascidoEm = nascidoEm;
	}

	public Integer getId() {
		return id;
	}

	public Date getNascidoEm() {
		return nascidoEm;
	}

	public String getNome() {
		return nome;
	}
	
	public List<Documento> getDocumentos() {
		return documentos;
	}
}
