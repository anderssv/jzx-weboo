package no.f12.jzx.weboo.domain;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class InformationRequest {

	private Long id;
	private String title;
	private Boolean received = false;

	@Valid
	private Organization organization;
	private DateTime regitrationDate;

	public InformationRequest() {
		this.regitrationDate = new DateTime();
	}
	
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

	public int getDaysSinceRegistration() {
		Days d = Days.daysBetween(this.getRegistratioinDate(), new DateTime());
		return d.getDays();
	}

	private DateTime getRegistratioinDate() {
		return this.regitrationDate;
	}

	public void setRegistrationDate(DateTime registrationDate) {
		this.regitrationDate = registrationDate;
	}

}
