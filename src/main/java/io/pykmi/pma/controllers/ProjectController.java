package io.pykmi.pma.controllers;

import io.pykmi.pma.dao.ProjectRepository;
import io.pykmi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository repo;

    @GetMapping("")
    public String redirectToList() { return "redirect:/projects/list"; }

    @GetMapping("/list")
    public String displayHome(Model model) {
        List<Project> projectList = this.repo.findAll();
        model.addAttribute("projectList", projectList);

        Project projectForm = new Project();
        model.addAttribute("projectForm", projectForm);

        return "projects";
    }

    @PostMapping("/save")
    public String createProject(Project project) {
        this.repo.save(project);
        return "redirect:/projects/list";
    }
}
