package io.pykmi.pma.controllers;

import io.pykmi.pma.dao.EmployeeRepository;
import io.pykmi.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository repo;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        this.repo.save(employee);
        return "redirect:/employee/new";
    }
}
