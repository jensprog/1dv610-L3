package com.jensprog.recipeconverter.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Model that holds the users input data, used to perform a conversion by RecipeConversionService.
 */
public class ConversionRequest {
  @NotBlank(message = "Recipe name is required")
  @Size(max = 20, message = "Recipe name cannot be longer than 20 characters")
  private String recipeName;

  @NotBlank(message = "Ingredient is required")
  @Size(max = 20, message = "Ingredient cannot be longer than 20 characters")
  private String ingredient;

  @NotNull(message = "Amount is required")
  @DecimalMin(value = "0.1", message = "Amount must be greater than 0")
  @DecimalMax(value = "1000", message = "Amount must be less than 1,000")
  private double amount;

  @NotBlank(message = "From unit is required")
  private String fromUnit;

  @NotBlank(message = "To unit is required")
  private String toUnit;

  public ConversionRequest() {}

  public ConversionRequest(String recipeName, String ingredient, double amount, String fromUnit, String toUnit) {
    this.recipeName = recipeName;
    this.ingredient = ingredient;
    this.amount = amount;
    this.fromUnit = fromUnit;
    this.toUnit = toUnit;
  }

  public String getRecipeName() {
    return recipeName;
  }

  public String getIngredient() {
    return ingredient;
  }

  public double getAmount() {
    return amount;
  }

  public String getFromUnit() {
    return fromUnit;
  }

  public String getToUnit() {
    return toUnit;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public void setIngredient(String ingredient) {
    this.ingredient = ingredient;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setFromUnit(String fromUnit) {
    this.fromUnit = fromUnit;
  }

  public void setToUnit(String toUnit) {
    this.toUnit = toUnit;
  }
}
