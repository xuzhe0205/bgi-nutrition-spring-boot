package com.health.nutrition.common.aspect.annotation;

import com.auth0.jwt.interfaces.Payload;
import com.health.nutrition.common.filter.IsValidUserInfoValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { IsValidUserInfoValidator.class })
public @interface IsValidUserInfo {

    String message() default "Something wrong with this UserInfo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
