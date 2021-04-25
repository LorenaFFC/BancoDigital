package com.project.DigitalBank.validationCustom.DataNascimento;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Constraint(validatedBy = DTNascValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DtNascConstraint {
    String message() default "Apenas Maiores de 18 anos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
