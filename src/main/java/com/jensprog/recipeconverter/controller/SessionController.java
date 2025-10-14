package com.jensprog.recipeconverter.controller;

import com.jensprog.recipeconverter.model.ConversionResult;
import com.jensprog.recipeconverter.service.SessionStorageManagement;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/session")
public class SessionController {
  private final SessionStorageManagement sessionStorageManagement;

  public SessionController(SessionStorageManagement sessionStorageManagement) {
    this.sessionStorageManagement = sessionStorageManagement;
  }

  @GetMapping("/history")
  public String getConversionHistory(HttpSession session, Model model) {
    List<ConversionResult> history = sessionStorageManagement.getConversionHistory(session);
    model.addAttribute("conversionHistory", history);
    return "history";
  }

  @PostMapping("/remove")
  public String removeConversionByIndex(HttpSession session, @RequestParam int index) {
    sessionStorageManagement.removeConversionByIndex(session, index);
    return "redirect:/session/history";
  }

  @PostMapping("/clear")
  public String clearConversionHistory(HttpSession session) {
    sessionStorageManagement.clearAllHistory(session);
    return "redirect:/session/history";
  }
}
