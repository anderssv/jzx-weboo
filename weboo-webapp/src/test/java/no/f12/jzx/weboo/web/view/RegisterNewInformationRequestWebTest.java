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

		registerRequest(request);

		InformationRequestSummaryPage overviewPage = overviewPage();
		overviewPage.assertRequestRegistered(request);
	}

	private Long registerRequest(InformationRequest request) {
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
		return overviewPage.getRegisteredRequestIdentifier();
	}

	
	@Test
	public void shouldListAllRequestsSortedOnDate() {
		InformationRequest request1 = InformationRequestDataProvider.defaultInformationRequest().title("Request1").build();
		InformationRequest request2 = InformationRequestDataProvider.defaultInformationRequest().title("Request2").build();
		
		Long requestId1 = registerRequest(request1);
		Long requestId2 = registerRequest(request2);
		
		request1.setId(requestId1);
		request2.setId(requestId2);

		ListRequestsPage listPage = listRequestsPage();
		listPage.goTo();
		listPage.assertShows(request1);
		listPage.assertShows(request2);
	}
	
}
