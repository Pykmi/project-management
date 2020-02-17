package io.pykmi.pma.controllers;

import io.pykmi.pma.dao.EmployeeRepository;
import io.pykmi.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository repo;

    @GetMapping("")
    public String redirectToList() {
        return "redirect:/employees/list";
    }

    @GetMapping("/list")
    public String employees(Model model) {
        List<Employee> employeeList = this.repo.findAll();
        model.addAttribute("employeeList", employeeList);

        Employee employeeForm = new Employee();
        model.addAttribute("employeeForm", employeeForm);

        return "employees";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee) {
        this.repo.save(employee);
        return "redirect:/employees/list";
    }
}
