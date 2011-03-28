package no.f12.jzx.weboo.domain;

public class Organization {

	private String name;
	private OrganizationNumber organizationNumber;

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

}
