package no.f12.jzx.weboo.web.view.pages;

import no.f12.jzx.weboo.domain.InformationRequest;

import static junit.framework.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationRequestSummaryPage extends AbstractPage {

	
	private WebElement requestTitle;
	private WebElement requestId;
	
	
	public InformationRequestSummaryPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	public String getTitle() {
		return "Summary of request";
	}

	public void assertRequestRegistered(InformationRequest request) {
		assertEquals(request.getTitle(), requestTitle.getText());
	}

	public Long getRegisteredRequestIdentifier() {
		return Long.valueOf(requestId.getText());
	}

}
