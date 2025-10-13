package com.jensprog.recipeconverter.service;

import com.jensprog.recipeconverter.model.ConversionResult;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

@Service
public class SessionStorageManagement {
  public List<ConversionResult> getConversionHistory(HttpSession session) {
    @SuppressWarnings("unchecked")
    List<ConversionResult> result = (List<ConversionResult>) session.getAttribute("conversionResults");
    return result != null ? result : new ArrayList<>();
  }
}
