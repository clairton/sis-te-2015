package generic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Before;
import org.junit.Test;

public class RepositorioTransacionalTest {
	private Repositorio<Produto> repositorio;

	@Before
	public void iniciar() {
		repositorio = new RepositorioEmMemoria<>();

		InvocationHandler handler = new ControladorTransacao(repositorio);

		repositorio = (Repositorio) Proxy.newProxyInstance(
				RepositorioEmMemoria.class.getClassLoader(),
				new Class[] { Repositorio.class }, handler);
	}

	@Test
	public void test() {
		Produto produto = new Produto(1);
		repositorio.salvar(produto);
	}	
	
	@Test
	public void testRemover(){
		Produto produto = new Produto(2);
		repositorio.remover(produto);
	}
}
