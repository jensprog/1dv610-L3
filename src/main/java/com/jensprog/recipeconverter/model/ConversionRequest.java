package com.jensprog.recipeconverter.model;

public class ConversionRequest {
  private String recipeName;
  private double amount;
  private String fromUnit;
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

  public void setAmount (double amount) {
    this.amount = amount;
  }

  public void setFromUnit(String fromUnit) {
    this.fromUnit = fromUnit;
  }

  public void setToUnit(String toUnit) {
    this.toUnit = toUnit;
  }
}
