package org.softuni.carpartsshop.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidLengthValidator implements ConstraintValidator<ValidLength, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() >= 8 && value.length() <= 20;
    }

}
