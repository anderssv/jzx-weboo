package no.f12.jzx.weboo.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class Organization {

	@NotEmpty
	private String name;
	private OrganizationNumber organizationNumber;

	protected Organization(){
		
	}
	
	public Organization(OrganizationNumber organizationNumber, String organizationName) {
		this.organizationNumber = organizationNumber;
		this.name = organizationName;
	}

	public String getName() {
		return this.name;
	}

	public OrganizationNumber getOrganizationNumber() {
		return this.organizationNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setOrganizationNumber(OrganizationNumber number) {
		this.organizationNumber = number;
	}

}
