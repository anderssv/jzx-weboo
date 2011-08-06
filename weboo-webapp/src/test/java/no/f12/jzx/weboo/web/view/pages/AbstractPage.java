package no.f12.jzx.weboo.web.view.pages;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		Assert.assertEquals("Title does not match at url: " + driver.getCurrentUrl(), getTitle(), getDriver()
				.getTitle());
	}

	public void assertErrors() {
		assertNotNull(getErrors());
	}

	public WebElement getErrors() {
		return getDriver().findElement(By.id("errors"));
	}

	public String getApplicationUrl() {
		return this.applicationUrl;
	}

	public void assertText(String textToVerify) {
		assertTrue("Could not find text: " + textToVerify + "\n" + getDriver().getPageSource(), getDriver()
				.getPageSource().contains(textToVerify));
	}

	protected abstract String getTitle();
}