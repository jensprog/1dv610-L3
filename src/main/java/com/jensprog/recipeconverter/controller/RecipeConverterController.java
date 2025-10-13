package com.jensprog.recipeconverter.controller;

import com.jensprog.recipeconverter.model.ConversionRequest;
import com.jensprog.recipeconverter.model.ConversionResult;
import com.jensprog.recipeconverter.service.RecipeConversionService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
      @Valid ConversionRequest conversionRequest, @ModelAttribute("conversionResults") List<ConversionResult> conversionResults, Model model) {
    ConversionResult result = new ConversionResult(conversionRequest, recipeConversionService);
    conversionResults.add(result);
    model.addAttribute("recipeName", result.getRecipeName());
    model.addAttribute("originalValue", result.getAmount());
    model.addAttribute("fromUnit", result.getFromUnit());
    model.addAttribute("toUnit", result.getToUnit());
    model.addAttribute("convertedValue", result.getConvertedValue());
    model.addAttribute("result", result);
    return "result";
  }

  @ModelAttribute("conversionResults")
  public List<ConversionResult> addConversionResults() {
    return new ArrayList<>();
  }
}