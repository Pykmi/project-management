package io.pykmi.pma.controllers;

import io.pykmi.pma.dao.EmployeeRepository;
import io.pykmi.pma.dao.ProjectRepository;
import io.pykmi.pma.entities.Employee;
import io.pykmi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projRepository;

    @Autowired
    EmployeeRepository emplRepository;

    @GetMapping("")
    public String redirectToList() { return "redirect:/projects/list"; }

    @GetMapping("/list")
    public String displayHome(Model model) {
        List<Project> projectList = this.projRepository.findAll();
        model.addAttribute("projectList", projectList);

        Project projectForm = new Project();
        List<Employee> employees = emplRepository.findAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("projectForm", projectForm);

        return "projects";
    }

    @PostMapping("/save")
    public String createProject(Project project, @RequestParam List<Long> employees) {
        this.projRepository.save(project);
        Iterable<Employee> selected = this.emplRepository.findAllById(employees);

        selected.forEach(employee -> {
            employee.setProject(project);
            emplRepository.save(employee);
        });

        return "redirect:/projects/list";
    }
}
