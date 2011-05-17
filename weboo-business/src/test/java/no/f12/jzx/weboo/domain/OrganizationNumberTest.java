package no.f12.jzx.weboo.domain;

import static junit.framework.Assert.*;

import org.junit.Test;

public class OrganizationNumberTest {

	@Test
	public void shouldValidateCorrectly() {
		assertFalse(new OrganizationNumber("111111119").isValid());

		assertTrue(new OrganizationNumber("123456785").isValid());
		assertTrue(new OrganizationNumber("888884122").isValid());
		assertTrue(new OrganizationNumber("988340316").isValid());
	}

}
