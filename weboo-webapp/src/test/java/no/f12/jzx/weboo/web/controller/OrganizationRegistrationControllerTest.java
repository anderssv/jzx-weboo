package no.f12.jzx.weboo.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.domain.repository.OrganizationRepository;
import no.f12.jzx.weboo.test.OrganizationDataProvider;
import no.f12.jzx.weboo.testutil.BeansUtil;

import org.junit.Test;
import org.springframework.validation.DirectFieldBindingResult;

import static no.f12.jzx.weboo.web.controller.NavigationRegistry.*;
public class OrganizationRegistrationControllerTest {

	@Test
	public void shouldAddOrganizationToRepositoryIfNoErrors() {
		InformationRequestController controller = new InformationRequestController();
		OrganizationRepository orgaRepo = mock(OrganizationRepository.class);
		controller.setOrganizationRepository(orgaRepo);

		Organization org = OrganizationDataProvider.createDefaultOrganization().build();
		String resultingView = controller.registerNewOrganization(org, new DirectFieldBindingResult(org, BeansUtil
				.beanName(Organization.class)));

		assertEquals(redirectTo(url(URL_INFORMATION_REQUEST, URL_INFORMATION_REQUEST_CONFIRMATION)), resultingView);
		verify(orgaRepo).addOrganization(org);
	}

}
