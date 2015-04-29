package br.edu.horus;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrgaoEmissorValidator 
		implements ConstraintValidator<OrgaoEmissor, String>{
	private Set<String> validos = new HashSet<String>();
	
	
	public void initialize(OrgaoEmissor annotation) {
		String[] values = annotation.value();
		for (String string : values) {			
			validos.add(string);
		}
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return validos.contains(value);
	}

}
