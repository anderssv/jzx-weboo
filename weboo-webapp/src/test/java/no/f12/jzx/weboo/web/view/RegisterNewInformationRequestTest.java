package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.web.view.pages.InformationRequestPage;

import org.junit.Test;

public class RegisterNewInformationRequestTest extends AbstractWebTest {
	
	@Test
	public void shouldRegisterNewRequestWithNewOrganization() {
		InformationRequestPage requestPage = new InformationRequestPage(getDriver(), getApplicationUrl());
		requestPage.goTo();
		requestPage.assertAt();
		
		InformationRequest request = new InformationRequest();
		requestPage.fill(request);
	}

}
