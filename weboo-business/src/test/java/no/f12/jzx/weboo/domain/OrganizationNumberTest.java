package no.f12.jzx.weboo.domain;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static no.f12.jzx.weboo.test.OrganizationDataProvider.createDefaultOrganizationNumber;
import static no.f12.jzx.weboo.test.OrganizationDataProvider.createInvalidOrganizationNumber;

import org.junit.Test;

public class OrganizationNumberTest {

	@Test
	public void shouldValidateCorrectly() {
		assertFalse(createInvalidOrganizationNumber().isValid());

		assertTrue(createDefaultOrganizationNumber().isValid());
	}
	
	@Test
	public void shouldNotAllowBlankValue() {
		assertFalse(new OrganizationNumber("").isValid());
	}
	
	@Test
	public void shouldNotAllowCharactersInOrganizationNumber() {
		assertFalse(new OrganizationNumber("Hello").isValid());
	}
	
	@Test
	public void shouldNotAllowTooShortOrganizationNumber() {
		assertFalse(new OrganizationNumber("12345678").isValid());
	}
	
	@Test
	public void shouldNotAllowTooLongOrganizationNumber() {
		assertFalse(new OrganizationNumber("1234567890").isValid());
	}
	
	

}
