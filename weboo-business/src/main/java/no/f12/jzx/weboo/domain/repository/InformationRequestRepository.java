package no.f12.jzx.weboo.domain.repository;

import java.util.List;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.domain.OrganizationNumber;

public interface InformationRequestRepository {
	
	public void addOrganization(Organization organization);

	public Organization getOrganization(Long id);

	public InformationRequest getInformationRequest(Long id);

	public void addInformationRequest(InformationRequest informationRequest);

	public List<InformationRequest> getRequests();

	public Organization findOrganization(OrganizationNumber organizationNumber);

	public List<InformationRequest> getSlowestRequests(int numberOfRequests);

}
