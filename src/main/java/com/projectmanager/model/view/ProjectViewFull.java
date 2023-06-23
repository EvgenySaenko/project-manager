package com.projectmanager.model.view;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class ProjectViewFull {
    private Long id;
    private String name;
    private List<SubprojectView> subprojects;
    private List<TaskView> tasks;
}
