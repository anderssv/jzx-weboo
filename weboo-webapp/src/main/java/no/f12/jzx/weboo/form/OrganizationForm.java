package no.f12.jzx.weboo.form;

import javax.validation.Valid;

import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.domain.OrganizationNumber;

public class OrganizationForm {
	
	@Valid
	private OrganizationNumber organizationNumberSearch;
	
	@Valid
	private Organization organization;

	public OrganizationForm(){}
	
	public OrganizationForm(Organization organization){
		this.organization = organization;
		
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganizationNumberSearch(OrganizationNumber organizationNumberSearch) {
		this.organizationNumberSearch = organizationNumberSearch;
	}

	public OrganizationNumber getOrganizationNumberSearch() {
		return organizationNumberSearch;
	}
	
	public Boolean getShouldShowOrganization(){
		return this.organizationNumberSearch != null && this.organizationNumberSearch.isValid();
		
	}

	public void registerNewOrganization() {
		this.organization = new Organization(organizationNumberSearch, "");
		
	}

}
