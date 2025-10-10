package com.jensprog.recipeconverter.service;

import com.jensprog.unitconverter.UnitConversionService;

public class RecipeConversionService {
  private final UnitConversionService unitConversionService;

  public RecipeConversionService(UnitConversionService unitConversionService) {
    this.unitConversionService = unitConversionService;
  }

}
