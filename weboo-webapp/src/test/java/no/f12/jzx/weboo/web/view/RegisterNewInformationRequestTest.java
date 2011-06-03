package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.test.InformationRequestDataProvider;
import no.f12.jzx.weboo.web.view.pages.InformationRequestPage;
import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;

import org.junit.Test;

public class RegisterNewInformationRequestTest extends AbstractWebTest {
	
	@Test
	public void shouldRegisterNewRequestWithNewOrganization() {
		InformationRequestPage requestPage = informationRequestPage();
		requestPage.goTo();
		requestPage.assertAt();
		
		InformationRequest request = InformationRequestDataProvider.defaultInformationRequest();
		requestPage.fill(request);
		requestPage.submit();
		
		OrganizationRegistrationPage orgPage = organizationPage();
		orgPage.assertAt();
	}


}
