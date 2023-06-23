package com.projectmanager.model.view;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class ProjectView {
    private Long id;
    private String name;
}
