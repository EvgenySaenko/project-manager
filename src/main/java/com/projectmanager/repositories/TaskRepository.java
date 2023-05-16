package com.projectmanager.repositories;

import com.projectmanager.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
//    List<Task> getTasksByProject(@Param("projectId") Long projectId);

}
