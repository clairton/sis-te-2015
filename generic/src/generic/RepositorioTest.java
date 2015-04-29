package generic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RepositorioTest {
	private Repositorio<Pessoa> repositorio;
	private Pessoa pessoa;

	@Before
	public void setUp(){
		repositorio = new RepositorioEmMemoria<>();
		pessoa = new Pessoa("José");
	}
	
	@Test
	public void testSalvar() {
		repositorio.salvar(pessoa);		
		Assert.assertEquals(1, repositorio.listar().size());		
	}

	@Test
	public void testRemover() {
		testSalvar();
		repositorio.remover(pessoa);
		Assert.assertTrue(repositorio.listar().isEmpty());
	}
	
	@Test
	public void testSalvarProduto(){
		Repositorio<Produto> repositorio = new RepositorioEmMemoria<>();
		Produto alface = new Produto(1);
		repositorio.salvar(alface);
		Assert.assertEquals(1, repositorio.listar().size());
	}
	
	@Test
	public void testInValido(){
		try{
			repositorio.salvar(new Pessoa(null));
			Assert.fail("Putz era para ter lançado o erro");
		}catch(EntidadeNaoValidaException e){
			e.printStackTrace();
		}
	}
}





