package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.test.OrganizationDataProvider;
import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;
import no.f12.jzx.weboo.web.view.pages.InformationRequestSummaryPage;

import org.junit.Test;

public class OrganizationRegistrationPageWebTest extends AbstractWebTest {

	@Test
	public void shouldEnableRegistrationOfOrganization() {
		Organization org = OrganizationDataProvider.createDefaultOrganization().build();

		OrganizationRegistrationPage orgPage = organizationPage();

		orgPage.goTo();
		orgPage.fillIn(org);
		orgPage.submit();

		InformationRequestSummaryPage overviewPage = overviewPage();
		overviewPage.assertAt();
	}
	
	@Test
	public void shouldDisplayErrorMessagesWhenValidationFails() {
		Organization org = OrganizationDataProvider.createDefaultOrganization().withName("").build();

		OrganizationRegistrationPage orgPage = organizationPage();

		orgPage.goTo();
		orgPage.fillIn(org);
		orgPage.submit();

		orgPage.assertAt();
		orgPage.assertErrors();
	}

}
