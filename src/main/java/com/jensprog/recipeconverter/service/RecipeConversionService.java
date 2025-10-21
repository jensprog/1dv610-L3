package com.jensprog.recipeconverter.service;

import com.jensprog.recipeconverter.error.IncompatibleUnitException;
import com.jensprog.recipeconverter.model.ConversionRequest;
import com.jensprog.recipeconverter.model.ConversionResult;
import com.jensprog.unitconverter.UnitConversionService;
import org.springframework.stereotype.Service;

/**
 * Service that uses UnitConversionService module to perform unit conversions.
 */
@Service
public class RecipeConversionService {
  private final UnitConversionService unitConversionService;

  public RecipeConversionService(UnitConversionService unitConversionService) {
    this.unitConversionService = unitConversionService;
  }

  public ConversionResult convertRecipe(ConversionRequest conversionRequest) {
    double convertedValue = convert(conversionRequest);
    return new ConversionResult(conversionRequest, convertedValue);
  }

  public double convert(ConversionRequest conversionRequest) {
    try { 
      return unitConversionService.convert(
        conversionRequest.getAmount(),
        conversionRequest.getFromUnit(),
        conversionRequest.getToUnit()
    );
    } catch (IllegalArgumentException error) {
      throw new IncompatibleUnitException(error.getMessage());
    }
  }
}
