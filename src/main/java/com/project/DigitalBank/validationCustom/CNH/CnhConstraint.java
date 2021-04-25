package com.project.DigitalBank.validationCustom.CNH;

import com.project.DigitalBank.validationCustom.DataNascimento.DTNascValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CnhValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CnhConstraint {
    String message() default "FORMATO CNH INVÁLIDO";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

