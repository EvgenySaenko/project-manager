package com.projectmanager;

import com.projectmanager.model.view.ProjectView;
import com.projectmanager.model.view.ProjectViewFull;
import com.projectmanager.model.view.SubprojectView;
import com.projectmanager.model.view.TaskView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AbstractTest {

    protected ProjectView createProjectView(String name) {
        return ProjectView.builder().name(name).build();
    }

    protected ProjectViewFull createProjectViewFull(Long projectId,
                                                    String projectName,
                                                    List<SubprojectView> subprojectViews,
                                                    List<TaskView> taskViews) {
        return ProjectViewFull.builder().
                id(projectId).
                name(projectName).
                subprojects(subprojectViews).
                tasks(taskViews).
        build();
    }

    protected List<ProjectView> createListProjectView(String...names) {
        return Arrays.stream(names).
                map(this::createProjectView).
                collect(Collectors.toList());
    }
}
