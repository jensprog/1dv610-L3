package com.jensprog.recipeconverter.config;

import com.jensprog.unitconverter.UnitConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnitConversionConfig {
  @Bean
  UnitConversionService unitConversionService() {
    return new UnitConversionService();
  }
}
