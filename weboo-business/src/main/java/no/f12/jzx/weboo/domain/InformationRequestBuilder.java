package no.f12.jzx.weboo.domain;

public class InformationRequestBuilder implements Builder<InformationRequest> {

	private InformationRequest ir;

	private OrganizationBuilder orgBuilder;

	private InformationRequestBuilder() {
		this.ir = new InformationRequest();
	}

	@Override
	public InformationRequest build() {
		Organization org = this.orgBuilder.build();
		this.ir.setOrganization(org);
		return this.ir;
	}

	public static InformationRequestBuilder with() {
		return new InformationRequestBuilder();
	}

	public InformationRequestBuilder title(String title) {
		this.ir.setTitle(title);
		return this;
	}

	public InformationRequestBuilder organization(OrganizationBuilder createDefaultOrganization) {
		this.orgBuilder = createDefaultOrganization;
		return this;
	}

}
