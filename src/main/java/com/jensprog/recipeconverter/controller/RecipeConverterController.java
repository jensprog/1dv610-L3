package com.jensprog.recipeconverter.controller;

import com.jensprog.recipeconverter.model.ConversionRequest;
import com.jensprog.recipeconverter.service.RecipeConversionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
      @Valid ConversionRequest conversionRequest, Model model) {
    double convertedValue = recipeConversionService.convert(conversionRequest);
    model.addAttribute("recipeName", conversionRequest.getRecipeName());
    model.addAttribute("originalValue", conversionRequest.getAmount());
    model.addAttribute("fromUnit", conversionRequest.getFromUnit());
    model.addAttribute("toUnit", conversionRequest.getToUnit());
    model.addAttribute("convertedValue", convertedValue);
    return "result";
  }
}