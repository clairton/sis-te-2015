package br.edu.horus;

import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.Payload;

import org.junit.Test;

public class OrgaoEmissorValidatorTest {

	ConstraintValidator<OrgaoEmissor, String> validator = new OrgaoEmissorValidator();

	@Test
	public void testIsValid() {
		validator.initialize(new OrgaoEmissor() {

			public Class<? extends Annotation> annotationType() {
				return OrgaoEmissor.class;
			}

			public String[] value() {
				return new String[] { "SSP", "Abacate" };
			}

			public String message() {
				return "";
			}

			public Class<?>[] groups() {
				return new Class[] {};
			}

			public Class<? extends Payload>[] payload() {
				return new Class[] {};
			}
		});
		assertTrue(validator.isValid("Abacate", null));
	}

}
