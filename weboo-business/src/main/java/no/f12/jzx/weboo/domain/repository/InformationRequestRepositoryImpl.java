package no.f12.jzx.weboo.domain.repository;

import java.util.HashMap;
import java.util.Map;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.Organization;

import org.springframework.stereotype.Repository;

@Repository
public class InformationRequestRepositoryImpl implements InformationRequestRepository {

	private Map<Long, Organization> organizations = new HashMap<Long, Organization>();
	private Long latestOrganizationId = 0L;
	
	private Map<Long, InformationRequest> requests = new HashMap<Long, InformationRequest>();
	private Long latestRequestId = 0L;

	@Override
	public void addOrganization(Organization organization) {
		organization.setId(latestOrganizationId++);
		organizations.put(organization.getId(), organization);
	}

	@Override
	public Organization getOrganization(Long id) {
		return this.organizations.get(id);
	}

	@Override
	public InformationRequest getInformationRequest(Long id) {
		return requests.get(id);
	}

	@Override
	public void addInformationRequest(InformationRequest informationRequest) {
		informationRequest.setId(latestRequestId++);
		requests.put(informationRequest.getId(), informationRequest);
	}

}
