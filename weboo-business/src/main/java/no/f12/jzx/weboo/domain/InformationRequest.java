package no.f12.jzx.weboo.domain;

import javax.validation.Valid;

public class InformationRequest {

	
	private String title;
	
	@Valid
	private Organization organization;

	public String getTitle() {
		return this.title;
	}

	public Organization getOrganization() {
		return this.organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

}
