package com.deepak.expensetrackerv1.utils;

import com.deepak.expensetrackerv1.exception.BadRequestException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

public final class ValidationUtils {

    private ValidationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void checkValidationError(final BindingResult validationResult){
        if (validationResult.hasFieldErrors()) {
            final List<Object> error =validationResult.getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());

            throw new BadRequestException(error);
        }
    }

}
