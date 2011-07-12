package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.web.view.pages.InformationRequestPage;

import org.junit.Test;

public class FrontPageWebTest extends AbstractWebTest {

	@Test
	public void shouldApplySitemeshDecorator() {
		InformationRequestPage informationRequestPage = informationRequestPage();
		informationRequestPage.goTo();
		informationRequestPage.assertText("Sitemesh decorator");
	}

}
