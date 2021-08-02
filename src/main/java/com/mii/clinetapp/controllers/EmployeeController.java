package com.mii.clinetapp.controllers;

import com.mii.clinetapp.models.Department;
import com.mii.clinetapp.models.Employee;
import com.mii.clinetapp.services.DepartmentService;
import com.mii.clinetapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;
//    private DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "home/employees/index";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        model.addAttribute("employee", employeeService.getById(id));
        return "home/employees/get-by-id";
    }

    @GetMapping("/add")
    public String getForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "home/employees/create-emp";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.createEmp(employee);
        return "redirect:/employee";
    }
}
