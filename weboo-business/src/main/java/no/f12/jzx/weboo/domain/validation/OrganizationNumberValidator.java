package no.f12.jzx.weboo.domain.validation;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrganizationNumberValidator implements ConstraintValidator<Annotation, String> {

	@Override
	public void initialize(Annotation constraintAnnotation) {
	}

	@Override
	public boolean isValid(String organizationNumber, ConstraintValidatorContext context) {
		if (organizationNumber != null) {
			return WeightedCrcNumberValidator.isValid(organizationNumber);
		}
		return true;
	}

}
