package no.f12.jzx.weboo.web.controller;

import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_INFORMATION_REQUEST;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_INFORMATION_REQUEST_CONFIRMATION;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_ORGANIZATION;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.VIEW_INFORMATION_REQUEST_FORM;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.VIEW_INFORMATION_REQUEST_SUMMARY;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.VIEW_ORGANIZATION_FORM;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.redirectTo;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.url;

import javax.validation.Valid;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.repository.OrganizationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/" + URL_INFORMATION_REQUEST)
public class InformationRequestController {

	@Autowired
	OrganizationRepository orgRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String showNewRegistrationForm(@ModelAttribute InformationRequest informationRequest) {
		return VIEW_INFORMATION_REQUEST_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerRequestInformation(@ModelAttribute InformationRequest informationRequest) {
		return redirectTo(url(URL_INFORMATION_REQUEST, URL_ORGANIZATION));
	}

	@RequestMapping(method = RequestMethod.GET, value = URL_INFORMATION_REQUEST_CONFIRMATION)
	public String showConfirmationMessageForRequest(@ModelAttribute InformationRequest informationRequest) {
		return VIEW_INFORMATION_REQUEST_SUMMARY;
	}

	@RequestMapping(value = URL_ORGANIZATION, method = RequestMethod.GET)
	public String showOrganizationInput(@ModelAttribute InformationRequest informationRequest) {
		return VIEW_ORGANIZATION_FORM;
	}

	@RequestMapping(value = URL_ORGANIZATION, method = RequestMethod.POST)
	public String registerNewOrganization(@Valid @ModelAttribute InformationRequest informationRequest, Errors errors) {
		if (errors.hasErrors()) {
			return VIEW_ORGANIZATION_FORM;
		}

		this.orgRepo.addOrganization(informationRequest.getOrganization());

		return redirectTo(url(URL_INFORMATION_REQUEST, URL_INFORMATION_REQUEST_CONFIRMATION));
	}

	public void setOrganizationRepository(OrganizationRepository orgRepo) {
		this.orgRepo = orgRepo;
	}

}
