package no.f12.jzx.weboo.web.view.pages;

import static org.junit.Assert.assertNotNull;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

	private String applicationUrl;
	private WebDriver driver;

	public AbstractPage(WebDriver driver, String applicationUrl) {
		this.driver = driver;
		this.applicationUrl = applicationUrl;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void assertAt() {
		Assert.assertEquals(getTitle(), getDriver().getTitle());
	}

	public void assertErrors() {
		assertNotNull(getDriver().findElement(By.id("errors")));
	}

	public String getApplicationUrl() {
		return this.applicationUrl;
	}

	protected abstract String getTitle();
}