package no.f12.jzx.weboo.web.view.pages;

import no.f12.jzx.weboo.domain.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.*;

public class OrganizationRegistrationPage {

	private String applicationUrl;
	private WebDriver driver;

	public OrganizationRegistrationPage(WebDriver driver, String applicationUrl) {
		this.driver = driver;
		this.applicationUrl = applicationUrl;
	}

	public void goTo() {
		driver.get(applicationUrl + "organization");
		assertEquals(driver.getTitle(), "Register Organization");
	}

	public void fillIn(Organization org) {
		driver.findElement(By.id("organization.name")).sendKeys(org.getName());
		driver.findElement(By.id("organization.organizationNumber")).sendKeys(org.getOrganizationNumber().getValue());
	}

}
