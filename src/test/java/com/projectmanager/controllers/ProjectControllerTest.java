package com.projectmanager.controllers;

import java.util.List;
import static org.hamcrest.Matchers.*;

import com.projectmanager.model.enums.Status;
import com.projectmanager.model.enums.Type;
import com.projectmanager.model.view.ProjectViewFull;
import com.projectmanager.model.view.SubprojectView;
import com.projectmanager.model.view.TaskView;
import org.mockito.Mockito;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectmanager.AbstractTest;
import com.projectmanager.model.view.ProjectView;
import com.projectmanager.services.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(controllers = ProjectController.class)
class ProjectControllerTest extends AbstractTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProjectService projectService;

    @Test
    void getProjects() throws Exception {
        List<ProjectView> listProjectView = createListProjectView("Project 1", "Project 2", "Project 3");

        Mockito.when(projectService.getProjects()).thenReturn(listProjectView);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/projects").
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON).
                content(this.objectMapper.writeValueAsBytes(listProjectView));

        mockMvc.perform(mockRequest).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", notNullValue())).
                andExpect(jsonPath("$").isArray()).
                andExpect(jsonPath("$", hasSize(3))).
                andExpect(jsonPath("$[0].name", is(listProjectView.get(0).getName()))).andDo(print());
    }

    @Test
    void getProjectById() throws Exception {
        List<SubprojectView> subprojects = List.of(new SubprojectView(1L,"Subproject1"),
                                                   new SubprojectView(2L,"Subproject2"),
                                                   new SubprojectView(3L,"Subproject3"));

        TaskView taskView1 = TaskView.builder().
                             id(1L).
                             name("Task 1").
                             type(Type.MANAGER).
                             status(Status.NEW).
                             description("A complete description of the task that needs to be fixed!").
                             creationDateTime("10:46 23:06:2023").
                             updateDateTime("10:46 23:06:2023").
                             ownerUsername("user").build();

        TaskView taskView2 = TaskView.builder().
                id(2L).
                name("Task 2").
                type(Type.TECHNICAL_SPECIALIST).
                status(Status.NEW).
                description("A complete description of the task that needs to be fixed!").
                creationDateTime("10:46 23:06:2023").
                updateDateTime("10:46 23:06:2023").
                ownerUsername("user").build();

        List<TaskView> tasks = List.of(taskView1, taskView2);

        ProjectViewFull projectView = createProjectViewFull(1L, "Project 1", subprojects, tasks);
        Mockito.when(projectService.getProjectById(1L)).thenReturn(projectView);

        mockMvc.perform(get("/projects/1").
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON)
        ).andDo(print()).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.name").value("Project 1")).
                andExpect(jsonPath("$.subprojects.length()").value(subprojects.size())).
                andExpect(jsonPath("$.subprojects.[0].id", is(1))).
                andExpect(jsonPath("$.subprojects.[1].id", is(2))).
                andExpect(jsonPath("$.subprojects.[2].id", is(3))).
                andExpect(jsonPath("$.subprojects.[0].name", is("Subproject1"))).
                andExpect(jsonPath("$.subprojects.[1].name", is("Subproject2"))).
                andExpect(jsonPath("$.subprojects.[2].name", is("Subproject3"))).
                andExpect(jsonPath("$.tasks.length()").value(tasks.size())).
                andExpect(jsonPath("$.tasks.[0].id", is(1))).
                andExpect(jsonPath("$.tasks.[0].name", is("Task 1"))).
                andExpect(jsonPath("$.tasks.[0].type", is(Type.MANAGER.toString()))).
                andExpect(jsonPath("$.tasks.[0].status", is(Status.NEW.toString()))).
                andExpect(jsonPath("$.tasks.[0].description", is("A complete description of the task that needs to be fixed!"))).
                andExpect(jsonPath("$.tasks.[0].ownerUsername", is("user"))).
                andDo(print());
    }
}