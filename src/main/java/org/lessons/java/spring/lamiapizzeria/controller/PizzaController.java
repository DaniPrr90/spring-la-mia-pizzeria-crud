package org.lessons.java.spring.lamiapizzeria.controller;

import java.util.List;

import org.lessons.java.spring.lamiapizzeria.model.Pizza;
import org.lessons.java.spring.lamiapizzeria.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Pizza> listapizze = pizzaRepository.findAll();
        model.addAttribute("pizze", listapizze);
        return "/pizze/fragments/index";
    }

    @GetMapping("/pizza")
    public String seePizza(@RequestParam(name = "query") String query, Model model) {
        // Troviamo tutte le pizze che contengono il nome della query
        List<Pizza> pizze = pizzaRepository.findByNomeContaining(query);

        if (query.equals("") || query.equals("")) {
            model.addAttribute("message", "Pizza non trovata");
            return "/pizze/fragments/pizza";
        } else {
            model.addAttribute("pizza", pizze);
            return "/pizze/fragments/pizza";
        }
    }

}
