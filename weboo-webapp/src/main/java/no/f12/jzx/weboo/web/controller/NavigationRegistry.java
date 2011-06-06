package no.f12.jzx.weboo.web.controller;

public class NavigationRegistry {

	public static final String URL_INFORMATION_REQUEST = "informationRequest";
	public static final String URL_INFORMATION_REQUEST_CONFIRMATION = "confirmation";

	public static final String URL_ORGANIZATION = "organization";

	public static final String VIEW_ORGANIZATION = URL_ORGANIZATION;
	public static final String VIEW_ORGANIZATION_FORM = VIEW_ORGANIZATION + "/organizationForm";

	public static final String VIEW_INFORMATION_REQUEST = URL_INFORMATION_REQUEST;
	public static final String VIEW_INFORMATION_REQUEST_SUMMARY = VIEW_INFORMATION_REQUEST + "/summary";
	public static final String VIEW_INFORMATION_REQUEST_FORM = VIEW_INFORMATION_REQUEST + "/informationRequestForm";

	public static final String redirectTo(String url) {
		return "redirect:" + url;
	}

	public static final String url(String... parts) {
		String result = "";
		for (String string : parts) {
			result += "/" + string;
		}
		return result;
	}

}
