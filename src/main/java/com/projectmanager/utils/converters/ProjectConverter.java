package com.projectmanager.utils.converters;

import com.projectmanager.model.view.ProjectView;
import com.projectmanager.persistence.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectConverter {

    public ProjectView convertToProjectView(Project project) {
        return ProjectView.builder().
                name(project.getName()).
                build();
    }

}
