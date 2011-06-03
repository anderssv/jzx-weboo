package no.f12.jzx.weboo.web.view.pages;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.web.controller.NavigationRegistry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationRequestPage extends AbstractPage {

	
	private WebElement title;
	private WebElement save;
	
	public InformationRequestPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	@Override
	protected String getTitle() {
		return "Register new request";
	}

	public void goTo() {
		getDriver().get(getApplicationUrl() + NavigationRegistry.URL_INFORMATION_REQUEST);
	}

	public void fill(InformationRequest request) {
		title.sendKeys(request.getTitle());
	}

	public void submit() {
		save.click();
	}

}
