package com.jensprog.recipeconverter.validation;

import com.jensprog.recipeconverter.model.ConversionRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RequestValidator implements Validator  {
  public boolean supports(@SuppressWarnings("null") Class<?> clazz) {
    return ConversionRequest.class.equals(clazz);
  }

  public void validate(@SuppressWarnings("null") Object object, @SuppressWarnings("null") Errors errors) {
    ConversionRequest request = (ConversionRequest) object;

    if (request.getRecipeName() == null || request.getRecipeName().isBlank()) {
      errors.rejectValue("recipeName", "recipeName.empty", "Recipe Name is required.");
    }

    if (request.getIngredient() == null || request.getIngredient().isBlank()) {
      errors.rejectValue("ingredient", "ingredient.empty", "Ingredient is required.");
    }

    if (request.getAmount() == null || request.getAmount() <= 0) {
      errors.rejectValue("amount", "amount.invalid", "Amount must be a positive number.");
    }

    if (request.getFromUnit() == null || request.getFromUnit().isBlank()) {
      errors.rejectValue("fromUnit", "fromUnit.empty", "From Unit is required.");
    }

    if (request.getToUnit() == null || request.getToUnit().isBlank()) {
      errors.rejectValue("toUnit", "toUnit.empty", "To Unit is required.");
    }
  }
}
