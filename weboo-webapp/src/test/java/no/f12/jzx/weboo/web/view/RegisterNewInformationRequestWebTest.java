package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.test.InformationRequestDataProvider;
import no.f12.jzx.weboo.web.view.pages.InformationRequestPage;
import no.f12.jzx.weboo.web.view.pages.InformationRequestSummaryPage;
import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;

import org.junit.Test;

public class RegisterNewInformationRequestWebTest extends AbstractWebTest {
	
	@Test
	public void shouldRegisterNewRequestWithNewOrganization() {
		InformationRequest request = InformationRequestDataProvider.defaultInformationRequest().build();

		InformationRequestPage requestPage = informationRequestPage();
		OrganizationRegistrationPage orgPage = organizationPage();
		InformationRequestSummaryPage overviewPage = overviewPage();

		requestPage.goTo();
		requestPage.assertAt();
		
		requestPage.fillIn(request);
		requestPage.submit();
		
		orgPage.assertAt();
		orgPage.fillIn(request.getOrganization());
		orgPage.submit();
		
		overviewPage.assertAt();
		overviewPage.assertRequestRegistered(request);
	}
	
}
