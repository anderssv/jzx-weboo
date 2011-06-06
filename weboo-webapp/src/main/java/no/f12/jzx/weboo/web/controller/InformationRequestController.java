package no.f12.jzx.weboo.web.controller;

import static no.f12.jzx.weboo.web.controller.NavigationRegistry.*;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.VIEW_INFORMATION_REQUEST_FORM;

import no.f12.jzx.weboo.domain.InformationRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/" + URL_INFORMATION_REQUEST)
public class InformationRequestController {

	@RequestMapping(method = RequestMethod.GET)
	public String showNewRegistrationForm(@ModelAttribute InformationRequest informationRequest) {
		return VIEW_INFORMATION_REQUEST_FORM;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerRequestInformation(@ModelAttribute InformationRequest informationRequest) {
		return redirectTo(URL_ORGANIZATION);
	}

	@RequestMapping(method = RequestMethod.GET, value = URL_INFORMATION_REQUEST_CONFIRMATION)
	public String showConfirmationMessageForRequest() {
		return VIEW_INFORMATION_REQUEST_CONFIRMATION;
	}

}
