package no.f12.jzx.weboo.web.view.pages;

import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.domain.OrganizationNumber;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static no.f12.jzx.weboo.web.controller.NavigationRegistry.*;

public class OrganizationRegistrationPage extends AbstractPage {

	@FindBy(how = How.ID, using="organization.name")
	private WebElement name;
	@FindBy(how = How.ID, using="organization.organizationNumber")
	private WebElement organizationNumber;
	private WebElement save;
	private WebElement lookup;

	public OrganizationRegistrationPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	public void fillIn(Organization org) {
		name.sendKeys(org.getName());
	}

	public void submit() {
		save.click();
	}

	public String getTitle() {
		return "Register Organization";
	}

	public void goTo() {
		getDriver().get(getApplicationUrl() + url(URL_INFORMATION_REQUEST, URL_ORGANIZATION));
		assertAt();
	}

	public void fillIn(OrganizationNumber organizationNumber) {
		this.organizationNumber.sendKeys(organizationNumber.getValue());
	}

	public void lookup() {
		lookup.click();
		
	}

	public void assertOrganisationName(String name) {
		Assert.assertEquals(name, this.name.getValue());
		
	}

	public boolean hitOnLookup() {
		return !name.getValue().isEmpty();
	}

}
