package no.f12.jzx.weboo.web.view;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.test.InformationRequestDataProvider;
import no.f12.jzx.weboo.web.view.pages.ListRequestsPage;

import org.junit.Test;

public class ReportResponseWebTest extends AbstractWebTest{
	
	@Test
	public void shouldBeAbleToClickSummaryItems() throws Exception {
		InformationRequest informationRequest = InformationRequestDataProvider.defaultInformationRequest().build();
		Long requestId = registerRequest(informationRequest);
		informationRequest.setId(requestId);
		ListRequestsPage listRequestsPage = listRequestsPage();
		listRequestsPage.goTo();
		listRequestsPage.assertAt(); 
		listRequestsPage.assertShows(informationRequest);
		listRequestsPage.clickReceived(informationRequest);
		listRequestsPage.assertAt();
		listRequestsPage.assertShows(informationRequest);
		listRequestsPage.assertReceived(informationRequest);
	}


}
