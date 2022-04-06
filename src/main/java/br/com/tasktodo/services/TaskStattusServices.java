package br.com.tasktodo.services;

import java.util.List;

import br.com.tasktodo.entity.TaskStattusEntity;

public interface TaskStattusServices {

	public void create(TaskStattusEntity priorityEntity);
	
	public void taskStattusInit();
	
	public List<TaskStattusEntity> findAll();
	
}
