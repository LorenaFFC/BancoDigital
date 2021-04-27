package com.project.DigitalBank.validationCustom.CEP;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CepValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CepConstraint {
    String message() default "FORMATO CEP INVÁLIDO";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}



