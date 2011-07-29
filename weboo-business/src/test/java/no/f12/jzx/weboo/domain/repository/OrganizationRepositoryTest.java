package no.f12.jzx.weboo.domain.repository;

import static org.junit.Assert.*;

import java.util.List;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.test.InformationRequestDataProvider;
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

	@Test
	public void shouldFindOrganizationByOrganizationNumberIfExists() throws Exception {
		InformationRequestRepository orgRepo = new InformationRequestRepositoryImpl();
		Organization org = OrganizationDataProvider.createDefaultOrganization().build();

		orgRepo.addOrganization(org);
		Organization orgFromRepo = orgRepo.findOrganization(org.getOrganizationNumber());
		assertEquals(org, orgFromRepo);
	}

	@Test
	public void shouldReturnTwoLongestRunningRequests() {
		InformationRequestRepository requestRepo = new InformationRequestRepositoryImpl();

		for (int ctr = 0; ctr < 5; ctr++) {
			InformationRequest request = InformationRequestDataProvider.defaultInformationRequest()
					.daysSinceRegistration(ctr).build();
			requestRepo.addInformationRequest(request);
		}

		int size = 3;
		List<InformationRequest> slowestRequests = requestRepo.getSlowestRequests(size);
		assertEquals(size, slowestRequests.size());

		List<InformationRequest> fasterRequests = requestRepo.getRequests();
		fasterRequests.removeAll(slowestRequests);

		for (InformationRequest fasterRequest : fasterRequests) {
			for (InformationRequest slowRequest : slowestRequests) {
				assertTrue(
						"slow: " + slowRequest.getDaysSinceRegistration() + " faster: "
								+ fasterRequest.getDaysSinceRegistration(),
						slowRequest.getDaysSinceRegistration() > fasterRequest.getDaysSinceRegistration());
			}
		}
	}
}
