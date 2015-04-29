package generic;

import java.util.List;

public class Relatorio {
	private Repositorio<Produto> repositorio;

	public Relatorio(Repositorio<Produto> repositorio) {
		this.repositorio = repositorio;
	}

	public void imprimir() {
		List<Produto> produtos = repositorio.listar();

		Integer total = produtos
			.stream()
			.map(p -> p.getCodigo())
			.reduce((v1, v2) -> v1 + v2).get();
		
		System.err.println(total);
	}
	
	public void imprimirMaiorQue(Integer limite){
		List<Produto> produtos = repositorio.listar();
		
		Integer total = produtos
			.parallelStream()
			.filter(p -> p.getCodigo() > limite)
			.map(p -> p.getCodigo())
			.reduce((v1, v2) -> v1 + v2).get();
		
		System.err.println(total);
	}
}






//Optional<Integer> total = produtos
//	.stream()
//	.map(p -> p.getCodigo())
//	.reduce((v1, v2) -> v1 + v2);
//
//System.err.println(total.get());