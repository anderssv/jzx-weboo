package no.f12.jzx.weboo.web.view;

import java.io.File;

import no.f12.jzx.weboo.jetty.WebServer;
import no.f12.jzx.weboo.web.view.pages.InformationRequestPage;
import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;
import no.f12.jzx.weboo.web.view.pages.OverviewPage;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractWebTest {

	protected static final String APPCONTEXT = "myapp";
	private static final String WEBAPP_PATH = "src/main/webapp";

	private static volatile WebServer server;

	private WebDriver driver;

	@BeforeClass
	public static void createServer() throws Exception {
		// Needs to be set so we have defaults for the tests
		System.setProperty("customProperties", "classpath:spring/test/system.properties");

		// Start server
		if (server == null) {
			WebServer setupServer = new WebServer();
			setupServer.start(new File(WEBAPP_PATH), APPCONTEXT);
			server = setupServer;
		}
	}

	@Before
	public void initializeDriver() {
		this.driver = new HtmlUnitDriver();
	}

	@After
	public void closeDriver() {
		this.driver.close();
	}

	protected String getApplicationUrl() {
		return "http://localhost:" + server.getPort() + "/" + APPCONTEXT + "/";
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected OrganizationRegistrationPage organizationPage() {
		OrganizationRegistrationPage organizationRegistrationPage = new OrganizationRegistrationPage(getDriver(),
				getApplicationUrl());
		initializePage(organizationRegistrationPage);

		return organizationRegistrationPage;
	}

	private void initializePage(Object page) {
		PageFactory.initElements(getDriver(), page);
	}

	protected OverviewPage overviewPage() {
		OverviewPage overviewPage = new OverviewPage(getDriver(), getApplicationUrl());
		initializePage(overviewPage);

		return overviewPage;
	}

	protected InformationRequestPage informationRequestPage() {
		InformationRequestPage informationRequestPage = new InformationRequestPage(getDriver(), getApplicationUrl());
		initializePage(informationRequestPage);
		
		return informationRequestPage;
	}
}
