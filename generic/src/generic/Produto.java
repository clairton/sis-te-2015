package generic;

public class Produto implements Entidade{
	private Integer codigo;
	
	public Produto(Integer codigo){
		this.codigo = codigo;
	}
	
	public boolean isValido(){
		return codigo != null;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
}
