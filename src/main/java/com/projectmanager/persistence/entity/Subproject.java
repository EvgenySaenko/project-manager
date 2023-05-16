package com.projectmanager.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subproject")
@Getter
@Setter
public class Subproject extends PersistableEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "subproject", fetch = FetchType.LAZY)
//    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Task> tasks;
}
