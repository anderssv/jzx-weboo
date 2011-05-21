package no.f12.jzx.weboo.domain.repository;

import java.util.HashMap;
import java.util.Map;

import no.f12.jzx.weboo.domain.Organization;

import org.springframework.stereotype.Repository;

@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {

	private Map<Long, Organization> organizations = new HashMap<Long, Organization>();
	private Long latestId = 0L;

	@Override
	public void addOrganization(Organization organization) {
		organization.setId(latestId++);
		organizations.put(organization.getId(), organization);
	}

	@Override
	public Organization getOrganization(Long id) {
		return this.organizations.get(id);
	}

}
