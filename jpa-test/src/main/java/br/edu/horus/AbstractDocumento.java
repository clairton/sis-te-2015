package br.edu.horus;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractDocumento extends Documento {

	public AbstractDocumento() {
		super();
	}

	public AbstractDocumento(String valor, Pessoa pessoa) {
		super(valor, pessoa);
	}

}
