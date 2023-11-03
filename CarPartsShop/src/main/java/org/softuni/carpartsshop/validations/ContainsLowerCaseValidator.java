package org.softuni.carpartsshop.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContainsLowerCaseValidator implements ConstraintValidator<ContainsLowerCase, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return passwordContainsLowerCase(value);
    }

    private boolean passwordContainsLowerCase(String password) {
        int countLower = 0;
        char[] charArray = password.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLowerCase(charArray[i])) {
                countLower++;
            }
        }

        return countLower >= 1;
    }

}
