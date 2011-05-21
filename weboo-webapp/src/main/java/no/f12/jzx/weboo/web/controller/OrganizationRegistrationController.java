package no.f12.jzx.weboo.web.controller;

import javax.validation.Valid;

import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.domain.repository.OrganizationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/" + NavigationRegistry.URL_ORGANIZATION)
public class OrganizationRegistrationController {

	@Autowired
	OrganizationRepository orgRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String showNewInput(@ModelAttribute Organization organization) {
		return NavigationRegistry.VIEW_ORGANIZATION_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewOrganization(@Valid @ModelAttribute Organization organization, Errors errors) {
		if (errors.hasErrors()) {
			return NavigationRegistry.VIEW_ORGANIZATION_FORM;
		}

		this.orgRepo.addOrganization(organization);

		return NavigationRegistry.VIEW_ORGANIZATION_SUMMARY;
	}

	public void setOrganizationRepository(OrganizationRepository orgRepo) {
		this.orgRepo = orgRepo;
	}
}
