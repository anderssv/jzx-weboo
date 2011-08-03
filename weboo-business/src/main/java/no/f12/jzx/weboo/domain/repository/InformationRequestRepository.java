package no.f12.jzx.weboo.domain.repository;

import java.util.List;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.Organization;
import no.f12.jzx.weboo.domain.OrganizationNumber;

import com.google.common.collect.Ordering;

public interface InformationRequestRepository {
	
	public static final Ordering<InformationRequest> DAYS_SINCE_REGISTRATION_ORDERING = new Ordering<InformationRequest>() {
			@Override
			public int compare(InformationRequest left, InformationRequest right) {
				return right.getDaysSinceRegistration() - left.getDaysSinceRegistration();
			}
		};

	public void addOrganization(Organization organization);

	public Organization getOrganization(Long id);

	public InformationRequest getInformationRequest(Long id);

	public void addInformationRequest(InformationRequest informationRequest);

	public List<InformationRequest> getRequests();

	public Organization findOrganization(OrganizationNumber organizationNumber);

	public List<InformationRequest> getSlowestRequests(int numberOfRequests);

}
