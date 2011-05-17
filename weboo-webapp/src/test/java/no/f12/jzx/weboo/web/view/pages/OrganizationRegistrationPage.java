package no.f12.jzx.weboo.web.view.pages;

import junit.framework.Assert;
import no.f12.jzx.weboo.domain.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class OrganizationRegistrationPage extends AbstractPage {

	public OrganizationRegistrationPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	public void fillIn(Organization org) {
		getDriver().findElement(By.id("name")).sendKeys(org.getName());
		getDriver().findElement(By.id("organizationNumber")).sendKeys(org.getOrganizationNumber().getValue());
	}

	public void submit() {
		getDriver().findElement(By.id("save")).click();
	}

	public void assertErrors() {
		assertNotNull(getDriver().findElement(By.id("errors")));
	}

	public void assertAt() {
		Assert.assertEquals("Register Organization", getDriver().getTitle());
	}

}
