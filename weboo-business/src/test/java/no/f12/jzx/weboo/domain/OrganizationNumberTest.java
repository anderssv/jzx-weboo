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

}
