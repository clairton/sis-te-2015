package generic;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEmMemoria<T extends Entidade> 
	implements Repositorio<T> {
	private List<T> pessoas = new ArrayList<T>();
	
	@Override
	public void salvar(T entidade) {
		if(entidade.isValido()){	
			System.out.println("Salvando");
			//begin
			pessoas.add(entidade);
			//commit
		}else{
			throw new 
			EntidadeNaoValidaException("Entidade não esta valida");
		}
	}

	@Override
	public List<T> listar() {
		return pessoas;
	}

	@Override
	public void remover(T pessoa) {
		System.out.println("Removendo");
		pessoas.remove(pessoa);		
	}
}
