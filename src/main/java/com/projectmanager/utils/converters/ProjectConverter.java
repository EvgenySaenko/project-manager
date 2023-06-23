package com.projectmanager.utils.converters;

import com.projectmanager.model.view.ProjectView;
import com.projectmanager.model.view.ProjectViewFull;
import com.projectmanager.persistence.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectConverter {

    private final SubprojectConverter subprojectConverter;
    private final TaskConverter taskConverter;

    public ProjectView convertToProjectView(Project project) {
        return ProjectView.builder().
                id(project.getId()).
                name(project.getName()).
                build();
    }

    public ProjectViewFull convertToProjectViewFull(Project project) {
        return ProjectViewFull.builder().
                id(project.getId()).
                name(project.getName()).
                subprojects(project.getSubprojects().
                        stream().
                        map(subprojectConverter::convertToSubprojectView).
                        collect(Collectors.toList())).
                tasks(project.getTasks().
                      stream().
                      map(taskConverter::convertToTaskView).
                      collect(Collectors.toList())).
                build();
    }

}
