package no.f12.jzx.weboo.test;

import no.f12.jzx.weboo.domain.InformationRequest;

public class InformationRequestDataProvider {

	public static InformationRequest defaultInformationRequest() {
		InformationRequest request = new InformationRequest();
		request.setTitle("My request");
		request.setOrganization(OrganizationDataProvider.createDefaultOrganization().build());
		return request;
	}

	
}
