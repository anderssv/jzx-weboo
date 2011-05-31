package no.f12.jzx.weboo.web.controller;

import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_INFORMATION_REQUEST;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.VIEW_INFORMATION_REQUEST_FORM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/" + URL_INFORMATION_REQUEST)
public class InformationRequestController {

	@RequestMapping(method = RequestMethod.GET)
	public String showNewRegistrationForm() {
		return VIEW_INFORMATION_REQUEST_FORM;
	}
}
