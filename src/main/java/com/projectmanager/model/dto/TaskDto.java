package com.projectmanager.model.dto;


import com.projectmanager.model.enums.Status;
import com.projectmanager.model.enums.Type;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class TaskDto {
    private String name;
    private Type type;
    private Status status;
    private String description;
}
