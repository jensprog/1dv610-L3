package com.jensprog.recipeconverter.controller;

import com.jensprog.recipeconverter.error.IncompatibleUnitException;
import com.jensprog.recipeconverter.model.ConversionRequest;
import com.jensprog.recipeconverter.model.ConversionResult;
import com.jensprog.recipeconverter.service.RecipeConversionService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("conversionResults")
@Controller
public class RecipeConverterController {
  private final RecipeConversionService recipeConversionService;

  public RecipeConverterController(RecipeConversionService recipeConversionService) {
    this.recipeConversionService = recipeConversionService;
  }

  @GetMapping("/convert")
  public String showConversionForm() {
    return "convert";
  }

  @PostMapping("/convert")
  public String convertRecipe(
      @Valid ConversionRequest conversionRequest,
      @ModelAttribute("conversionResults") List<ConversionResult> conversionResults, Model model) {

    double convertedValue = recipeConversionService.convert(conversionRequest);
    ConversionResult result = new ConversionResult(conversionRequest, recipeConversionService, 
        convertedValue);

    conversionResults.add(result);
    model.addAttribute("recipeName", result.getRecipeName());
    model.addAttribute("ingredient", result.getIngredient());
    model.addAttribute("originalValue", result.getAmount());
    model.addAttribute("fromUnit", result.getFromUnit());
    model.addAttribute("toUnit", result.getToUnit());
    model.addAttribute("convertedValue", result.getConvertedValue());
    model.addAttribute("result", result);
    return "result";
  }

  @ExceptionHandler(IncompatibleUnitException.class)
  public String handleIncompatibleUnitException(IncompatibleUnitException error, Model model) {
    model.addAttribute("errorMessage", error.getMessage());
    return "convert";
  }

  @ModelAttribute("conversionResults")
  public List<ConversionResult> addConversionResults() {
    return new ArrayList<>();
  }
}