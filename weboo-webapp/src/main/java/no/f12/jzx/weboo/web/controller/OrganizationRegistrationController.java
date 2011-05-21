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
@RequestMapping(value = "/organization")
public class OrganizationRegistrationController {

	@Autowired
	OrganizationRepository orgRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String showNewInput(@ModelAttribute Organization organization) {
		return "organization/organizationForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String showOverView(@Valid @ModelAttribute Organization organization, Errors erros) {
		if (erros.hasErrors()) {
			return "organization/organizationForm";
		}

		this.orgRepo.addOrganization(organization);

		return "organization/overviewForm";
	}

	public void setOrganizationRepository(OrganizationRepository orgRepo) {
		this.orgRepo = orgRepo;
	}
}
