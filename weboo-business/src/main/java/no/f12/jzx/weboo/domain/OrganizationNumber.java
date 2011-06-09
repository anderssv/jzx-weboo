package no.f12.jzx.weboo.domain;

import no.f12.jzx.weboo.domain.validation.WeightedCrcNumberValidator;

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

	@Override
	public String toString() {
		return this.value;
	}

}
