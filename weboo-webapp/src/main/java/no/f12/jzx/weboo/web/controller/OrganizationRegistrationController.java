package no.f12.jzx.weboo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/organization")
public class OrganizationRegistrationController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String showNewInput() {
		return "editOrganization";
	}

}
