package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;

import org.junit.Test;

public class FrontPageWebTest extends AbstractWebTest {

	@Test
	public void shouldApplySitemeshDecorator() {
		OrganizationRegistrationPage organizationPage = organizationPage();
		organizationPage.goTo();
		organizationPage.assertText("Sitemesh decorator");
	}

}
