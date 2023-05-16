package com.projectmanager.persistence.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
//@NamedEntityGraphs({
//        @NamedEntityGraph(name = "Project.subprojects", attributeNodes = @NamedAttributeNode("subprojects")),
//        @NamedEntityGraph(name = "Project.tasks", attributeNodes = @NamedAttributeNode("tasks"))
//})
public class Project extends PersistableEntity{
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    //@LazyCollection(LazyCollectionOption.EXTRA)
    private List<Subproject> subprojects;


    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    //@LazyCollection(LazyCollectionOption.EXTRA)
    private List<Task> tasks;

}
