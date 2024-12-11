package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Footballer;
import com.example.demo.service.FootballerService;

@Controller
public class FootballerController {

    @Autowired
    private FootballerService footballerService;

    // Display the list of personnel
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listFootballers", footballerService.getAllFootballers());
        return "index";
    }

    @GetMapping("/showNewFootballerForm")
    public String showNewFootballerForm(Model model) {
        Footballer footballer = new Footballer();
        model.addAttribute("footballer", footballer);
        return "new_footballer";
    }

    @PostMapping("/saveFootballer")
    public String saveFootballer(@ModelAttribute("footballer") Footballer footballer) {
        footballerService.saveFootballer(footballer);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Footballer footballer = footballerService.getFootballerById(id);

        model.addAttribute("footballer", footballer);
        return "update_footballer";
    }

    @GetMapping("/deleteFootballer/{id}")
    public String deleteFootballer(@PathVariable(value = "id") long id) {
        this.footballerService.deleteFootballerById(id);
        return "redirect:/";
    }
}
