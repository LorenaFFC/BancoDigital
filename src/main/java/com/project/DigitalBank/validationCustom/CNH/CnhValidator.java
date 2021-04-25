package com.project.DigitalBank.validationCustom.CNH;

import com.project.DigitalBank.validationCustom.DataNascimento.DtNascConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Locale;


public class CnhValidator implements ConstraintValidator<CnhConstraint, String> {


    @Override
    public void initialize(CnhConstraint cnhConstraint) {
    }

    @Override
    public boolean isValid(String cnhField,
                           ConstraintValidatorContext cxt){

        if(cnhField.length() <=11){
            return false; }
        else if (cnhField.length() >12){
            return false;
        }
        else {
            String CNH_Number = cnhField.substring(0, 9);
            String CNH_SEP = cnhField.substring(9, 10);
            String CNH_DV = cnhField.substring(10, 12);

            return cnhField != null
                    && cnhField.length() == 12
                    && CNH_Number.matches("[0-9]+")
                    && CNH_Number.length() == 9
                    && CNH_DV.matches("[0-9]+")
                    && CNH_DV.length() == 2
                    && CNH_SEP.matches("-");
        }

    }
}
