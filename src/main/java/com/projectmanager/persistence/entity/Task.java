package com.projectmanager.persistence.entity;

import com.projectmanager.model.enums.Status;
import com.projectmanager.model.enums.Type;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Getter
@Setter
//@NamedQueries({
//        @NamedQuery(name = "Task.getTasksByProject",
//                    query = "SELECT t FROM Task t INNER JOIN t.project p WHERE p.id = :projectId")
//})
public class Task extends PersistableEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subproject_id")
    private Subproject subproject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User user;

}
