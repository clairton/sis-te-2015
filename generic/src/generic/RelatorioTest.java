package generic;

import org.junit.Before;
import org.junit.Test;

public class RelatorioTest {
	private Relatorio relatorio;
	
	@Before
	public void iniciar(){
		Repositorio<Produto> repositorio = 
				new RepositorioEmMemoria<Produto>();
		relatorio = new Relatorio(repositorio);
		
		repositorio.salvar(new Produto(1));
		repositorio.salvar(new Produto(2));
		repositorio.salvar(new Produto(3));
		repositorio.salvar(new Produto(4));
		repositorio.salvar(new Produto(5));
	}

	@Test
	public void testImprimir() {
		relatorio.imprimir();
	}
	
	@Test
	public void testImprimirMaiorQue() {
		relatorio.imprimirMaiorQue(3);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
