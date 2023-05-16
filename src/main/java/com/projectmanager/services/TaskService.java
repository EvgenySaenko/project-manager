package com.projectmanager.services;

import com.projectmanager.model.dto.TaskDto;
import com.projectmanager.persistence.entity.Project;
import com.projectmanager.persistence.entity.Task;
import com.projectmanager.repositories.ProjectRepository;
import com.projectmanager.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    public final TaskRepository taskRepository;
    public final ProjectRepository projectRepository;

    public List<Task> getTasksByProject(Long projectId){
        Project project = projectRepository.
                findById(projectId).
                orElseThrow(()-> new RuntimeException("Project with id: " + projectId + " does not exist"));
        List<Task> tasks = project.getTasks();
        return tasks;
    }




    public List<Task> createProjectTask(TaskDto taskDto, Long projectId, Principal principal) {
        return taskRepository.findAll();
    }
}
