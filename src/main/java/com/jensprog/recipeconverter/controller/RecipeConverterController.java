package com.jensprog.recipeconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecipeConverterController {

  @GetMapping("/convert")
  public String showConversionForm() {
    return "convert";
  }
}
