package no.f12.jzx.weboo.web.controller;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.springframework.validation.DirectFieldBindingResult;

import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.domain.repository.OrganizationRepository;
import no.f12.jzx.weboo.test.OrganizationDataProvider;

import static org.mockito.Mockito.*;

public class OrganizationRegistrationControllerTest {

	@Test
	public void shouldAddOrganizationToRepositoryIfNoErrors() {
		OrganizationRegistrationController controller = new OrganizationRegistrationController();
		OrganizationRepository orgaRepo = mock(OrganizationRepository.class);
		controller.setOrganizationRepository(orgaRepo);

		Organization org = OrganizationDataProvider.createDefaultOrganization();
		String resultingView = controller.showOverView(org, new DirectFieldBindingResult(org, "organization"));
		assertEquals("organization/overviewForm", resultingView);
		verify(orgaRepo).addOrganization(org);
	}

}
