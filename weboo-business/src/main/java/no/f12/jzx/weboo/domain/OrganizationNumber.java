package no.f12.jzx.weboo.domain;

public class OrganizationNumber implements ValueObject {

	private String value;

	public OrganizationNumber(String orgNum) {
		this.value = orgNum;
	}

	public String getValue() {
		return this.value;
	}

	public boolean isValid() {
		return WeightedCrcNumberValidator.isValid(this);
	}

}
