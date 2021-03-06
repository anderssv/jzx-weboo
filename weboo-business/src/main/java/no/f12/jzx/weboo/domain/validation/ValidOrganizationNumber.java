package no.f12.jzx.weboo.domain.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OrganizationNumberValidator.class)
public @interface ValidOrganizationNumber {

	String message() default "{no.f12.jzx.weboo.invalid.organizationNumber}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
