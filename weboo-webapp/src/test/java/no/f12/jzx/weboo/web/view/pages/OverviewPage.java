package no.f12.jzx.weboo.web.view.pages;

import no.f12.jzx.weboo.domain.InformationRequest;

import static junit.framework.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends AbstractPage {

	
	private WebElement requestTitle;
	
	
	public OverviewPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	public String getTitle() {
		return "My Overview";
	}

	public void assertRequestRegistered(InformationRequest request) {
		assertEquals(request.getTitle(), requestTitle.getText());
	}

}
