package no.f12.jzx.weboo.domain;

public class OrganizationBuilder implements Builder<Organization> {

	private Organization org = new Organization();
	
	private OrganizationBuilder() {
		super();
	}

	@Override
	public Organization build() {
		return org;
	}

	public OrganizationBuilder organizationNumber(OrganizationNumber organizationNumber) {
		org.setOrganizationNumber(organizationNumber);
		return this;
	}

	public OrganizationBuilder withName(String name) {
		org.setName(name);
		return this;
	}

	public OrganizationBuilder withNoOrganizationNumber() {
		org.setOrganizationNumber(null);
		return this;
	}
	
	public static OrganizationBuilder with() {
		return new OrganizationBuilder();
	}

	public void withOrganizationNumber(OrganizationNumber organizationNumber) {
		org.setOrganizationNumber(organizationNumber);
		
	}

}
