package no.f12.jzx.weboo.web.view;

import java.io.File;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.jetty.WebServer;
import no.f12.jzx.weboo.web.view.pages.AbstractPage;
import no.f12.jzx.weboo.web.view.pages.InformationRequestPage;
import no.f12.jzx.weboo.web.view.pages.InformationRequestSummaryPage;
import no.f12.jzx.weboo.web.view.pages.ListRequestsPage;
import no.f12.jzx.weboo.web.view.pages.OrganizationRegistrationPage;

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
		String applicationUrl = "http://localhost:" + server.getPort() + "/" + APPCONTEXT + "/";
		return applicationUrl;
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected OrganizationRegistrationPage pageOrganization() {
		OrganizationRegistrationPage organizationRegistrationPage = new OrganizationRegistrationPage(getDriver(),
				getApplicationUrl());
		return initializePage(organizationRegistrationPage);
	}

	protected InformationRequestSummaryPage pageRequestSummary() {
		InformationRequestSummaryPage informationRequestSummaryPage = new InformationRequestSummaryPage(getDriver(),
				getApplicationUrl());
		return initializePage(informationRequestSummaryPage);
	}

	protected InformationRequestPage pageInformationRequest() {
		InformationRequestPage informationRequestPage = new InformationRequestPage(getDriver(), getApplicationUrl());
		return initializePage(informationRequestPage);
	}

	protected ListRequestsPage pageListRequests() {
		ListRequestsPage listRequestsPage = new ListRequestsPage(getDriver(), getApplicationUrl());
		return initializePage(listRequestsPage);
	}

	private <T extends AbstractPage> T initializePage(T page) {
		PageFactory.initElements(getDriver(), page);

		return page;
	}

	protected InformationRequestSummaryPage registerOrganization(InformationRequest request,
			boolean allowExistingOrganization) {
		OrganizationRegistrationPage orgPage = pageOrganization();

		orgPage.lookupOrganization(request.getOrganization().getOrganizationNumber());
		if (orgPage.hitOnLookup()) {
			orgPage.assertOrganisationName(request.getOrganization().getName());
		} else {
			orgPage.fillIn(request.getOrganization());
		}

		orgPage.submit();

		InformationRequestSummaryPage informationRequestSummaryPage = pageRequestSummary();
		informationRequestSummaryPage.assertAt();
		return informationRequestSummaryPage;
	}

	protected OrganizationRegistrationPage registerRequestInformation(InformationRequest request) {
		InformationRequestPage requestPage = pageInformationRequest();

		requestPage.goTo();
		requestPage.assertAt();

		requestPage.fillIn(request);
		requestPage.submit();

		OrganizationRegistrationPage orgPage = pageOrganization();
		orgPage.assertAt();
		return orgPage;
	}

	protected Long registerRequest(InformationRequest request) {
		registerRequestInformation(request);
		InformationRequestSummaryPage informationRequestSummaryPage = registerOrganization(request, false);

		informationRequestSummaryPage.assertAt();
		Long requestId = informationRequestSummaryPage.getRegisteredRequestIdentifier();
		request.setId(requestId);

		return requestId;
	}
}
