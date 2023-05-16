package com.projectmanager;

import com.projectmanager.model.view.ProjectView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AbstractTest {

    protected ProjectView createProjectView(String name) {
        return ProjectView.builder().name(name).build();
    }

    protected List<ProjectView> createListProjectView(String...names) {
        return Arrays.stream(names).
                map(this::createProjectView).
                collect(Collectors.toList());
    }
}
