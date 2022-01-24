package com.example.sda.travelagencyservice.controller;

import com.example.sda.travelagencyservice.dto.ContinentDto;
import com.example.sda.travelagencyservice.service.ContinentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContinentController {

    private ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping("/continent/list")
    public String getAllContinents(Model model) {
        List<ContinentDto> continentDtos = continentService.getAllContinents();
        model.addAttribute("continents", continentDtos);
        return "continentList";
    }

    @GetMapping("/panel/add/continent")
    public String createContinent(Model model) {
        model.addAttribute("continent", new ContinentDto());

        return "addContinent";
    }

    @PostMapping("/panel/add/continent")
    public String createContinent(@ModelAttribute("continent") ContinentDto continentDto) throws Exception {
        System.out.println("Dane: " + continentDto);
        continentService.saveContinent(continentDto);
        return "redirect:/continent/list";
    }
}
