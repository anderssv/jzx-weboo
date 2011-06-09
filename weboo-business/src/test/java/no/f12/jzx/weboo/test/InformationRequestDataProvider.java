package no.f12.jzx.weboo.test;

import no.f12.jzx.weboo.domain.InformationRequestBuilder;

public class InformationRequestDataProvider {

	public static InformationRequestBuilder defaultInformationRequest() {
		return InformationRequestBuilder.with().title("My request")
				.organization(OrganizationDataProvider.createDefaultOrganization());
	}

}
