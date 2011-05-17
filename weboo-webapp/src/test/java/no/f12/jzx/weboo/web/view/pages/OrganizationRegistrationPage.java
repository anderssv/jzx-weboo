package no.f12.jzx.weboo.web.view.pages;

import no.f12.jzx.weboo.domain.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

	public String getTitle() {
		return "Register Organization";
	}

	public void goTo() {
		getDriver().get(getApplicationUrl() + "organization");
		assertAt();
	}

}
