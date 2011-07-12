package no.f12.jzx.weboo.web.controller;

import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_CONFIRMATION;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_INFORMATION_REQUEST;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_NEW;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_ORGANIZATION;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.VIEW_INFORMATION_REQUEST_FORM;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.VIEW_INFORMATION_REQUEST_LIST;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.VIEW_INFORMATION_REQUEST_SUMMARY;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.VIEW_ORGANIZATION_FORM;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.redirectTo;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.url;

import java.util.List;

import javax.validation.Valid;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.domain.repository.InformationRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/" + URL_INFORMATION_REQUEST)
@SessionAttributes(types = InformationRequest.class)
public class InformationRequestController {

	@Autowired
	InformationRequestRepository orgRepo;

	@ModelAttribute
	public InformationRequest newInformationRequest() {
		return new InformationRequest();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listRequests(Model model) {
		List<InformationRequest> requests = this.orgRepo.getRequests();
		model.addAttribute("requests", requests);

		return VIEW_INFORMATION_REQUEST_LIST;
	}

	@RequestMapping(method = RequestMethod.GET, value = URL_NEW)
	public String showNewRegistrationForm(@ModelAttribute InformationRequest informationRequest) {
		return VIEW_INFORMATION_REQUEST_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerRequestInformation(@ModelAttribute InformationRequest informationRequest, Errors errors) {
		if (errors.hasErrors()) {
			return VIEW_INFORMATION_REQUEST_FORM;
		}

		this.orgRepo.addInformationRequest(informationRequest);
		return redirectTo(url(URL_INFORMATION_REQUEST, URL_ORGANIZATION));
	}

	@RequestMapping(method = RequestMethod.GET, value = URL_CONFIRMATION)
	public String showConfirmationMessageForRequest(@ModelAttribute InformationRequest informationRequest,
			SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return VIEW_INFORMATION_REQUEST_SUMMARY;
	}

	@RequestMapping(value = URL_ORGANIZATION, method = RequestMethod.GET)
	public String showOrganizationInput(@ModelAttribute InformationRequest informationRequest) {
		return VIEW_ORGANIZATION_FORM;
	}

	@RequestMapping(value = URL_ORGANIZATION, method = RequestMethod.POST, params = "save")
	public String registerNewOrganization(@Valid @ModelAttribute InformationRequest informationRequest, Errors errors) {
		if (errors.hasErrors()) {
			return VIEW_ORGANIZATION_FORM;
		}

		this.orgRepo.addOrganization(informationRequest.getOrganization());

		return redirectTo(url(URL_INFORMATION_REQUEST, URL_CONFIRMATION));
	}

	@RequestMapping(value = URL_ORGANIZATION, method = RequestMethod.POST, params="lookup")
	public String lookupOrganisationName(@ModelAttribute InformationRequest informationRequest, Errors errors) {
		if (errors.hasErrors()) {
			return VIEW_ORGANIZATION_FORM;
		}
		Organization org = this.orgRepo.findOrganization(informationRequest.getOrganization().getOrganizationNumber());
		informationRequest.setOrganization(org);
		return VIEW_ORGANIZATION_FORM;
	}

	public void setOrganizationRepository(InformationRequestRepository orgRepo) {
		this.orgRepo = orgRepo;
	}

}
