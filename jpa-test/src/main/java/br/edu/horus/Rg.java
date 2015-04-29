package br.edu.horus;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Rg")
public class Rg extends AbstractDocumento{
	
	@Column(name="orgao_emissor")
	@OrgaoEmissor({"SESP","Maracujá"})
	private String orgaoEmissor;
	
	public Rg() {}
	
	public Rg(String valor, Pessoa pessoa) {
		super(valor, pessoa);
	}
	
	public Rg(String valor, String orgaoEmissor, Pessoa pessoa) {
		this(valor, pessoa);
		this.orgaoEmissor = orgaoEmissor;
	}
}
