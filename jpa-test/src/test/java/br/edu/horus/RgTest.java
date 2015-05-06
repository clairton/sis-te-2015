package br.edu.horus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

public class RgTest {
	
	private Validator validator;
	
	@Before
	public void init(){
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	public void testInvalido() {
		Rg rg = new Rg("123456", "SSP", new Pessoa());
		Set<ConstraintViolation<Rg>> validations = validator.validate(rg);
		ConstraintViolation<Rg> validation = validations.iterator().next();
		assertEquals("Orgão Emissor inválido", validation.getMessage());
	}
	
	@Test
	public void testValido(){
		Rg rg = new Rg("123456", "Maracujá", new Pessoa());
		assertTrue(validator.validate(rg).isEmpty());
	}
	
	
	
	@Test
	public void testHora(){
		String regex = "[0-9]{2}:[0-9]{2}:[0-9]{2}";
		assertTrue("01:54:22".matches(regex));
		assertFalse("2:22:22".matches(regex));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
