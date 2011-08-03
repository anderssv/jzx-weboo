package no.f12.jzx.weboo.web.controller;

import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_CONFIRMATION;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_INFORMATION_REQUEST;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_ORGANIZATION;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.redirectTo;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.repository.InformationRequestRepository;
import no.f12.jzx.weboo.domain.repository.InformationRequestRepositoryImpl;
import no.f12.jzx.weboo.form.OrganizationForm;
import no.f12.jzx.weboo.test.InformationRequestDataProvider;
import no.f12.jzx.weboo.testutil.BeansUtil;

import org.junit.Test;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.support.SimpleSessionStatus;

public class InformationRequestControllerTest {

	@Test
	public void shouldAddOrganizationToRepositoryIfNoErrors() {
		InformationRequestController controller = new InformationRequestController();
		InformationRequestRepository orgRepo = new InformationRequestRepositoryImpl();
		controller.setOrganizationRepository(orgRepo);

		InformationRequest request = InformationRequestDataProvider.defaultInformationRequest().build();
		OrganizationForm organizationForm = new OrganizationForm(request.getOrganization());
		
		Errors errorsObject = new DirectFieldBindingResult(request, BeansUtil.beanName(InformationRequest.class));
		controller.registerRequestInformation(request, errorsObject);
		String resultingView = controller.registerNewOrganization(organizationForm,errorsObject, request, new SimpleSessionStatus());

		assertEquals(redirectTo(url(URL_INFORMATION_REQUEST, Long.toString(request.getId()),  URL_CONFIRMATION)), resultingView);
		assertNotNull(orgRepo.getOrganization(request.getOrganization().getId()));
	}

	@Test
	public void shouldAddRequestToRepositoryIfNoErrors() {
		InformationRequestController controller = new InformationRequestController();
		InformationRequestRepository orgRepo = new InformationRequestRepositoryImpl();
		controller.setOrganizationRepository(orgRepo);

		InformationRequest request = InformationRequestDataProvider.defaultInformationRequest().build();
		String resultingView = controller.registerRequestInformation(request, new DirectFieldBindingResult(request,
				BeansUtil.beanName(InformationRequest.class)));

		assertEquals(redirectTo(url(URL_INFORMATION_REQUEST, URL_ORGANIZATION)), resultingView);
		assertNotNull(orgRepo.getInformationRequest(request.getId()));
	}

}
