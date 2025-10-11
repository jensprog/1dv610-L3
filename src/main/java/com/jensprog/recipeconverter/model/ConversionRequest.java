package com.jensprog.recipeconverter.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ConversionRequest {
  @NotBlank(message = "Recipe name is required")
  private String recipeName;

  @NotNull(message = "Amount is required")
  @DecimalMin(value = "0.1", message = "Amount must be greater than 0")
  private double amount;

  @NotBlank(message = "From unit is required")
  private String fromUnit;

  @NotBlank(message = "To unit is required")
  private String toUnit;

  public ConversionRequest() {}

  public ConversionRequest(String recipeName, double amount, String fromUnit, String toUnit) {
    this.recipeName = recipeName;
    this.amount = amount;
    this.fromUnit = fromUnit;
    this.toUnit = toUnit;
  }

  public String getRecipeName() {
    return recipeName;
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
