package no.f12.jzx.weboo.domain;

import javax.validation.Valid;

public class InformationRequest {

	private Long id;
	private String title;
	private Boolean received = false;

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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void received(){
		received = true;
	}

	public Boolean getReceived() {
		return received;
	}

}
