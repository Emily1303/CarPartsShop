package org.softuni.carpartsshop.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ContainsLowerCaseValidator.class)
public @interface ContainsLowerCase {

    String message() default "The password must contain at least one lower case letter!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
