package no.f12.jzx.weboo.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.f12.jzx.weboo.domain.InformationRequest;
import no.f12.jzx.weboo.domain.Organization;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

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
		if (!this.requests.containsKey(informationRequest.getId())) {
			informationRequest.setId(latestRequestId++);
			requests.put(informationRequest.getId(), informationRequest);
		}
	}

	@Override
	public List<InformationRequest> getRequests() {
		ArrayList<InformationRequest> sortedRequests = Lists.newArrayList(this.requests.values());
		Collections.sort(sortedRequests, new Comparator<InformationRequest>() {
			@Override
			public int compare(InformationRequest o1, InformationRequest o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
		return sortedRequests;
	}

}
