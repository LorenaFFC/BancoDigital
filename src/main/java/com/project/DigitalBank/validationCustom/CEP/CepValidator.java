package com.project.DigitalBank.validationCustom.CEP;

import com.project.DigitalBank.validationCustom.CNH.CnhConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<CepConstraint, String>{
    @Override
    public void initialize(CepConstraint cepConstraint) {
    }

    @Override
    public boolean isValid(String cepField,
                           ConstraintValidatorContext cxt){

        if(cepField.length() <9){
            return false; }
        else if (cepField.length() >9){
            return false;
        }
        else {
            String CEP_Number = cepField.substring(0, 5);
            String CEP_SEPARADOR = cepField.substring(5, 6);
            String CEP_DV = cepField.substring(6, 9);

            return cepField != null
                    && cepField.length() == 9
                    && CEP_Number.matches("[0-9]+")
                    && CEP_Number.length() == 5
                    && CEP_DV.matches("[0-9]+")
                    && CEP_DV.length() == 3
                    && CEP_SEPARADOR=="-";

    }
}
}
