package br.edu.horus.zoologico;

import org.junit.Assert;
import org.junit.Test;

import br.edu.horus.api.Cachorro;

public class PeixeTest {

	@Test
	public void testMovimentar() {
		Assert.assertEquals("nadando", new Peixe().movimentar());
	}
	
	@Test
	public void testMovimentarCachorro(){
		Assert.assertEquals("Correndo!", new Cachorro().movimentar());
	}

}
