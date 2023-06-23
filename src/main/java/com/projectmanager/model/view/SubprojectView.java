package com.projectmanager.model.view;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class SubprojectView {
    private Long id;
    private String name;
}
