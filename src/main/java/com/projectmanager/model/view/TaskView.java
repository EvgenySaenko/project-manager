package com.projectmanager.model.view;

import com.projectmanager.model.enums.Status;
import com.projectmanager.model.enums.Type;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class TaskView {
    private String name;
    private Type type;
    private Status status;
    private String description;
    private String creationDateTime;
    private String updateDateTime;
    private String ownerUsername;
}
