package generic;

import org.junit.Assert;
import org.junit.Test;

public class PessoaTest {

	@Test
	public void testInvalido() {
		Pessoa joao = new Pessoa(null);
		Assert.assertFalse(joao.isValido());
	}
	
	@Test
	public void testValido(){
		Pessoa antonio = new Pessoa("Antônio");
		Assert.assertTrue(antonio.isValido());
	}
	
	@Test
	public void testIgual(){
		String nome = "Ademir";
		Pessoa p1 = new Pessoa(nome);
		Pessoa p2 = new Pessoa(nome);
		Assert.assertTrue(p1.equals(p2));
	}
	
	@Test
	public void testDiferente(){
		Pessoa p1 = new Pessoa("Cristian");
		Pessoa p2 = new Pessoa("Lucas");
		Assert.assertFalse(p1.equals(p2));		
		Assert.assertFalse(p1.equals(null));		
		Assert.assertFalse(p1.equals(1));		
	}
}






