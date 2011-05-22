package no.f12.jzx.weboo.domain;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

import no.f12.jzx.weboo.test.OrganizationDataProvider;

import org.junit.Before;
import org.junit.Test;

public class OrganizationValidatorTest {

	private Validator validator;

	@Before
	public void setUpValidator() {
		ValidatorFactory validatorFactory = Validation.byDefaultProvider().configure().buildValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@Test
	public void shouldFailOnBlankOrganizaionNumber() {

		OrganizationBuilder organizationBuilder = OrganizationDataProvider.createDefaultOrganization()
				.withNoOrganizationNumber();

		checkForConstraintViolation(organizationBuilder.build(), "organizationNumber", NotNull.class);
	}

	@SuppressWarnings("all")
	private <T> void checkForConstraintViolation(T value, String path, Class expectedConstraintViolation) {
		Set<ConstraintViolation<T>> violations = validator.validate(value, new Class[] {});

		boolean errorForOrganizationNumber = false;
		for (ConstraintViolation<T> constraintViolation : violations) {
			if (constraintViolation.getPropertyPath().toString().equals(path)) {
				if (constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().equals(
						expectedConstraintViolation)) {
					errorForOrganizationNumber = true;
					break;
				}
			}
		}
		assertTrue("No error of type '" + expectedConstraintViolation + "' found for path '" + path + "'.",
				errorForOrganizationNumber);
	}

}
