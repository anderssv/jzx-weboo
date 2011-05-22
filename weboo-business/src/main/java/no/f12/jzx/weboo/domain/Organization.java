package no.f12.jzx.weboo.domain;

import javax.validation.constraints.NotNull;

import no.f12.jzx.weboo.domain.validation.ValidOrganizationNumber;

import org.hibernate.validator.constraints.NotEmpty;

public class Organization {

	@NotEmpty
	private String name;
	@NotNull
	@ValidOrganizationNumber
	private OrganizationNumber organizationNumber;
	private Long id;

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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

}
