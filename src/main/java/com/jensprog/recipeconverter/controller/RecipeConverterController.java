package com.jensprog.recipeconverter.controller;

import com.jensprog.recipeconverter.error.IncompatibleUnitException;
import com.jensprog.recipeconverter.model.ConversionRequest;
import com.jensprog.recipeconverter.model.ConversionResult;
import com.jensprog.recipeconverter.service.RecipeConversionService;
import com.jensprog.recipeconverter.service.SessionStorageManagement;
import com.jensprog.recipeconverter.validation.RequestValidator;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller that handles recipe conversion requests and manages conversion results in the session.
 */
@Controller
public class RecipeConverterController {
  private final RecipeConversionService recipeConversionService;
  private final RequestValidator requestValidator;
  private final SessionStorageManagement sessionStorageManagement;

  public RecipeConverterController(RecipeConversionService recipeConversionService, RequestValidator requestValidator, SessionStorageManagement sessionStorageManagement) {
    this.recipeConversionService = recipeConversionService;
    this.requestValidator = requestValidator;
    this.sessionStorageManagement = sessionStorageManagement;
  }

  @GetMapping("/convert")
  public String showConversionForm() {
    return "convert";
  }

  @PostMapping("/convert")
  public String convertRecipe(
      @ModelAttribute ConversionRequest conversionRequest, BindingResult bindingResult,
      HttpSession session, Model model) {

    requestValidator.validate(conversionRequest, bindingResult);

    if (bindingResult.hasErrors()) {
      model.addAttribute("bindingResult", bindingResult);
      return "convert";
    }

    ConversionResult result = recipeConversionService.convertRecipe(conversionRequest);
    List<ConversionResult> conversionResults = sessionStorageManagement.getConversionHistory(session);
    conversionResults.add(result);
    session.setAttribute("conversionResults", conversionResults);
    return "redirect:/convert";
  }

  @ExceptionHandler(IncompatibleUnitException.class)
  public String handleIncompatibleUnitException(IncompatibleUnitException error, Model model) {
    model.addAttribute("errorMessage", error.getMessage());
    return "convert";
  }
}