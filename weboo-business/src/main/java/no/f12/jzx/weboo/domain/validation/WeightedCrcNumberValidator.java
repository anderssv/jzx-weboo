package no.f12.jzx.weboo.domain.validation;

import no.f12.jzx.weboo.domain.OrganizationNumber;
import no.f12.jzx.weboo.domain.ValueObject;

public class WeightedCrcNumberValidator {

	private static int[] organizationNumberWeights = { 3, 2, 7, 6, 5, 4, 3, 2 };
	private static int organizationNumberModulo = 11;

	public static boolean isValid(OrganizationNumber organizationNumber) {
		return isValid(organizationNumber, organizationNumberWeights, organizationNumberModulo);
	}

	private static boolean isValid(ValueObject value, int[] weights, int modulo) {
		return isValidChecksum(value.getValue(), weights, modulo);
	}

	private static boolean isValidChecksum(String number, int[] weights, int modulo) {
		if (number.length() < weights.length + 1) {
			return false;
		}
		
		int[] numberParts = convertToInts(number);
		int result = calculateCheckSum(numberParts, weights, modulo);

		return result == numberParts[numberParts.length - 1];
	}

	private static int calculateCheckSum(int[] numberParts, int[] weights, int modulo) {
		int result = calculateProduct(numberParts, weights);
		result = result % modulo;
		result = modulo - result;

		return result;
	}

	private static int calculateProduct(int[] numberParts, int[] weights) {
		int result = 0;
		for (int i = 0; i < weights.length; i++) {
			result += weights[i] * numberParts[i];
		}

		return result;
	}

	private static int[] convertToInts(String number) {
		int[] parts = new int[number.length()];
		for (int i = 0; i < number.length(); i++) {
			parts[i] = Character.digit(number.charAt(i), 10);
		}

		return parts;
	}

}
