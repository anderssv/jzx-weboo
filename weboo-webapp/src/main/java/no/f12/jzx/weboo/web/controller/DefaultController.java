package no.f12.jzx.weboo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static no.f12.jzx.weboo.web.controller.NavigationRegistry.*;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

	@RequestMapping(method = RequestMethod.GET)
	public String startApplication() {
		return redirectTo(URL_INFORMATION_REQUEST);
	}
}
