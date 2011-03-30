package no.f12.jzx.weboo.web.view.pages;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

public class OverviewPage extends AbstractPage {

	public OverviewPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	public void assertAt() {
		Assert.assertEquals("My Overview", getDriver().getTitle());
	}

}
