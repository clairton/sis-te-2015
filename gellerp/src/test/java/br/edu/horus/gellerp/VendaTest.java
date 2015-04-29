package br.edu.horus.gellerp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class VendaTest {

	@Test
	public void test() {
		Venda venda = new  Venda();
		Double valor = Double.valueOf(1220);
		venda.addProduto(new Produto(valor));
		Assert.assertEquals(valor, venda.total());
	}

}
