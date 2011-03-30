package no.f12.jzx.weboo.web.view.pages;

import static junit.framework.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

	private String applicationUrl;
	private WebDriver driver;

	public AbstractPage(WebDriver driver, String applicationUrl) {
		this.driver = driver;
		this.applicationUrl = applicationUrl;
	}

	public void goTo() {
		driver.get(applicationUrl + "organization");
		assertEquals("Register Organization", driver.getTitle());
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

}