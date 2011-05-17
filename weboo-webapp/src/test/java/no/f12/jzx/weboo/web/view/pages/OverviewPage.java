package no.f12.jzx.weboo.web.view.pages;

import org.openqa.selenium.WebDriver;

public class OverviewPage extends AbstractPage {

	public OverviewPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	public String getTitle() {
		return "My Overview";
	}

}
