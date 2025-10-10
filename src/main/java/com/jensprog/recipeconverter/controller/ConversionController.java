package com.jensprog.recipeconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConversionController {
  @GetMapping("/convert")
  public String convert() {
    return "convert";
  }
}
