package no.f12.jzx.weboo.web.controller;

import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_CONFIRMATION;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_INFORMATION_REQUEST;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_NEW;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_ORGANIZATION;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_RECEIVED;
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
import no.f12.jzx.weboo.form.OrganizationForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/" + URL_INFORMATION_REQUEST)
@SessionAttributes(types = InformationRequest.class)
public class InformationRequestController {

	@Autowired
	private InformationRequestRepository orgRepo;

	public InformationRequest newInformationRequest() {
		return new InformationRequest();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listRequests(Model model) {
		List<InformationRequest> requests = this.orgRepo.getRequests();
		model.addAttribute("requests", requests);

		return VIEW_INFORMATION_REQUEST_LIST;
	}

	@RequestMapping(method = RequestMethod.GET, value = "slowest")
	public String listSlowestRequests(Model model) {
		model.addAttribute("requests", this.orgRepo.getSlowestRequests(10));

		return VIEW_INFORMATION_REQUEST_LIST;
	}

	@RequestMapping(method = RequestMethod.GET, value = URL_NEW)
	public String showNewRegistrationForm(Model model) {
		InformationRequest newInformationRequest = newInformationRequest();
		model.addAttribute("informationRequest", newInformationRequest);

		return VIEW_INFORMATION_REQUEST_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerRequestInformation(@Valid @ModelAttribute InformationRequest informationRequest, Errors errors) {
		if (errors.hasErrors()) {
			return VIEW_INFORMATION_REQUEST_FORM;
		}

		this.orgRepo.addInformationRequest(informationRequest);
		return redirectTo(url(URL_INFORMATION_REQUEST, URL_ORGANIZATION));
	}

	@RequestMapping(method = RequestMethod.GET, value = "{requestId}/" + URL_CONFIRMATION)
	public String showConfirmationMessageForRequest(@PathVariable Long requestId, Model model) {
		model.addAttribute(this.orgRepo.getInformationRequest(requestId));
		return VIEW_INFORMATION_REQUEST_SUMMARY;
	}

	@RequestMapping(value = URL_ORGANIZATION, method = RequestMethod.GET)
	public String showOrganizationInput(@ModelAttribute OrganizationForm organizationForm,
			@ModelAttribute InformationRequest informationRequest) {
		return VIEW_ORGANIZATION_FORM;
	}

	@RequestMapping(value = URL_ORGANIZATION, method = RequestMethod.POST, params = "lookup")
	public String lookupOrganisationName(@Valid @ModelAttribute OrganizationForm organizationForm, Errors errors,
			@ModelAttribute InformationRequest informationRequest) {
		if (errors.hasErrors()) {
			return VIEW_ORGANIZATION_FORM;
		}
		Organization org = this.orgRepo.findOrganization(organizationForm.getOrganizationNumberSearch());
		if (org != null) {
			informationRequest.setOrganization(org);
			organizationForm.setOrganization(org);
		} else {
			organizationForm.registerNewOrganization();
		}

		return VIEW_ORGANIZATION_FORM;
	}

	@RequestMapping(value = URL_ORGANIZATION, method = RequestMethod.POST, params = "save")
	public String registerNewOrganization(@ModelAttribute OrganizationForm organizationForm, Errors errors,
			@ModelAttribute InformationRequest informationRequest, SessionStatus status) {
		if (errors.hasErrors()) {
			return VIEW_ORGANIZATION_FORM;
		}

		this.orgRepo.addOrganization(informationRequest.getOrganization());

		status.setComplete();
		return redirectTo(url(URL_INFORMATION_REQUEST, Long.toString(informationRequest.getId()), URL_CONFIRMATION));
	}

	@RequestMapping(method = RequestMethod.GET, value = "{requestId}/" + URL_RECEIVED)
	public String registerRequestAsReceived(@PathVariable Long requestId) {
		InformationRequest informationRequest = this.orgRepo.getInformationRequest(requestId);
		informationRequest.close();
		return redirectTo(url(URL_INFORMATION_REQUEST));
	}

	public void setOrganizationRepository(InformationRequestRepository orgRepo) {
		this.orgRepo = orgRepo;
	}

}
