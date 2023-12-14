package com.kata.series.validators;

import java.util.List;

import com.kata.series.annotation.PasswordValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

	List<String> weakPasswords;

	public void initialize(PasswordValidator validator) {
		weakPasswords = List.of("12345", "password", "qwerty");
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && !weakPasswords.contains(value);
	}

}
