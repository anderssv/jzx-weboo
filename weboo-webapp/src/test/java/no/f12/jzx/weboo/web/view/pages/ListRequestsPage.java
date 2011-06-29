package no.f12.jzx.weboo.web.view.pages;

import static junit.framework.Assert.*;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_INFORMATION_REQUEST;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.url;

import java.util.List;

import no.f12.jzx.weboo.domain.InformationRequest;

import org.openqa.selenium.By;
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

	public void assertShows(InformationRequest request) {
		assertNotNull(requestListing);
		assertTrue(requestListing.isEnabled());
		
		Boolean found = false;
		List<WebElement> requests = requestListing.findElements(By.className("informationRequest"));
		for (WebElement webElement : requests) {
			WebElement numberElement = webElement.findElement(By.className("requestNumber"));
			if (numberElement.isEnabled() && numberElement.getText().equals(request.getId().toString())) {
				assertEquals(request.getTitle(), webElement.findElement(By.className("requestTitle")).getText());
				found = true;
				break;
			} 
		}
		assertTrue(found);
	}

	public void goTo() {
		getDriver().get(getApplicationUrl() + url(URL_INFORMATION_REQUEST));
		assertAt();
	}

}
