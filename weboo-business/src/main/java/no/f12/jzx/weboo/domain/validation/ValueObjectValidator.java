package no.f12.jzx.weboo.domain.validation;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import no.f12.jzx.weboo.domain.ValueObject;

public class ValueObjectValidator implements ConstraintValidator<Annotation, ValueObject> {

	@Override
	public void initialize(Annotation constraintAnnotation) {
	}

	@Override
	public boolean isValid(ValueObject value, ConstraintValidatorContext context) {
		if (value != null) {
			return value.isValid();
		}
		return true;
	}

}
