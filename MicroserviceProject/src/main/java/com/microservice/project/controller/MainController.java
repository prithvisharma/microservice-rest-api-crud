package com.microservice.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.project.enums.Status;
import com.microservice.project.enums.Team;
import com.microservice.project.enums.WorkProcess;
import com.microservice.project.model.Project;
import com.microservice.project.repository.ProjectRepository;



@RestController
public class MainController {

	@Autowired
	ProjectRepository projectRepository;
	
	Project project1 = new Project();
	Project project2 = new Project();
	Project project3 = new Project();
	
	@PostMapping("/project/savedefault")
	public String saveProject() {
		project1.setProjectName("Angular");
		project1.setStartDate("28/08/2020");
		project1.setEndDate("31/08/2020");
		project1.setTask("Task is to create a angular based web page with proper validations");
		project1.setStatus(Status.ACTIVE);
		project1.setTeam(Team.TEAM_1);
		project1.setWorkProcess(WorkProcess.AGILE);
		
		
		project2.setProjectName("Spring Boot");
		project2.setStartDate("27/07/2020");
		project2.setEndDate("28/08/2020");
		project2.setTask("Task is to create rest apis for basic crud operations");
		project2.setStatus(Status.ACTIVE);
		project2.setTeam(Team.TEAM_3);
		project2.setWorkProcess(WorkProcess.AGILE);
		
		
		project3.setProjectName("Python");
		project3.setStartDate("10/08/2020");
		project3.setEndDate("18/08/2020");
		project3.setTask("Task is to perform predictions and sentiment analysis");
		project3.setStatus(Status.ACTIVE);
		project3.setTeam(Team.TEAM_2);
		project3.setWorkProcess(WorkProcess.AGILE);
		
		projectRepository.save(project1);
		projectRepository.save(project2);
		projectRepository.save(project3);
		
		return "Projects Saved";
	}
	
	@PostMapping("/project/save")
	public String saveNewProject(@RequestBody Project apiProject) {
		Project project = new Project();
		project = projectRepository.save(apiProject);
		return "Project Added";
	}
	
	@GetMapping("/project/display")
	public List<Project> displayProjects(){
		List<Project> listProject = new ArrayList<Project>();
		
		listProject = projectRepository.findAll();
		
		return listProject;
	}
	
	@GetMapping("/project/display/{id}")
	public Optional<Project> fetchCustomerById( @PathVariable("id") long id){
		Optional<Project> project = Optional.of(new Project());
		
		project = projectRepository.findById(id);
		
		return project;
	}
	
	@PutMapping("/project/update")
	public String updateProject(@RequestBody Project apiProject) {
		Project project = new Project();
		project = projectRepository.save(apiProject);
		return "Project Updated";
	}
	
	@DeleteMapping("/project/delete/{id}")
	public String deleteProjectById( @PathVariable("id") long id){
		Project project = new Project();
		
		project = projectRepository.getOne(id);
		projectRepository.delete(project);
		
		return "Project Deleted";
	}
}
