package com.mii.clinetapp.controllers;

import com.mii.clinetapp.models.Department;
import com.mii.clinetapp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("departments", departmentService.getAll());
        return "home/departments/index";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        model.addAttribute("department", departmentService.getById(id));
        return "home/departments/detail-department";
    }

    @GetMapping("/form-department")
    public String getForm(Model model){
        Department department = new Department();
        model.addAttribute("department",department);
        return "home/departments/create-dept";
    }

    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") Department department){
        departmentService.createDept(department);
        return "redirect:/department";
    }

//    @GetMapping("/create")
//    public String createViewDept() {
//
//        Department department = Department.builder()
//                .name("KM")
//                .build();
//
//        departmentService.createDept(department);
//
//        return "home/departments/create";
//    }
}
