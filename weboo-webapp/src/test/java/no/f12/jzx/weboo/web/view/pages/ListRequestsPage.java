package no.f12.jzx.weboo.web.view.pages;

import static junit.framework.Assert.assertNotNull;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_INFORMATION_REQUEST;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.url;
import no.f12.jzx.weboo.domain.InformationRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListRequestsPage extends AbstractPage {

	private WebElement requestListing;
	
	public ListRequestsPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	@Override
	protected String getTitle() {
		return "All information requests";
	}

	public void assertShows(InformationRequest request1) {
		assertNotNull(requestListing);
	}

	public void goTo() {
		getDriver().get(getApplicationUrl() + url(URL_INFORMATION_REQUEST));
		assertAt();
	}

}
