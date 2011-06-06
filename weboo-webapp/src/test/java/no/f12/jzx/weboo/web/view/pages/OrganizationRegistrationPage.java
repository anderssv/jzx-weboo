package no.f12.jzx.weboo.web.view.pages;

import no.f12.jzx.weboo.domain.Organization;

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

	public OrganizationRegistrationPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	public void fillIn(Organization org) {
		name.sendKeys(org.getName());
		organizationNumber.sendKeys(org.getOrganizationNumber().getValue());
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

}
