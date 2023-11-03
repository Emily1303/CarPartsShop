package org.softuni.carpartsshop.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ContainsSpecialSymbolValidator implements ConstraintValidator<ContainsSpecialSymbol, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return passwordContainsSpecialSymbol(value);
    }

    private boolean passwordContainsSpecialSymbol(String password) {
        int countSpecialSymbols = 0;
        char[] charArray = password.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 33 || charArray[i] == 35 || charArray[i] == 36 || charArray[i] == 37 ||
                    charArray[i] == 38 || charArray[i] == 40 || charArray[i] == 41 || charArray[i] == 42 ||
            charArray[i] == 43 || charArray[i] == 45 || charArray[i] == 61 || charArray[i] == 64 || charArray[i] == 94) {
                countSpecialSymbols++;
            }
        }

        return countSpecialSymbols >= 1;
    }

}
