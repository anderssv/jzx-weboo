package no.f12.jzx.weboo.web.view;

import java.util.List;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.test.InformationRequestDataProvider;
import no.f12.jzx.weboo.web.view.pages.ListRequestsPage;

import org.junit.Test;

import com.google.common.collect.Lists;

public class RequestListingWebTest extends AbstractWebTest {

	@Test
	public void shouldShowIssueSummaryItems() throws Exception {
		ListRequestsPage listRequestsPage = pageListRequests();

		InformationRequest informationRequest = InformationRequestDataProvider.defaultInformationRequest().build();
		Long requestId = registerRequest(informationRequest);
		informationRequest.setId(requestId);

		listRequestsPage.goTo();
		listRequestsPage.assertAt();
		listRequestsPage.assertShows(informationRequest);
		listRequestsPage.clickReceived(informationRequest);

		listRequestsPage.assertAt();
		listRequestsPage.assertReceived(informationRequest);
	}

	@Test
	public void shouldBeAbleToMarkCorrectRequestAsReceivedWhenMultipleRequests() throws Exception {
		List<InformationRequest> requests = createRequests(5);

		ListRequestsPage listRequestsPage = pageListRequests();
		listRequestsPage.goTo();
		listRequestsPage.assertAt();

		for (InformationRequest request : requests) {
			listRequestsPage.assertShows(request);
			listRequestsPage.clickReceived(request);
			listRequestsPage.assertReceived(request);
		}
	}

	@Test
	public void shouldListSlowestTests() {
		createRequests(1);

		ListRequestsPage listRequestsPage = pageListRequests();
		listRequestsPage.goTo();
		listRequestsPage.clickSlowestLink();
		listRequestsPage.assertAt();
		listRequestsPage.assertRequestsShown();
	}

	private List<InformationRequest> createRequests(int totalRequests) {
		List<InformationRequest> requests = Lists.newArrayList();
		for (int i = 0; i < totalRequests; i++) {
			InformationRequest informationRequest = InformationRequestDataProvider.defaultInformationRequest().build();
			Long requestId = registerRequest(informationRequest);
			informationRequest.setId(requestId);
			requests.add(informationRequest);
		}
		return requests;
	}

}
