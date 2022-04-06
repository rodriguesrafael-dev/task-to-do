package br.com.tasktodo.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tasktodo.entity.TaskStattusEntity;
import br.com.tasktodo.services.TaskStattusServices;
import lombok.Data;

@Data
@Component
@ManagedBean(name = "taskStattusManagedBean")
@SessionScoped
public class TaskStattusManagedBean {
		
	@Autowired
	public TaskStattusServices taskStattusServices;
	
	private TaskStattusEntity taskStattusEntity;
	
	private List<TaskStattusEntity> taskStattusList;
	
	public void taskStattusInit() {
		this.taskStattusServices.taskStattusInit();
	}
	
	public List<TaskStattusEntity> taskStattusList() {
		this.taskStattusList = taskStattusServices.findAll();
		return taskStattusList;
	}
	
}
