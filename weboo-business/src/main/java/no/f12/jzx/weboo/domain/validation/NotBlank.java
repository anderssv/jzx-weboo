package no.f12.jzx.weboo.domain.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotNull
@Size(min = 1)
public @interface NotBlank {
	String message() default "{no.f12.jzx.weboo.invalid.notBlank}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
