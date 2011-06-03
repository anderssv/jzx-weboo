package no.f12.jzx.weboo.web.view.pages;

import junit.framework.Assert;
import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.web.controller.NavigationRegistry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationRequestPage extends AbstractPage {

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
		getDriver().findElement(By.id("title")).sendKeys(request.getTitle());
	}

	public void submit() {
		getDriver().findElement(By.id("save")).click();
	}

}
