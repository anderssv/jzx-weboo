package no.f12.jzx.weboo.domain;

public class OrganizationBuilder extends Organization implements Builder<Organization> {

	public OrganizationBuilder() {
		super();
	}

	@Override
	public Organization build() {
		return new Organization(getOrganizationNumber(), getName());
	}

	public OrganizationBuilder withOrganizationNumber(OrganizationNumber organizationNumber) {
		setOrganizationNumber(organizationNumber);
		return this;
	}

	public OrganizationBuilder withName(String name) {
		setName(name);
		return this;
	}

	public OrganizationBuilder withNoOrganizationNumber() {
		setOrganizationNumber(null);
		return this;
	}

}
