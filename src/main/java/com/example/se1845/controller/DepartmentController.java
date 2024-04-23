package com.example.se1845.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.se1845.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/listAll")
    public String getAllDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "DepartmentsManage.html";
    }
    
}
