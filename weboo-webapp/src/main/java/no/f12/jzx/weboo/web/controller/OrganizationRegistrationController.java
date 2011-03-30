package no.f12.jzx.weboo.web.controller;

import no.f12.jzx.weboo.domain.Organization;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/organization")
public class OrganizationRegistrationController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String showNewInput(@ModelAttribute Organization organization) {
		return "organization/organizationForm";
	}

}
