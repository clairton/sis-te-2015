package br.edu.horus.gellerp;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	List<Produto> produtos = new ArrayList<Produto>();

	public void addProduto(Produto produto) {
		produtos.add(produto);		
	}

	public Double total() {
		return produtos.stream()
					.map(p -> p.getValor())
					.reduce((v1, v2) -> v1 + v2)
					.get();
	}
	
	
}
