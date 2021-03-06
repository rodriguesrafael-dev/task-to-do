package br.com.tasktodo.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tasktodo.entity.TaskEntity;
import br.com.tasktodo.services.TaskServices;
import lombok.Data;

@Data
@Component
@ManagedBean(name = "taskManagedBean")
@ViewScoped
public class TaskManagedBean {

	@Autowired
	public TaskServices taskServices;
	
	private TaskEntity taskEntity;
	
	public List<TaskEntity> taskListTest;	
	
	public List<TaskEntity> listTaskFilter = new ArrayList<TaskEntity>();
	
	public String getBackHome() {
		this.taskEntity = new TaskEntity();
		return "index?faces-redirect=true";
	}
	
	public String getTaskCreate() {
		this.taskEntity = new TaskEntity();
		return "taskCreate?faces-redirect=true";
	}
	
	public String getTaskList() {
		this.taskEntity = new TaskEntity();
		return "taskList?faces-redirect=true";
	}
	
	public String getTaskEdit(TaskEntity taskEntity) {
		this.taskEntity = taskEntity;
		return "taskEdit?faces-redirect=true";
	}
	
	public String save() {
		this.taskServices.create(taskEntity);
		taskEntity = new TaskEntity();
		return "taskList?faces-redirect=true";
	}
	
	public String update(TaskEntity taskEntity) {
		this.taskServices.update(this.taskEntity);
		this.taskEntity = new TaskEntity();
		return "taskList?faces-redirect=true";
	}
	
	public String updateTaskStattus(TaskEntity taskEntity) {
		taskEntity.getTaskStattusEntity().setId(2L);
		this.taskServices.update(taskEntity);
		return "taskList?faces-redirect=true";
	}
	
	public String delete(TaskEntity taskEntity) {
		this.taskServices.delete(taskEntity);
		return "taskList?faces-redirect=true";
	}
	
	public List<TaskEntity> findAll() {
		this.taskListTest = taskServices.findAll();
		return taskListTest;
	}
	
	public List<TaskEntity> listTaskFilter(long id, String title, String userEntity, String taskStattusEntity) {		
		listTaskFilter = taskServices.listTaskFilter(id, title, userEntity, taskStattusEntity);	
		this.taskEntity = new TaskEntity();
		return listTaskFilter;
	}
	
	public List<TaskEntity> listByTaskStattus() {
		this.taskListTest = taskServices.listTaskStattus();
		this.taskEntity = new TaskEntity();
		return taskListTest;
	}
	
}
