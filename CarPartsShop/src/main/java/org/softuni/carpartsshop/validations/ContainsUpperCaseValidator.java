package org.softuni.carpartsshop.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContainsUpperCaseValidator implements ConstraintValidator<ContainsUpperCase, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return passwordContainsUpperCase(value);
    }

    private boolean passwordContainsUpperCase(String password) {
        int countUpper = 0;
        char[] charArray = password.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char currentSymbol = charArray[i];
            if (Character.isUpperCase(currentSymbol)) {
                countUpper++;
            }
        }

        return countUpper >= 1;
    }

}
