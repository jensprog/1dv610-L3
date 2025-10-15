package com.jensprog.recipeconverter.model;

/**
 * Model that holds the users input data, used to perform a conversion by RecipeConversionService.
 */
public class ConversionRequest {
  private String recipeName;
  private String ingredient;
  private Double amount;
  private String fromUnit;
  private String toUnit;

  public ConversionRequest() {}

  public ConversionRequest(String recipeName, String ingredient, Double amount, String fromUnit, String toUnit) {
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

  public Double getAmount() {
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

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public void setFromUnit(String fromUnit) {
    this.fromUnit = fromUnit;
  }

  public void setToUnit(String toUnit) {
    this.toUnit = toUnit;
  }
}
