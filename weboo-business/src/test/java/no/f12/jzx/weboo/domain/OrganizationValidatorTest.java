package no.f12.jzx.weboo.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

import no.f12.jzx.weboo.domain.validation.ValidOrganizationNumber;
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

		assertConstraintViolations(organizationBuilder.build(), "organizationNumber", NotNull.class);
	}

	@Test
	public void shouldFailOnInvalidOrganizationNumber() {
		OrganizationBuilder organizationBuilder = OrganizationDataProvider
				.createOrganzationWithInvalidOrganizationNumber();

		assertConstraintViolations(organizationBuilder.build(), "organizationNumber", ValidOrganizationNumber.class);
	}

	@SuppressWarnings("all")
	private <T> void assertConstraintViolations(T value, String path, Class... expectedConstraintViolations) {
		// Run with default groups
		Set<ConstraintViolation<T>> violations = validator.validate(value, new Class[] {});

		// Find all validation errors for given path
		Set<Class> foundViolations = new HashSet<Class>();
		for (ConstraintViolation<T> constraintViolation : violations) {
			if (constraintViolation.getPropertyPath().toString().equals(path)) {
				foundViolations.add(constraintViolation.getConstraintDescriptor().getAnnotation().annotationType());
			}
		}

		// Check that all expected violations are present
		for (Class clazz : expectedConstraintViolations) {
			assertTrue("No error of type '" + clazz + "' found for path '" + path + "'.", foundViolations
					.contains(clazz));
		}
	}

}
