package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.InformationRequestBuilder;
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

	@Test
	public void shouldLookupExistingOrganisation() throws Exception {
		InformationRequestBuilder informationRequestBuilder = InformationRequestDataProvider.defaultInformationRequest();
		InformationRequest informationRequest = informationRequestBuilder.build();
		registerRequestInformation(informationRequest);
		registerOrganization(informationRequest, true);

		InformationRequest informationRequest2 = InformationRequestDataProvider.defaultInformationRequest()
				.withOrganization(informationRequestBuilder.getOrganization()).build();
		
		OrganizationRegistrationPage orgPage = registerRequestInformation(informationRequest2);
		orgPage.fillIn(informationRequest2.getOrganization().getOrganizationNumber());
		orgPage.lookup();
		
		orgPage.assertOrganisationName(informationRequest2.getOrganization().getName());
	}

	private InformationRequestSummaryPage registerOrganization(InformationRequest request, boolean allowExistingOrganization) {
		OrganizationRegistrationPage orgPage = organizationPage();
		
		orgPage.fillIn(request.getOrganization().getOrganizationNumber());
		orgPage.lookup();
		
		if (orgPage.hitOnLookup() && !allowExistingOrganization){
			throw new IllegalStateException();
		}
		if (!orgPage.hitOnLookup()){
			orgPage.fillIn(request.getOrganization());
		}
		
		orgPage.submit();

		InformationRequestSummaryPage overviewPage = overviewPage();
		overviewPage.assertAt();
		return overviewPage;	
	}

	private OrganizationRegistrationPage registerRequestInformation(InformationRequest request) {
		InformationRequestPage requestPage = informationRequestPage();
		OrganizationRegistrationPage orgPage = organizationPage();
		
		requestPage.goTo();
		requestPage.assertAt();

		requestPage.fillIn(request);
		requestPage.submit();

		orgPage.assertAt();
		return orgPage;
	}

	private Long registerRequest(InformationRequest request) {
		OrganizationRegistrationPage orgPage = registerRequestInformation(request);
		orgPage.fillIn(request.getOrganization().getOrganizationNumber());
		orgPage.lookup();
		orgPage.fillIn(request.getOrganization());	

		orgPage.submit();
		InformationRequestSummaryPage overviewPage = overviewPage();

		overviewPage.assertAt();
		return overviewPage.getRegisteredRequestIdentifier();
	}

	@Test
	public void shouldListAllRequestsSortedOnDate() {
		InformationRequest request1 = InformationRequestDataProvider.defaultInformationRequest().title("Request2").build();
		InformationRequest request2 = InformationRequestDataProvider.defaultInformationRequest().title("Request1").build();

		Long requestId1 = registerRequest(request1);
		Long requestId2 = registerRequest(request2);

		request1.setId(requestId1);
		request2.setId(requestId2);

		ListRequestsPage listPage = listRequestsPage();
		listPage.goTo();
		listPage.assertShows(request1);
		listPage.assertShows(request2);
		listPage.assertAlphabeticalSorting();
	}

}
