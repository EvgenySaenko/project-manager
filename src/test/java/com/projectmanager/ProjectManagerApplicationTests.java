package com.projectmanager;

import com.projectmanager.controllers.ProjectController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectManagerApplicationTests {
	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		assertNotNull(context);
		ProjectController projectController = context.getBean(ProjectController.class);
		assertNotNull(projectController);
	}
}
