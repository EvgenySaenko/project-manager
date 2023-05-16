package com.projectmanager.controllers;

import com.projectmanager.model.view.TaskView;
import com.projectmanager.persistence.entity.Task;
import com.projectmanager.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


//    @PostMapping("/projects/{project_id}/tasks")
//    public Task createProjectTask(@RequestBody TaskDto taskDto,
//                                  @PathVariable(name = "project_id") Long projectId,
//                                  Principal principal) {
//        return taskService.createProjectTask(taskDto, projectId, principal);
//
//    }
    @GetMapping("projects/{project_id}/tasks")
    public List<Task> getTasksByProject(@PathVariable(name = "project_id") Long projectId ) {
        return taskService.getTasksByProject(projectId);
    }


}
