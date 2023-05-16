package com.projectmanager.repositories;

import com.projectmanager.persistence.entity.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
//    @EntityGraph(value = "Project.tasks",type = EntityGraph.EntityGraphType.FETCH)
//    Optional<Project> findById(Long id);
}
