package org.softuni.carpartsshop.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = MatchPasswordsValidator.class)
public @interface MatchPasswords {

    String password();

    String confirmPassword();

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
