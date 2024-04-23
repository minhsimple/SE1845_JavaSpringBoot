package com.example.se1845.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.se1845.dto.EmployeeDTO;
import com.example.se1845.service.EmployeeService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/listAll")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "EmployeesManage.html";
    }

    @GetMapping("/search")
    public String getEmployeeBySsn(Model model, @RequestParam String ssn) {
        List<EmployeeDTO> empList = new ArrayList<>();
        EmployeeDTO employeeDto = employeeService.getEmployeeById(ssn);
        if (employeeDto != null) {
            empList.add(employeeDto);
        }
        model.addAttribute("employees", empList);
        return "EmployeesManage.html";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(@ModelAttribute("employeeDto") EmployeeDTO employeeDto) {
        return "AddEmployeeForm";
    }

    @PostMapping("/add")
    public String addEmployee(Model model, @ModelAttribute("employeeDto") EmployeeDTO employeeDto) {
        employeeService.createEmployee(employeeDto);
        return "redirect:/employees/listAll";
    }
}
