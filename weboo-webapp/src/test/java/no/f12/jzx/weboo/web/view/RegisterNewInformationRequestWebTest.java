package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.test.InformationRequestDataProvider;
import no.f12.jzx.weboo.web.view.pages.InformationRequestPage;
import no.f12.jzx.weboo.web.view.pages.InformationRequestSummaryPage;
import no.f12.jzx.weboo.web.view.pages.ListRequestsPage;
import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;

import org.junit.Test;

public class RegisterNewInformationRequestWebTest extends AbstractWebTest {
	
	@Test
	public void shouldRegisterNewRequestWithNewOrganization() {
		InformationRequest request = InformationRequestDataProvider.defaultInformationRequest().build();

		InformationRequestSummaryPage overviewPage = registerRequest(request);
		overviewPage.assertRequestRegistered(request);
	}

	private InformationRequestSummaryPage registerRequest(InformationRequest request) {
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
		return overviewPage;
	}

	
	@Test
	public void shouldListAllRequestsSortedOnDate() {
		InformationRequest request1 = InformationRequestDataProvider.defaultInformationRequest().title("Request1").build();
		InformationRequest request2 = InformationRequestDataProvider.defaultInformationRequest().title("Request2").build();
		
		registerRequest(request1);
		registerRequest(request2);
		
		ListRequestsPage listPage = listRequestsPage();
//		listPage.goTo();
//		listPage.assertShows(request1);
	}
	
}
