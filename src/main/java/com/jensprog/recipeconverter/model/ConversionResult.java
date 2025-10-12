package com.jensprog.recipeconverter.model;

import com.jensprog.recipeconverter.service.RecipeConversionService;

public class ConversionResult {
  private String recipeName;
  private double amount;
  private String fromUnit;
  private String toUnit;
  private double convertedValue;

  public ConversionResult() {}

  public ConversionResult(ConversionRequest request, RecipeConversionService service) {
    this.recipeName = request.getRecipeName();
    this.amount = request.getAmount();
    this.fromUnit = request.getFromUnit();
    this.toUnit = request.getToUnit();
    this.convertedValue = calculateConversionResult(service);
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

  public double getConvertedValue() {
    return convertedValue;
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

  public void setConvertedValue(double convertedValue) {
    this.convertedValue = convertedValue;
  }

  public double calculateConversionResult(RecipeConversionService service) {
    ConversionRequest request = new ConversionRequest(recipeName, amount, fromUnit, toUnit);
    return service.convert(request);
  }
}