package no.f12.jzx.weboo.test;

import no.f12.jzx.weboo.domain.OrganizationBuilder;
import no.f12.jzx.weboo.domain.OrganizationNumber;

public class OrganizationDataProvider {

	public static OrganizationBuilder createDefaultOrganization() {
		return new OrganizationBuilder().withOrganizationNumber(new OrganizationNumber("123456789")).withName("My Org");
	}

}
