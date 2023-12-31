package org.softuni.carpartsshop.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ContainsSpecialSymbolValidator.class)
public @interface ContainsSpecialSymbol {

    String message() default "The password must contain at least one of these symbols - !@#$%&*()-+=^!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
