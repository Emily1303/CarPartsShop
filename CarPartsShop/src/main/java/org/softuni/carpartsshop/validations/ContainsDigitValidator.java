package org.softuni.carpartsshop.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContainsDigitValidator implements ConstraintValidator<ContainsDigit, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return passwordContainsDigit(value);
    }

    private boolean passwordContainsDigit(String password) {
        int countDigit = 0;
        char[] charArray = password.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                countDigit++;
            }
        }

        return countDigit >= 1;
    }

}
