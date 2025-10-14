package com.jensprog.recipeconverter.service;

import com.jensprog.recipeconverter.model.ConversionResult;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SessionStorageManagement {
  public List<ConversionResult> getConversionHistory(HttpSession session) {
    @SuppressWarnings("unchecked")
    List<ConversionResult> result = (List<ConversionResult>) session.getAttribute("conversionResults");
    return result != null ? result : new ArrayList<>();
  }

  private boolean hasConversions(HttpSession session) {
    return session != null && !getConversionHistory(session).isEmpty();
  }

  public void removeConversionByIndex(HttpSession session, int index) {
    if (hasConversions(session)) {
      @SuppressWarnings("unchecked")
      List<ConversionResult> results = (List<ConversionResult>) session.getAttribute("conversionResults");

      if (results != null && !results.isEmpty() && index >= 0 && index < results.size()) {
        results.remove(index);
        session.setAttribute("conversionResults", results);
      }
    }
  }

  public void clearAllHistory(HttpSession session) {
    if (hasConversions(session)) {
      session.removeAttribute("conversionResults");
    }
  }
}
