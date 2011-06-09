package no.f12.jzx.weboo.test;

import no.f12.jzx.weboo.domain.OrganizationBuilder;
import no.f12.jzx.weboo.domain.OrganizationNumber;

public class OrganizationDataProvider {

	public static OrganizationBuilder createDefaultOrganization() {
		return OrganizationBuilder.with().organizationNumber(createDefaultOrganizationNumber()).withName("My Org");
	}

	public static OrganizationBuilder createOrganzationWithInvalidOrganizationNumber() {
		return createDefaultOrganization().organizationNumber(createInvalidOrganizationNumber());
	}

	public static OrganizationNumber createInvalidOrganizationNumber() {
		return new OrganizationNumber("111111119");
	}
	
	public static OrganizationNumber createDefaultOrganizationNumber() {
		return new OrganizationNumber("123456785");
	}

}
