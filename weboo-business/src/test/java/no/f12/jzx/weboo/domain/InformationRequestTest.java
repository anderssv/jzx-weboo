package no.f12.jzx.weboo.domain;

import org.junit.Test;

import no.f12.jzx.weboo.test.InformationRequestDataProvider;

import static junit.framework.Assert.*;

public class InformationRequestTest {

	@Test
	public void shouldEnableCalcuationOfTimeSinceRegistered() {
		InformationRequestBuilder informationRequestBuilder = InformationRequestDataProvider.defaultInformationRequest();
		informationRequestBuilder.daysSinceRegistration(1);
		InformationRequest request = informationRequestBuilder.build();
		
		assertEquals(1, request.getDaysSinceRegistration());
	}
	
}
