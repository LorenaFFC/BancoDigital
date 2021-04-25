package com.project.DigitalBank.validationCustom.DataNascimento;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DTNascValidator implements ConstraintValidator<DtNascConstraint, LocalDate> {

    @Override
    public void initialize(DtNascConstraint dtNascConstraint) {
    }
    @Override
    public boolean isValid(LocalDate dtNascField,
                           ConstraintValidatorContext cxt) {

        LocalDate today = LocalDate.now();
        long dif = today.getYear() - dtNascField.getYear();

        return dtNascField != null && (dif>=18) ;
    }

    }



