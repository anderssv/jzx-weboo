package no.f12.jzx.weboo.web.view;

import static org.junit.Assert.*;
import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.InformationRequestBuilder;
import no.f12.jzx.weboo.test.InformationRequestDataProvider;
import no.f12.jzx.weboo.test.OrganizationDataProvider;
import no.f12.jzx.weboo.web.view.pages.InformationRequestSummaryPage;
import no.f12.jzx.weboo.web.view.pages.ListRequestsPage;
import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;

import org.junit.Test;

public class RegisterNewInformationRequestWebTest extends AbstractWebTest {

	@Test
	public void shouldNotValidateWhenNotValidOrganizationNumber() throws Exception {
		InformationRequestBuilder builder = InformationRequestDataProvider.defaultInformationRequest();
		builder.getOrganization().organizationNumber(OrganizationDataProvider.createInvalidOrganizationNumber());
		InformationRequest request = builder.build();

		OrganizationRegistrationPage organizationRegistrationPage = registerRequestInformation(request);
		organizationRegistrationPage.lookupOrganization(request.getOrganization().getOrganizationNumber());
		organizationRegistrationPage.assertErrors();
		assertTrue(organizationRegistrationPage.getErrors().getText().contains("Ugyldig"));
	}

	@Test
	public void shouldRegisterNewRequestWithNewOrganization() {
		InformationRequest request = InformationRequestDataProvider.defaultInformationRequest().build();

		registerRequest(request);

		InformationRequestSummaryPage informationRequestSummaryPage = pageRequestSummary();
		informationRequestSummaryPage.assertRequestRegistered(request);
	}

	@Test
	public void shouldLookupExistingOrganisation() throws Exception {
		InformationRequestBuilder informationRequestBuilder = InformationRequestDataProvider
				.defaultInformationRequest();
		InformationRequest informationRequest = informationRequestBuilder.build();
		registerRequestInformation(informationRequest);
		registerOrganization(informationRequest, true);

		InformationRequest informationRequest2 = InformationRequestDataProvider.defaultInformationRequest()
				.withOrganization(informationRequestBuilder.getOrganization()).build();

		OrganizationRegistrationPage orgPage = registerRequestInformation(informationRequest2);
		orgPage.lookupOrganization(informationRequest2.getOrganization().getOrganizationNumber());

		orgPage.assertOrganisationName(informationRequest2.getOrganization().getName());
	}

	@Test
	public void shouldListAllRequestsSortedOnDate() {
		InformationRequest request1 = InformationRequestDataProvider.defaultInformationRequest().title("Request2")
				.build();
		InformationRequest request2 = InformationRequestDataProvider.defaultInformationRequest().title("Request1")
				.build();

		registerRequest(request1);
		registerRequest(request2);

		ListRequestsPage listPage = pageListRequests();
		listPage.goTo();
		listPage.assertShows(request1);
		listPage.assertShows(request2);
		listPage.assertAlphabeticalSorting();
	}

	@Test
	public void shouldAvoidTripleSlashesOnRedirects() {
		InformationRequest request = InformationRequestDataProvider.defaultInformationRequest().build();

		registerRequest(request);
		pageListRequests().goTo();
		pageListRequests().clickReceived(request);

		String url = getDriver().getCurrentUrl();
		assertFalse("Url should not contain triple slashes: " + url, url.contains("///"));
	}

}
