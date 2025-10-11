package com.jensprog.recipeconverter.service;

import com.jensprog.recipeconverter.model.ConversionRequest;
import com.jensprog.unitconverter.UnitConversionService;
import org.springframework.stereotype.Service;

@Service
public class RecipeConversionService {
  private final UnitConversionService unitConversionService;

  public RecipeConversionService(UnitConversionService unitConversionService) {
    this.unitConversionService = unitConversionService;
  }

  public double convert(ConversionRequest conversionRequest) {
    return unitConversionService.convert(
        conversionRequest.getAmount(),
        conversionRequest.getFromUnit(),
        conversionRequest.getToUnit()
    );
  }
}
