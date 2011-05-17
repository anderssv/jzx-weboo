package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.domain.OrganizationNumber;
import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;
import no.f12.jzx.weboo.web.view.pages.OverviewPage;

import org.junit.Test;

public class OrganizationRegistrationPageTest extends AbstractWebTest {

	@Test
	public void shouldEnableRegistrationOfOrganization() {
		Organization org = new Organization(new OrganizationNumber("123456789"), "My Org");

		OrganizationRegistrationPage orgPage = new OrganizationRegistrationPage(getDriver(), getApplicationUrl());

		orgPage.goTo();
		orgPage.fillIn(org);
		orgPage.submit();

		OverviewPage overviewPage = new OverviewPage(getDriver(), getApplicationUrl());
		overviewPage.assertAt();
	}

	@Test
	public void shouldDisplayErrorMessagesWhenValidationFails() {
		Organization org = new Organization(new OrganizationNumber("123456789"), "");

		OrganizationRegistrationPage orgPage = new OrganizationRegistrationPage(getDriver(), getApplicationUrl());

		orgPage.goTo();
		orgPage.fillIn(org);
		orgPage.submit();

		orgPage.assertAt();
		orgPage.assertErrors();
	}

}
