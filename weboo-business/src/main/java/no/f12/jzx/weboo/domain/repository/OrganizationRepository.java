package no.f12.jzx.weboo.domain.repository;

import no.f12.jzx.weboo.domain.Organization;

public interface OrganizationRepository {
	
	public void addOrganization(Organization organization);

	public Organization getOrganization(Long id);

}
