package no.f12.jzx.weboo.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import no.f12.jzx.weboo.domain.validation.NotBlank;
import no.f12.jzx.weboo.domain.validation.WeightedCrcNumberValidator;

public class OrganizationNumber implements ValueObject {

	@NotBlank
	@Digits(integer=9, fraction=0)
	@Min(value=100000000)
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganizationNumber other = (OrganizationNumber) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
