package no.f12.jzx.weboo.web.view;

import java.io.File;

import no.f12.jzx.weboo.jetty.WebServer;
import no.f12.jzx.weboo.web.view.pages.AbstractPage;
import no.f12.jzx.weboo.web.view.pages.InformationRequestPage;
import no.f12.jzx.weboo.web.view.pages.ListRequestsPage;
import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;
import no.f12.jzx.weboo.web.view.pages.InformationRequestSummaryPage;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractWebTest {

	protected static final String APPCONTEXT = "myapp";
	private static final String WEBAPP_PATH = "src/main/webapp";
	
	private static Logger LOGGER;
	
	private static volatile WebServer server;

	private WebDriver driver;

	public AbstractWebTest(){
		LOGGER = Logger.getLogger(getClass());
	}
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
		String applicationUrl = "http://localhost:" + server.getPort() + "/" + APPCONTEXT + "/";
		LOGGER.log(Level.INFO, "ApplicationUrl: " + applicationUrl);
		return applicationUrl;

	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected OrganizationRegistrationPage organizationPage() {
		OrganizationRegistrationPage organizationRegistrationPage = new OrganizationRegistrationPage(getDriver(),
				getApplicationUrl());
		return initializePage(organizationRegistrationPage);
	}

	protected InformationRequestSummaryPage overviewPage() {
		InformationRequestSummaryPage overviewPage = new InformationRequestSummaryPage(getDriver(), getApplicationUrl());
		return initializePage(overviewPage);
	}

	protected InformationRequestPage informationRequestPage() {
		InformationRequestPage informationRequestPage = new InformationRequestPage(getDriver(), getApplicationUrl());
		return initializePage(informationRequestPage);
	}

	protected ListRequestsPage listRequestsPage() {
		ListRequestsPage listRequestsPage = new ListRequestsPage(getDriver(), getApplicationUrl());
		return initializePage(listRequestsPage);
	}

	private <T extends AbstractPage> T initializePage(T page) {
		PageFactory.initElements(getDriver(), page);

		return page;
	}
}
