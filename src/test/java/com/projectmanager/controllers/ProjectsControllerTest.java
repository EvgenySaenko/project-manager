package com.projectmanager.controllers;

import java.util.List;
import static org.hamcrest.Matchers.*;
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
        ProjectView projectView = createProjectView("Project 1");
        Mockito.when(projectService.getProjectById(1L)).thenReturn(projectView);

        mockMvc.perform(get("/projects/1").
                        contentType(MediaType.APPLICATION_JSON).
                        accept(MediaType.APPLICATION_JSON)
        ).andDo(print()).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.name").value("Project 1")).
                andDo(print());
    }
}