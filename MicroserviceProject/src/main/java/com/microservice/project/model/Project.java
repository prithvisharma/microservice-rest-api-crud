package com.microservice.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.microservice.project.enums.Status;
import com.microservice.project.enums.Team;
import com.microservice.project.enums.WorkProcess;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false , nullable = false)
	private long id;
	private String projectName;
	private String startDate;
	private String endDate;
	
	private String task;
	
	@Enumerated(EnumType.STRING)
	private Status status; 
	@Enumerated(EnumType.STRING)
	private WorkProcess workProcess; 
	@Enumerated(EnumType.STRING)
	private Team team;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public WorkProcess getWorkProcess() {
		return workProcess;
	}
	public void setWorkProcess(WorkProcess workProcess) {
		this.workProcess = workProcess;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	} 
	
	
	
	
}
