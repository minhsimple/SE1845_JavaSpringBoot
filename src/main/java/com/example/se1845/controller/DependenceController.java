package com.example.se1845.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.se1845.service.DependenceService;

@Controller
@RequestMapping("/dependences")
public class DependenceController {
    
    @Autowired
    private DependenceService dependenceService;

    @GetMapping("/listAll")
    public String getAllDependences(Model model) {
        model.addAttribute("dependences", dependenceService.getAllDependence());
        return "DependencesManage.html";
    }
}
