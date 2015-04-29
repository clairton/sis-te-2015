package generic;

public class Pessoa implements Entidade{
	private String nome;

	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public boolean isValido(){
		return nome != null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pessoa){ 
			Pessoa outro = (Pessoa) obj;
			return nome.equals(outro.nome);			
		}else{
			return false;
		}		
	}
}
