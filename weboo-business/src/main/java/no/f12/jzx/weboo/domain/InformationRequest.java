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
	private DateTime regitrationTime;

	public InformationRequest() {
		this.regitrationTime = new DateTime();
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

	public void close() {
		received = true;
	}

	public Boolean getReceived() {
		return received;
	}

	public int getDaysSinceRegistration() {
		Days d = Days.daysBetween(this.getRegistrationTime(), new DateTime());
		return d.getDays();
	}

	public void setRegistrationDate(DateTime registrationTime) {
		this.regitrationTime = registrationTime;
	}

	public DateTime getRegistrationTime() {
		return this.regitrationTime;
	}

}
