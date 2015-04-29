package generic;

import java.util.List;

public interface Repositorio<T extends Entidade> {

	@Transacional
	public abstract void salvar(T entidade);

	public abstract List<T> listar();

	@Transacional
	public abstract void remover(T pessoa);

}