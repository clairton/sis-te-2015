package generic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ControladorTransacao implements InvocationHandler {
	private Object delegate;
	
	public ControladorTransacao(Object delegate){
		this.delegate = delegate;
	}	
	
	@Override
	public Object invoke(Object proxy, 
			Method method, 
			Object[] args)
			throws Throwable {
		if(method.isAnnotationPresent(Transacional.class)){			
			System.out.println("Begin");
			Object retorno = method.invoke(delegate, args);
			System.out.println("Commit");
			return retorno;
		}else{
			return method.invoke(delegate, args);
		}
		
	}

}
