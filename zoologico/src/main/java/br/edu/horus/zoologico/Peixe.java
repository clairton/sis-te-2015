package br.edu.horus.zoologico;

import br.edu.horus.api.Animal;

public class Peixe implements Animal{

	@Override
	public String movimentar() {
		return "nadando";		
	}
}
