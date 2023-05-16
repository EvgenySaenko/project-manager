package com.projectmanager.services;

import com.projectmanager.model.view.ProjectView;
import com.projectmanager.repositories.ProjectRepository;
import com.projectmanager.utils.converters.ProjectConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectConverter projectConverter;

    public List<ProjectView> getProjects(){
        return projectRepository.findAll().stream().map(projectConverter::convertToProjectView).collect(Collectors.toList());
    }

    public ProjectView getProjectById(Long id){
        return projectRepository.findById(id).
                map(projectConverter::convertToProjectView).
                orElseThrow(() -> new RuntimeException("Project with id: " + id + " does not exist"));
    }

//    public List<ProjectView> getProjectsWithSubprojectsAndTasks() {
//        return projectRepository.findAll().stream().map(projectConverter::convertToProjectView).collect(Collectors.toList());
//    }

}
