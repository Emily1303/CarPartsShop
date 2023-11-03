package org.softuni.carpartsshop.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContainsWhitespaceValidator implements ConstraintValidator<ContainsWhitespace, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return passwordContainWhitespace(value);
    }

    private boolean passwordContainWhitespace(String password) {
        char[] charArray = password.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isWhitespace(charArray[i])) {
                return false;
            }
        }

        return true;
    }

}
