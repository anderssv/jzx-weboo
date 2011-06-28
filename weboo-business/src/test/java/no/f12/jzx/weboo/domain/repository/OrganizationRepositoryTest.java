package no.f12.jzx.weboo.domain.repository;

import static org.junit.Assert.*;
import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.test.OrganizationDataProvider;

import org.junit.Test;

public class OrganizationRepositoryTest {

	@Test
	public void shouldAssignIdentifierToOrganization() {
		InformationRequestRepository orgRepo = new InformationRequestRepositoryImpl();
		Organization org = OrganizationDataProvider.createDefaultOrganization().build();

		orgRepo.addOrganization(org);

		assertNotNull(org.getId());
		assertNotNull(orgRepo.getOrganization(org.getId()));
	}

}
