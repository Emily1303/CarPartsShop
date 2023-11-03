package org.softuni.carpartsshop.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidLengthValidator.class)
public @interface ValidLength {

    String message() default "The password must be between 8 and 20 symbols!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
