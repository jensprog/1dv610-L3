package com.jensprog.recipeconverter.model;

import com.jensprog.recipeconverter.service.RecipeConversionService;
import java.io.Serializable;

/**
 * Model that holds the output of a conversion, used by the RecipeConverterController to display the data.
 */
public class ConversionResult implements Serializable {
  private String recipeName;
  private String ingredient;
  private double amount;
  private String fromUnit;
  private String toUnit;
  private double convertedValue;

  public ConversionResult() {}

  public ConversionResult(ConversionRequest request, double convertedValue) {
    this.recipeName = request.getRecipeName();
    this.ingredient = request.getIngredient();
    this.amount = request.getAmount();
    this.fromUnit = request.getFromUnit();
    this.toUnit = request.getToUnit();
    this.convertedValue = convertedValue;
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

  public double getConvertedValue() {
    return convertedValue;
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

  public void setConvertedValue(double convertedValue) {
    this.convertedValue = convertedValue;
  }
}