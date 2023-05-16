package com.projectmanager.utils.converters;

import com.projectmanager.model.view.TaskView;
import com.projectmanager.persistence.entity.Task;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;

@Component
public class TaskConverter {
    private DateTimeFormatter formatter;

    @PostConstruct
    public void init(){
        this.formatter = DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy");
    }

    public TaskView convertToTaskView(Task task) {
        return TaskView.builder().
                    name(task.getName()).
                    type(task.getType()).
                    status(task.getStatus()).
                    description(task.getDescription()).
                    creationDateTime(formatter.format(task.getCreatedAt())).
                    updateDateTime(formatter.format(task.getUpdatedAt())).
                    ownerUsername(task.getUser().getUsername()).
        build();
    }
}
