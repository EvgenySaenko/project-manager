package com.projectmanager.controllers;

import com.projectmanager.model.view.ProjectView;
import com.projectmanager.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public List<ProjectView> getProjects(){
        return projectService.getProjects();
    }

    @GetMapping("/{id}")
    public ProjectView getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

}
