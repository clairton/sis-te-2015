package br.edu.horus;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@DiscriminatorValue("Cpf")
public class Cpf extends AbstractDocumento{

	public Cpf(String valor, Pessoa pessoa) {
		super(valor, pessoa);
	}
	
	public Cpf() {}
	
	
	@Override
	@CPF
	public String getValor() {
		return super.getValor();
	}

}
